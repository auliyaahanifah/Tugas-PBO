package Main;

import Controller.ControllerMemberPinjam;
import Model.ModelMemberPinjam;
import Model.ModelSignIn;
import View.ViewMemberPinjam;

public class MVCMemberPinjam {
    Member member;

    public ViewMemberPinjam viewMemberPinjam;
    public ModelMemberPinjam modelMemberPinjam;
    public ControllerMemberPinjam controllerMemberPinjam;
    public MVCMemberPinjam(Member member) {
        this.member = member;
        viewMemberPinjam = new ViewMemberPinjam();
        modelMemberPinjam = new ModelMemberPinjam(member);
        controllerMemberPinjam = new ControllerMemberPinjam(viewMemberPinjam, modelMemberPinjam);
    }
}
