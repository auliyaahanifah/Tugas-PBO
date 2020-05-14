package Main;

import Controller.ControllerMenuAdmin;
import View.ViewMenuAdmin;

public class MVCMenuAdmin {
    public ViewMenuAdmin viewMenuAdmin = new ViewMenuAdmin();
    ControllerMenuAdmin controllerMenuAdmin = new ControllerMenuAdmin(viewMenuAdmin);
}
