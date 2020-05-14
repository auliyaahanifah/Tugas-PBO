package Controller;

import Model.ModelAdminBook;
import View.ViewAdminBook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControllerAdminBook implements ActionListener {
    ViewAdminBook viewAdminBook;
    ModelAdminBook modelAdminBook;

    public ControllerAdminBook(ViewAdminBook viewAdminBook, ModelAdminBook modelAdminBook) {
        this.viewAdminBook = viewAdminBook;
        this.modelAdminBook = modelAdminBook;

        if (modelAdminBook.getCountBooks() != 0)
            refreshTable();

        viewAdminBook.bInsert.addActionListener(this);
        viewAdminBook.bReset.addActionListener(this);
        viewAdminBook.bSearch.addActionListener(this);
        viewAdminBook.bRefresh.addActionListener(this);

        viewAdminBook.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = viewAdminBook.table.getSelectedRow();

                String bookId = viewAdminBook.table.getValueAt(row,0).toString();
                String bookTitle = viewAdminBook.table.getValueAt(row,2).toString();
                String author = viewAdminBook.table.getValueAt(row,3).toString();
                String genre = viewAdminBook.table.getValueAt(row,4).toString();
                String stock = viewAdminBook.table.getValueAt(row,5).toString();

                UIManager.put("OptionPane.cancelButtonText", "Cancel");
                UIManager.put("OptionPane.noButtonText", "Delete");
                UIManager.put("OptionPane.yesButtonText", "Update");

                int option = JOptionPane.showConfirmDialog(null, "Update/Delete Buku " + bookTitle + " ?");
                if (option == 0){
                    updateBook(bookId, bookTitle, author, genre, stock);
                } else if (option == 1){
                    UIManager.put("OptionPane.noButtonText", "No");
                    UIManager.put("OptionPane.yesButtonText", "Yes");
                    int deleteOption = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin ?",
                            "Delete " + bookTitle, JOptionPane.YES_NO_OPTION);
                    if (deleteOption == 0){
                        if (modelAdminBook.deleteBook(bookId) == 1)
                            JOptionPane.showMessageDialog(null, bookTitle + " Berhasil Dihapus");
                    }
                }

                UIManager.put("OptionPane.cancelButtonText", "Cancel");
                UIManager.put("OptionPane.noButtonText", "No");
                UIManager.put("OptionPane.yesButtonText", "Yes");

                refreshTable();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewAdminBook.bInsert){
            insertBook();
        } else if (e.getSource() == viewAdminBook.bReset){
            reset();
        } else if (e.getSource() == viewAdminBook.bSearch){
            String book = viewAdminBook.getSearch();
            String data[][] = modelAdminBook.getBookSearch(book);

            viewAdminBook.table.setModel(new JTable(data, viewAdminBook.coloumnName).getModel());

            viewAdminBook.table.getColumnModel().getColumn(0).setMinWidth(0);
            viewAdminBook.table.getColumnModel().getColumn(0).setMaxWidth(0);
            viewAdminBook.table.getColumnModel().getColumn(0).setWidth(0);
        } else if (e.getSource() == viewAdminBook.bRefresh){
            refreshTable();
        }
    }

    public void refreshTable() {
        viewAdminBook.tfSearch.setText("");
        String data[][] = modelAdminBook.getAllBooks();
        viewAdminBook.table.setModel(new JTable(data, viewAdminBook.coloumnName).getModel());

        viewAdminBook.table.getColumnModel().getColumn(0).setMinWidth(0);
        viewAdminBook.table.getColumnModel().getColumn(0).setMaxWidth(0);
        viewAdminBook.table.getColumnModel().getColumn(0).setWidth(0);
    }

    public void reset() {
        viewAdminBook.tfTitle.setText("");
        viewAdminBook.tfAuthor.setText("");
        viewAdminBook.tfGenre.setText("");
        viewAdminBook.tfStock.setText("");
    }

    private void updateBook(String bookId, String bookTitle, String author, String genre, String stock) {
        String newBookTitle = JOptionPane.showInputDialog(null, "Update Title", bookTitle);
        newBookTitle = (newBookTitle == null)? bookTitle : newBookTitle;
        String newAuthor = JOptionPane.showInputDialog(null, "Update Author", author);
        newAuthor = (newAuthor == null)? author : newAuthor;
        String newGenre = JOptionPane.showInputDialog(null, "Update Genre", genre);
        newGenre = (newGenre == null)? genre : newGenre;
        String newStock = JOptionPane.showInputDialog(null, "Update Stock", stock);
        newStock = (newStock == null)? stock : newStock;
        int iNewStock = -1;

        try {
            iNewStock = Integer.parseInt(newStock);
            if (newBookTitle.equals("") || newAuthor.equals("") || newGenre.equals("") || newStock.equals("")){
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
            } else if (iNewStock < 0) {
                JOptionPane.showMessageDialog(null, "Stock Tidak Boleh Negatif");
            } else {
                if (modelAdminBook.updateBook(bookId, newBookTitle, newAuthor, newGenre, newStock) == 1){
                    JOptionPane.showMessageDialog(null, "Berhasil Update Buku");
                    refreshTable();
                }
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Stock Harus Diisi Dengan Angka");
        }
    }

    private void insertBook() {
        String bookTitle = viewAdminBook.getTitle();
        String author = viewAdminBook.getAuthor();
        String genre = viewAdminBook.getGenre();
        String stock = viewAdminBook.getStock();
        int iStock = -1;

        try {
            iStock = Integer.parseInt(stock);
            if (bookTitle.equals("") || author.equals("") || genre.equals("") || stock.equals("")){
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
            } else if (iStock < 0) {
                JOptionPane.showMessageDialog(null, "Stock Tidak Boleh Negatif");
            } else {
                if (modelAdminBook.insertBook(bookTitle, author, genre, stock) == 1){
                    JOptionPane.showMessageDialog(null, "Berhasil Insert Buku");
                    refreshTable();
                    reset();
                }
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Stock Harus Diisi Dengan Angka");
        }
    }
}
