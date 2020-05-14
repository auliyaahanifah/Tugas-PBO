package Main;

import Controller.ControllerMenuMember;
import View.ViewMenuMember;

public class MVCMenuMember {
    Member member;

    public ViewMenuMember viewMenuMember;
    public MVCMenuMember(Member member) {
        this.member = member;
        viewMenuMember = new ViewMenuMember(member);
        ControllerMenuMember controllerMenuMember = new ControllerMenuMember(viewMenuMember);
    }
}
