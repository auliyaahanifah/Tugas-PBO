package Controller;

import Model.ModelAdminHistory;
import View.ViewAdminHistory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerAdminHistory implements ActionListener {

    ViewAdminHistory viewAdminHistory;
    ModelAdminHistory modelAdminHistory;

    public ControllerAdminHistory(ViewAdminHistory viewAdminHistory, ModelAdminHistory modelAdminHistory) {
        this.viewAdminHistory = viewAdminHistory;
        this.modelAdminHistory = modelAdminHistory;

        if (modelAdminHistory.getCountBooks() != 0)
            refreshTable();

        viewAdminHistory.bSearch.addActionListener(this);
        viewAdminHistory.bRefresh.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewAdminHistory.bSearch){
            String book = viewAdminHistory.getSearch();
            String data[][] = modelAdminHistory.getBookSearch(book);

            viewAdminHistory.table.setModel(new JTable(data, viewAdminHistory.coloumnName).getModel());
        } else if (e.getSource() == viewAdminHistory.bRefresh)
            refreshTable();
    }

    public  void refreshTable() {
        viewAdminHistory.tfSearch.setText("");
        String data[][] = modelAdminHistory.getAllBooks();
        viewAdminHistory.table.setModel(new JTable(data, viewAdminHistory.coloumnName).getModel());
    }
}
