package es.ulpgc.eite.cleancode.helloworld.hello;

import java.lang.ref.WeakReference;

public interface HelloContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayHelloData(HelloViewModel viewModel);
    void navigateToByeScreen();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    //void injectRouter(Router router);

    void onResumeCalled();
    void sayHelloButtonClicked();
    void goByeButtonClicked();
  }

  interface Model {

    String getHelloMessage();
  }

  /*
  interface Router {

    ByeToHelloState getDataFromByeScreen();
    void passDataToByeScreen(HelloToByeState state);
    //void navigateToByeScreen();
  }
  */
}