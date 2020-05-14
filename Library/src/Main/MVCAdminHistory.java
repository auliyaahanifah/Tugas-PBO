package Main;

import Controller.ControllerAdminHistory;
import Model.ModelAdminHistory;
import View.ViewAdminHistory;

public class MVCAdminHistory {
    public ViewAdminHistory viewAdminHistory = new ViewAdminHistory();
    public ModelAdminHistory modelAdminHistory = new ModelAdminHistory();
    public ControllerAdminHistory controllerAdminHistory = new ControllerAdminHistory(viewAdminHistory, modelAdminHistory);
}
