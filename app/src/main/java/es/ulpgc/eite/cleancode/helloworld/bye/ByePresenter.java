package es.ulpgc.eite.cleancode.helloworld.bye;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.helloworld.app.ByeToHelloState;
import es.ulpgc.eite.cleancode.helloworld.app.HelloToByeState;


public class ByePresenter implements ByeContract.Presenter {

  public static String TAG = ByePresenter.class.getSimpleName();

  private WeakReference<ByeContract.View> view;
  private ByeState state;
  private ByeContract.Model model;
  private ByeContract.Router router;


  public ByePresenter(ByeState state) {
    this.state = state;
  }

  @Override
  public void injectView(WeakReference<ByeContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ByeContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ByeContract.Router router) {
    this.router = router;
  }

  @Override
  public void onResumeCalled() {
    Log.e(TAG, "onResumeCalled()");

    HelloToByeState savedState = router.getDataFromHelloScreen();
    if(savedState != null){

      // set passed state
      state.byeMessage = savedState.message;
    }

    view.get().displayByeData(state);
  }

  private void startByeMessageAsyncTask() {
    Log.e(TAG, "startByeMessageAsyncTask()");

    String message = model.getByeMessage();
    state.byeMessage = message;

    view.get().displayByeData(state);
  }

  @Override
  public void sayByeButtonClicked() {
    Log.e(TAG, "sayByeButtonClicked()");

    state.byeMessage = "";

    view.get().displayByeData(state);

    // call the model
    startByeMessageAsyncTask();
  }

  @Override
  public void goHelloButtonClicked() {
    ByeToHelloState newState = new ByeToHelloState(state.byeMessage);
    router.passDataToHelloScreen(newState);
    view.get().finishView();
  }
}
