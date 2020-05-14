package Controller;

import Model.ModelMemberPinjam;
import View.ViewMemberPinjam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControllerMemberPinjam implements ActionListener {

    ViewMemberPinjam viewMemberPinjam;
    ModelMemberPinjam modelMemberPinjam;

    public ControllerMemberPinjam(ViewMemberPinjam viewMemberPinjam, ModelMemberPinjam modelMemberPinjam) {
        this.viewMemberPinjam = viewMemberPinjam;
        this.modelMemberPinjam = modelMemberPinjam;

        if (modelMemberPinjam.getCountBooks() != 0)
            refreshTable();

        viewMemberPinjam.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = viewMemberPinjam.table.getSelectedRow();
                String id = viewMemberPinjam.table.getValueAt(row,0).toString();
                String book = viewMemberPinjam.table.getValueAt(row,2).toString();

                int confirm = JOptionPane.showConfirmDialog(null,
                        "Apakah Mau Meminjam Buku " + book + " ?", "Konfirmasi" , JOptionPane.YES_NO_OPTION);

                if (confirm == 0) {
                    if (modelMemberPinjam.pinjam(id) == 1)
                        JOptionPane.showMessageDialog(null,
                                "Berhasil Meminjam Buku " + book);
                    else
                        JOptionPane.showMessageDialog(null,
                                "Gagal Meminjam Buku " + book);
                    refreshTable();
                } else
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dipinjam");
            }
        });

        viewMemberPinjam.bSearch.addActionListener(this);
        viewMemberPinjam.bRefresh.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewMemberPinjam.bSearch){
            String book = viewMemberPinjam.getSearch();
            String data[][] = modelMemberPinjam.getBookSearch(book);

            viewMemberPinjam.table.setModel(new JTable(data, viewMemberPinjam.coloumnName).getModel());

            viewMemberPinjam.table.getColumnModel().getColumn(0).setMinWidth(0);
            viewMemberPinjam.table.getColumnModel().getColumn(0).setMaxWidth(0);
            viewMemberPinjam.table.getColumnModel().getColumn(0).setWidth(0);
        } else if (e.getSource() == viewMemberPinjam.bRefresh)
            refreshTable();
    }

    public void refreshTable() {
        viewMemberPinjam.tfSearch.setText("");
        String data[][] = modelMemberPinjam.getAllBooks();
        viewMemberPinjam.table.setModel(new JTable(data, viewMemberPinjam.coloumnName).getModel());

        viewMemberPinjam.table.getColumnModel().getColumn(0).setMinWidth(0);
        viewMemberPinjam.table.getColumnModel().getColumn(0).setMaxWidth(0);
        viewMemberPinjam.table.getColumnModel().getColumn(0).setWidth(0);
    }
}
