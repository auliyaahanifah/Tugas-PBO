package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewAdminMember extends JFrame {
    Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 45);//membuat font
    Font font2 = new Font(Font.MONOSPACED, Font.BOLD, 17);

    public JPanel pMember = new JPanel();

    JLabel lJudulHome = new JLabel("Member");
    JLabel lJudul1 = new JLabel("NB: Klik Tabel Yang Dicari Jika ingin Update/Delete ");

    JLabel lEmail = new JLabel("Email");
    public JTextField tfEmail = new JTextField();
    JLabel lName = new JLabel("Name");
    public JTextField tfName = new JTextField();
    JLabel lNoHp = new JLabel("No Hp");
    public JTextField tfNoHp = new JTextField();
    JLabel lAddress = new JLabel("Address");
    public JTextField tfAddress = new JTextField();
    JLabel lPassword = new JLabel("Password");
    public  JTextField tfPassword = new JTextField();


    JLabel lSearch = new JLabel("SEARCH");
    public JTextField tfSearch = new JTextField();

    public JButton bUpdate = new JButton("UPDATE");
    public JButton bDelete = new JButton("DELETE");
    public JButton bReset = new JButton("RESET");
    public JButton bSearch = new JButton("SEARCH");
    public JButton bRefresh = new JButton("REFRESH");

    public JTable table;
    public DefaultTableModel tableModel;
    JScrollPane scrollPane;

    public Object coloumnName[] = {"#", "Email","Nama","No Hp","Address","Password"};

    public ViewAdminMember(){
        tableModel = new DefaultTableModel(coloumnName,0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        pMember.setLayout(null);
        pMember.setSize(800,670);

        lJudulHome.setFont(font1);
        pMember.add(lJudulHome);
        lJudulHome.setBounds(40, 50, 300, 50);

        lJudul1.setFont(font2);
        pMember.add(lJudul1);
        lJudul1.setBounds(75, 625, 600, 50);

        pMember.add(scrollPane);
        scrollPane.setBounds(75, 400, 600, 225);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pMember.add(lSearch);
        lSearch.setBounds(75,350,80,20);
        pMember.add(lEmail);
        lEmail.setBounds(75, 100, 160, 50);
        pMember.add(lName);
        lName.setBounds(75, 135, 160, 50);
        pMember.add(lNoHp);
        lNoHp.setBounds(75, 170, 160, 50);
        pMember.add(lAddress);
        lAddress.setBounds(75, 225, 50, 20);
        pMember.add(lPassword);
        lPassword.setBounds(75, 245,160,50);

        pMember.add(tfSearch);
        tfSearch.setBounds(130,350,350,20);
        pMember.add(tfEmail);
        tfEmail.setBounds(150,115,350,20);
        pMember.add(tfName);
        tfName.setBounds(150,150,350,20);
        pMember.add(tfNoHp);
        tfNoHp.setBounds(150,185,350,20);
        pMember.add(tfAddress);
        tfAddress.setBounds(150,225,350,20);
        pMember.add(tfPassword);
        tfPassword.setBounds(150,260,350,20);

        pMember.add(bSearch);
        bSearch.setBounds(480,350,90,20);
        pMember.add(bRefresh);
        bRefresh.setBounds(570,350,100,20);
        pMember.add(bUpdate);
        bUpdate.setBounds(150,300,90,20);
        pMember.add(bDelete);
        bDelete.setBounds(400,300,90,20);
        pMember.add(bReset);
        bReset.setBounds(280, 300, 90, 20);

    }
    public  String getEmail(){
        return tfEmail.getText();
    }
    public  String getPassword(){
        return tfPassword.getText();
    }
    public  String getName(){
        return tfName.getText();
    }
    public  String getAddress(){
        return tfAddress.getText();
    }
    public  String getNoHp(){
        return tfNoHp.getText();
    }
    public String getSearch() {
        return tfSearch.getText();
    }
}
