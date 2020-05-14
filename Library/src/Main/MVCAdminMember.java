package Main;

import Controller.ControllerAdminMember;
import Model.ModelAdminMember;
import View.ViewAdminMember;

public class MVCAdminMember {
    public ViewAdminMember viewAdminMember = new ViewAdminMember();
    public ModelAdminMember modelAdminMember = new ModelAdminMember();
    public ControllerAdminMember controllerAdminMember = new ControllerAdminMember(viewAdminMember, modelAdminMember);
}
