package Main;

import Controller.ControllerSignIn;
import Model.ModelSignIn;
import View.ViewLogin;

public class MVCLogin {
    ViewLogin viewLogin = new ViewLogin();
    ModelSignIn modelSignIn = new ModelSignIn();
    ControllerSignIn controllerSignIn = new ControllerSignIn(viewLogin, modelSignIn);
}
