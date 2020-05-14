package Main;

import Controller.ControllerMemberKembali;
import Model.ModelMemberKembali;
import Model.ModelMemberPinjam;
import View.ViewMemberKembali;

public class MVCMemberKembali {
    Member member;

    public ViewMemberKembali viewMemberKembali;
    public ModelMemberKembali modelMemberKembali;
    public ControllerMemberKembali controllerMemberKembali;
    public MVCMemberKembali(Member member) {
        this.member = member;
        viewMemberKembali = new ViewMemberKembali();
        modelMemberKembali = new ModelMemberKembali(member);
        controllerMemberKembali = new ControllerMemberKembali(viewMemberKembali, modelMemberKembali);
    }
}
