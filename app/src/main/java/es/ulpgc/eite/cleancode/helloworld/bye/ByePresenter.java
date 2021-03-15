package es.ulpgc.eite.cleancode.helloworld.bye;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.helloworld.app.AppMediator;
import es.ulpgc.eite.cleancode.helloworld.app.ByeToHelloState;
import es.ulpgc.eite.cleancode.helloworld.app.HelloToByeState;


public class ByePresenter implements ByeContract.Presenter {

  public static String TAG = ByePresenter.class.getSimpleName();

  private WeakReference<ByeContract.View> view;
  private ByeState state;
  private ByeContract.Model model;
  private AppMediator mediator;

  public ByePresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getByeState();
  }

  @Override
  public void onResumeCalled() {
    Log.e(TAG, "onResumeCalled()");

    HelloToByeState savedState = getDataFromHelloScreen();
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

    state.byeMessage = "?";

    view.get().displayByeData(state);

    // call the model
    startByeMessageAsyncTask();
  }

  @Override
  public void goHelloButtonClicked() {
    ByeToHelloState newState = new ByeToHelloState(state.byeMessage);
    passDataToHelloScreen(newState);
    view.get().finishView();
  }


  private HelloToByeState getDataFromHelloScreen() {
    return mediator.getHelloToByeState();
  }

  private void passDataToHelloScreen(ByeToHelloState state) {
    mediator.setByeToHelloState(state);
  }

  @Override
  public void injectView(WeakReference<ByeContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ByeContract.Model model) {
    this.model = model;
  }
}
