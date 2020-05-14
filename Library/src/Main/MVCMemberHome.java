package Main;

import View.ViewMemberHome;

public class MVCMemberHome {
    Member member;

    public ViewMemberHome viewMemberHome;
    public MVCMemberHome(Member member) {
        this.member = member;
        viewMemberHome = new ViewMemberHome(member);
    }
}
