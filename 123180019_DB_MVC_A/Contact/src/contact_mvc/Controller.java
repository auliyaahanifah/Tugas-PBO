package contact_mvc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller {
    String nama,no_hp,umur,email;

    public Controller (Model model, ViewMain viewmain, ViewBuatCon viewbuat, ViewLihatCon viewlihat, ViewUpdateCon viewupdate){
        if (model.getContact()!=0){
            String datacon[][] = model.readContact();
            viewlihat.table.setModel((new JTable(datacon, viewlihat.namaKolom)).getModel());
            viewlihat.table.getColumnModel().getColumn(4).setMinWidth(0);
            viewlihat.table.getColumnModel().getColumn(4).setMaxWidth(0);
        }
        else {
            int input = JOptionPane.showConfirmDialog(null, "KONTAK BLM ADA, APAKAH ANDA INGIN MEMBUAT ?", "OPSI", JOptionPane.YES_NO_OPTION);

            if (input == 0){
                viewmain.dispose();;
                viewbuat.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "BATAL MEMBUAT KONTAK");
            }
        }

        viewmain.bBuatK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewbuat.setVisible(true);
                viewmain.setVisible(false);
            }
        });

        viewbuat.bTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = viewbuat.tfNama.getText();
                String no_hp = viewbuat.tfNo.getText();
                String umur = viewbuat.tfUmur.getText();
                String email = viewbuat.tfEmail.getText();
                model.insertContact(nama, no_hp, umur, email);

                String contact[][] = model.readContact();
                viewlihat.table.setModel(new JTable(contact,viewlihat.namaKolom).getModel());
                viewlihat.table.getColumnModel().getColumn(4).setMinWidth(0);
                viewlihat.table.getColumnModel().getColumn(4).setMaxWidth(0);
                viewbuat.setVisible(false);
                viewlihat.setVisible(true);
                viewbuat.tfNama.setText(null);
                viewbuat.tfNo.setText(null);
                viewbuat.tfUmur.setText(null);
                viewbuat.tfEmail.setText(null);
            }
        });

        viewbuat.bBatal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewbuat.setVisible(false);
                viewmain.setVisible(true);
            }
        });

        viewmain.bLihatK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewmain.setVisible(false);
                viewlihat.setVisible(true);
            }
        });

        viewlihat.bTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewlihat.setVisible(false);
                viewbuat.setVisible(true);
            }
        });

        viewlihat.bKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewlihat.setVisible(false);
                viewmain.setVisible(true);
            }
        });

        viewlihat.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = viewlihat.table.getSelectedRow();
                int kolom = viewlihat.table.getSelectedColumn();

                String dataterpilih = viewlihat.table.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);
                viewlihat.lNamaisi.setText(viewlihat.table.getValueAt(baris,0).toString());
                viewlihat.lNoisi.setText(viewlihat.table.getValueAt(baris,1).toString());
                viewlihat.lUmurisi.setText(viewlihat.table.getValueAt(baris,2).toString());
                viewlihat.lEmailisi.setText(viewlihat.table.getValueAt(baris,3).toString());
                viewlihat.lId.setText(viewlihat.table.getValueAt(baris,4).toString());

                nama = viewlihat.lNamaisi.getText();
                no_hp = viewlihat.lNoisi.getText();
                umur = viewlihat.lUmurisi.getText();
                email = viewlihat.lEmailisi.getText();

                viewlihat.bUpdate.setEnabled(true);
                viewlihat.bHapus.setEnabled(true);
            }
        });

        viewlihat.bSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cari = viewlihat.tfsearch.getText();
                String data[][] = model.getContactSearch(cari);
                viewlihat.table.setModel(new JTable(data, viewlihat.namaKolom).getModel());
                viewlihat.table.getColumnModel().getColumn(4).setMinWidth(0);
                viewlihat.table.getColumnModel().getColumn(4).setMaxWidth(0);
            }
        });

        viewlihat.bHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = viewlihat.lId.getText();
                model.hapusContact(id);
                String datacon[][] = model.readContact();
                viewlihat.table.setModel((new JTable(datacon, viewlihat.namaKolom)).getModel());
                viewlihat.table.getColumnModel().getColumn(4).setMinWidth(0);
                viewlihat.table.getColumnModel().getColumn(4).setMaxWidth(0);
                viewlihat.lNamaisi.setText(null);
                viewlihat.lNoisi.setText(null);
                viewlihat.lUmurisi.setText(null);
                viewlihat.lEmailisi.setText(null);
                viewlihat.tfsearch.setText(null);
            }
        });

        viewlihat.bUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewupdate.setVisible(true);
                viewlihat.setVisible(false);
                viewupdate.tfNama.setText(nama);
                viewupdate.tfNo.setText(no_hp);
                viewupdate.tfUmur.setText(umur);
                viewupdate.tfEmail.setText(email);
            }
        });

        viewlihat.bRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contact [][] = model.readContact();
                viewlihat.table.getColumnModel().getColumn(4).setMinWidth(0);
                viewlihat.table.getColumnModel().getColumn(4).setMaxWidth(0);
                viewlihat.lNamaisi.setText(null);
                viewlihat.lNoisi.setText(null);
                viewlihat.lUmurisi.setText(null);
                viewlihat.lEmailisi.setText(null);
                viewlihat.bUpdate.setEnabled(false);
                viewlihat.bHapus.setEnabled(false);
                viewlihat.tfsearch.setText(null);
            }
        });

        viewupdate.bKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewupdate.setVisible(false);
                viewlihat.setVisible(true);
            }
        });

        viewupdate.bEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = viewupdate.tfNama.getText();
                String no_hp = viewupdate.tfNo.getText();
                String umur = viewupdate.tfUmur.getText();
                String email = viewupdate.tfEmail.getText();
                String id = viewlihat.lId.getText();

                model.updateContact(id,nama,no_hp,umur,email);
                String contact [][] = model.readContact();
                viewlihat.table.setModel(new JTable(contact,viewlihat.namaKolom).getModel());
                viewlihat.table.getColumnModel().getColumn(4).setMinWidth(0);
                viewlihat.table.getColumnModel().getColumn(4).setMaxWidth(0);
                viewlihat.lNamaisi.setText(nama);
                viewlihat.lNoisi.setText(no_hp);
                viewlihat.lUmurisi.setText(umur);
                viewlihat.lEmailisi.setText(email);
                viewupdate.setVisible(false);
                viewlihat.setVisible(true);
            }
        });
    }
}
