package Controller;

import Model.ModelAdminMember;
import View.ViewAdminMember;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControllerAdminMember implements ActionListener {

    ViewAdminMember viewAdminMember;
    ModelAdminMember modelAdminMember;

    public ControllerAdminMember(ViewAdminMember viewAdminMember, ModelAdminMember modelAdminMember) {
        this.viewAdminMember = viewAdminMember;
        this.modelAdminMember = modelAdminMember;

        if (modelAdminMember.getCountMembers() != 0)
            refreshTable();

        viewAdminMember.bUpdate.addActionListener(this);
        viewAdminMember.bDelete.addActionListener(this);
        viewAdminMember.bSearch.addActionListener(this);
        viewAdminMember.bRefresh.addActionListener(this);
        viewAdminMember.bReset.addActionListener(this);

        viewAdminMember.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = viewAdminMember.table.getSelectedRow();

                viewAdminMember.tfEmail.setText(viewAdminMember.table.getValueAt(row,1).toString());
                viewAdminMember.tfName.setText(viewAdminMember.table.getValueAt(row,2).toString());
                viewAdminMember.tfNoHp.setText(viewAdminMember.table.getValueAt(row,3).toString());
                viewAdminMember.tfAddress.setText(viewAdminMember.table.getValueAt(row,4).toString());
                viewAdminMember.tfPassword.setText(viewAdminMember.table.getValueAt(row,5).toString());
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewAdminMember.bUpdate){
            String email = viewAdminMember.getEmail();
            String password = viewAdminMember.getPassword();
            String name = viewAdminMember.getName();
            String address = viewAdminMember.getAddress();
            String noHp = viewAdminMember.getNoHp();

            if (email.equals("") || password.equals("") || name.equals("") || address.equals("") || noHp.equals("")){
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
            } else {
                if (modelAdminMember.updateMember(email, name, noHp, address, password) == 1)
                    JOptionPane.showMessageDialog(null, "Update Berhasil");
                else
                    JOptionPane.showMessageDialog(null, "Update Gagal");
            }
            refreshTable();
            reset();
        } else if (e.getSource() == viewAdminMember.bDelete){
            String email = viewAdminMember.getEmail();

            if (email.equals("")){
                JOptionPane.showMessageDialog(null, "Email Tidak Boleh Kosong");
            } else {
                if (modelAdminMember.deleteMember(email) == 1)
                    JOptionPane.showMessageDialog(null, "Delete Berhasil");
                else
                    JOptionPane.showMessageDialog(null, "Delete Gagal");
            }
            refreshTable();
            reset();
        } else if (e.getSource() == viewAdminMember.bReset){
            reset();
        } else if (e.getSource() == viewAdminMember.bSearch){
            String member = viewAdminMember.getSearch();
            String data[][] = modelAdminMember.getMemberSearch(member);
            viewAdminMember.table.setModel(new JTable(data, viewAdminMember.coloumnName).getModel());
        } else if (e.getSource() == viewAdminMember.bRefresh)
            refreshTable();
    }

    public void reset() {
        viewAdminMember.tfNoHp.setText("");
        viewAdminMember.tfAddress.setText("");
        viewAdminMember.tfName.setText("");
        viewAdminMember.tfPassword.setText("");
        viewAdminMember.tfEmail.setText("");
    }

    public void refreshTable() {
        viewAdminMember.tfSearch.setText("");
        String data[][] = modelAdminMember.getAllMembers();
        viewAdminMember.table.setModel(new JTable(data, viewAdminMember.coloumnName).getModel());
    }
}
