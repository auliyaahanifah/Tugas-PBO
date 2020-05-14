package Controller;

import Main.MVCLogin;
import View.ViewMenuMember;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerMenuMember implements ActionListener {

    ViewMenuMember viewMenuMember;

    public ControllerMenuMember(ViewMenuMember viewMenuMember) {
        this.viewMenuMember = viewMenuMember;

        viewMenuMember.bHome.addActionListener(this);
        viewMenuMember.bPinjam.addActionListener(this);
        viewMenuMember.bKembali.addActionListener(this);
        viewMenuMember.bLogout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewMenuMember.bHome){
            viewMenuMember.reset();
            viewMenuMember.mvcMemberHome.viewMemberHome.pHome.setVisible(true);
        } else if (e.getSource() == viewMenuMember.bPinjam){
            viewMenuMember.reset();
            viewMenuMember.mvcMemberPinjam.viewMemberPinjam.pPinjam.setVisible(true);
            viewMenuMember.mvcMemberPinjam.controllerMemberPinjam.refreshTable();
        } else if (e.getSource() == viewMenuMember.bKembali){
            viewMenuMember.reset();
            viewMenuMember.mvcMemberKembali.viewMemberKembali.pKembali.setVisible(true);
            viewMenuMember.mvcMemberKembali.controllerMemberKembali.refreshTable();
        } else if (e.getSource() == viewMenuMember.bLogout){
            int option = JOptionPane.showConfirmDialog(null, "Yakin Mau Logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (option == 0){
                viewMenuMember.setVisible(false);
                new MVCLogin();
            }
        }
    }
}
