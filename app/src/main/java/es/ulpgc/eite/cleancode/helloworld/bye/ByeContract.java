package es.ulpgc.eite.cleancode.helloworld.bye;

import java.lang.ref.WeakReference;


public interface ByeContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayByeData(ByeViewModel viewModel);
    void finishView();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    //void injectRouter(Router router);

    void onResumeCalled();
    void sayByeButtonClicked();
    void goHelloButtonClicked();
  }

  interface Model {

    String getByeMessage();
  }

  /*
  interface Router {

    void passDataToHelloScreen(ByeToHelloState state);
    HelloToByeState getDataFromHelloScreen();
  }
  */

}