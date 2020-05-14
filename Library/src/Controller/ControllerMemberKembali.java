package Controller;

import Model.ModelMemberKembali;
import Model.ModelMemberPinjam;
import View.ViewMemberKembali;
import View.ViewMemberPinjam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControllerMemberKembali implements ActionListener {
    ViewMemberKembali viewMemberKembali;
    ModelMemberKembali modelMemberKembali;

    public ControllerMemberKembali(ViewMemberKembali viewMemberKembali, ModelMemberKembali modelMemberKembali) {
        this.viewMemberKembali = viewMemberKembali;
        this.modelMemberKembali = modelMemberKembali;

        if (modelMemberKembali.getCountBooks() != 0)
            refreshTable();

        viewMemberKembali.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = viewMemberKembali.table.getSelectedRow();
                String id = viewMemberKembali.table.getValueAt(row,0).toString();
                String book = viewMemberKembali.table.getValueAt(row,2).toString();

                int confirm = JOptionPane.showConfirmDialog(null,
                        "Apakah Mau Mengembalikan Buku " + book + " ?", "Konfirmasi" , JOptionPane.YES_NO_OPTION);

                if (confirm == 0) {
                    if (modelMemberKembali.kembali(id) == 1)
                        JOptionPane.showMessageDialog(null,
                                "Berhasil Mengembalikan Buku " + book);
                    else
                        JOptionPane.showMessageDialog(null,
                                "Gagal Mengembalikan Buku " + book);
                    refreshTable();
                } else
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dikembalikan");
            }
        });

        viewMemberKembali.bSearch.addActionListener(this);
        viewMemberKembali.bRefresh.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewMemberKembali.bSearch){
            String book = viewMemberKembali.getSearch();
            String data[][] = modelMemberKembali.getBookSearch(book);

            viewMemberKembali.table.setModel(new JTable(data, viewMemberKembali.coloumnName).getModel());

            viewMemberKembali.table.getColumnModel().getColumn(0).setMinWidth(0);
            viewMemberKembali.table.getColumnModel().getColumn(0).setMaxWidth(0);
            viewMemberKembali.table.getColumnModel().getColumn(0).setWidth(0);
        } else if (e.getSource() == viewMemberKembali.bRefresh)
            refreshTable();
    }

    public void refreshTable() {
        viewMemberKembali.tfSearch.setText("");
        String data[][] = modelMemberKembali.getAllBooks();
        viewMemberKembali.table.setModel(new JTable(data, viewMemberKembali.coloumnName).getModel());

        viewMemberKembali.table.getColumnModel().getColumn(0).setMinWidth(0);
        viewMemberKembali.table.getColumnModel().getColumn(0).setMaxWidth(0);
        viewMemberKembali.table.getColumnModel().getColumn(0).setWidth(0);
    }
}
