package Controller;

import Main.MVCLogin;
import View.ViewMenuAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerMenuAdmin implements ActionListener {

    ViewMenuAdmin viewMenuAdmin;

    public ControllerMenuAdmin(ViewMenuAdmin viewMenuAdmin) {
        this.viewMenuAdmin = viewMenuAdmin;

        viewMenuAdmin.bMember.addActionListener(this);
        viewMenuAdmin.bBook.addActionListener(this);
        viewMenuAdmin.bHistory.addActionListener(this);
        viewMenuAdmin.bLogout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewMenuAdmin.bMember){
            viewMenuAdmin.reset();
            viewMenuAdmin.mvcAdminMember.viewAdminMember.pMember.setVisible(true);
            viewMenuAdmin.mvcAdminMember.controllerAdminMember.refreshTable();
            viewMenuAdmin.mvcAdminMember.controllerAdminMember.reset();
        } else if (e.getSource() == viewMenuAdmin.bBook){
            viewMenuAdmin.reset();
            viewMenuAdmin.mvcAdminBook.viewAdminBook.pBook.setVisible(true);
            viewMenuAdmin.mvcAdminBook.controllerAdminBook.refreshTable();
            viewMenuAdmin.mvcAdminBook.controllerAdminBook.reset();
        } else if (e.getSource() == viewMenuAdmin.bHistory){
            viewMenuAdmin.reset();
            viewMenuAdmin.mvcAdminHistory.viewAdminHistory.pHistory.setVisible(true);
            viewMenuAdmin.mvcAdminHistory.controllerAdminHistory.refreshTable();
        } else if (e.getSource() == viewMenuAdmin.bLogout){
            int option = JOptionPane.showConfirmDialog(null, "Yakin Mau Logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (option == 0){
                viewMenuAdmin.setVisible(false);
                new MVCLogin();
            }
        }
    }
}
