package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewAdminBook extends JFrame {

    Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 45);//membuat font
    Font font2 = new Font(Font.MONOSPACED, Font.BOLD, 17);

    public JPanel pBook = new JPanel();

    JLabel lJudulHome = new JLabel("Buku");
    JLabel lJudul1 = new JLabel("NB: Klik Tabel Yang Dicari Jika ingin Update/Delete ");

    JLabel lTitle = new JLabel("Title");
    public JTextField tfTitle = new JTextField();
    JLabel lAuthor = new JLabel("Author");
    public JTextField tfAuthor = new JTextField();
    JLabel lGenre = new JLabel("Genre");
    public JTextField tfGenre = new JTextField();
    JLabel lStock = new JLabel("Stok");
    public JTextField tfStock = new JTextField();

    JLabel lSearch = new JLabel("SEARCH");
    public JTextField tfSearch = new JTextField();

    public JButton bInsert = new JButton("INSERT");
    public JButton bSearch = new JButton("SEARCH");
    public JButton bRefresh = new JButton("REFRESH");
    public JButton bReset = new JButton("RESET");

    public JTable table;
    public DefaultTableModel tableModel;
    JScrollPane scrollPane;

    public Object coloumnName[] = {"BookId", "#", "Title","Author","Genre","Stok"};

    public ViewAdminBook(){
        tableModel = new DefaultTableModel(coloumnName,0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        pBook.setLayout(null);
        pBook.setSize(800,670);

        lJudulHome.setFont(font1);
        pBook.add(lJudulHome);
        lJudulHome.setBounds(40, 50, 300, 50);

        lJudul1.setFont(font2);
        pBook.add(lJudul1);
        lJudul1.setBounds(75, 625, 600, 50);

        pBook.add(scrollPane);
        scrollPane.setBounds(75, 400, 600, 225);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pBook.add(lSearch);
        lSearch.setBounds(75,350,80,20);
        pBook.add(lTitle);
        lTitle.setBounds(75, 100, 160, 50);
        pBook.add(lAuthor);
        lAuthor.setBounds(75, 135, 160, 50);
        pBook.add(lGenre);
        lGenre.setBounds(75, 170, 160, 50);
        pBook.add(lStock);
        lStock.setBounds(75, 225, 50, 20);

        pBook.add(tfSearch);
        tfSearch.setBounds(130,350,350,20);
        pBook.add(tfTitle);
        tfTitle.setBounds(150,115,350,20);
        pBook.add(tfAuthor);
        tfAuthor.setBounds(150,150,350,20);
        pBook.add(tfGenre);
        tfGenre.setBounds(150,185,350,20);
        pBook.add(tfStock);
        tfStock.setBounds(150,225,350,20);

        pBook.add(bSearch);
        bSearch.setBounds(480,350,90,20);
        pBook.add(bRefresh);
        bRefresh.setBounds(570,350,100,20);
        pBook.add(bInsert);
        bInsert.setBounds(200,280,90,20);
        pBook.add(bReset);
        bReset.setBounds(340,280,90,20);

    }
    public  String getTitle(){
        return tfTitle.getText();
    }
    public  String getAuthor(){
        return tfAuthor.getText();
    }
    public  String getGenre(){
        return tfGenre.getText();
    }
    public  String getStock(){
        return tfStock.getText();
    }
    public String getSearch() {
        return tfSearch.getText();
    }

}
