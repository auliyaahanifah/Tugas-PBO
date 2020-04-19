package contact_mvc;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import static java.awt.Color.*;

public class ViewLihatCon extends JFrame {
    JPanel panel = new JPanel();
    JPanel panelin = new JPanel();
    JLabel lJudul, lJudul1, lPilihan, lPilihan1, lNama, lNo, lUmur, lEmail, lNamaisi, lNoisi,lUmurisi,lEmailisi,lId;
    JTextField tfsearch;
    Font fJudul, fJudul1, fPilihan,fPilihan1;
    JTable table;
    JButton bTambah, bKembali, bHapus, bUpdate, bRefresh, bSearch;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"nama","no_hp","umur","email",""};
    GroupLayout gpanel, gpanelin;

    public ViewLihatCon() {
        fJudul = new Font("Tahoma", Font.BOLD, 20);
        fJudul1 = new Font("Tahoma", Font.ROMAN_BASELINE, 15);
        fPilihan = new Font("Tahoma", Font.BOLD , 17);
        fPilihan1 = new Font("Tahoma", Font.BOLD , 17);
        lJudul = new JLabel("DATA KONTAK");
        lJudul.setFont(fJudul);
        lJudul1 = new JLabel("*NB: Search Berdasarkan Nama dan No.HP Saja");
        lJudul1.setFont(fJudul1);
        lNama = new JLabel("Nama :");
        lNo = new JLabel("No.HP :");
        lUmur = new JLabel("Umur :");
        lEmail = new JLabel("Email :");
        lId = new JLabel();

        lNamaisi = new JLabel();
        lNoisi = new JLabel();
        lUmurisi = new JLabel();
        lEmailisi = new JLabel();

        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        bSearch = new JButton("SEARCH");
        tfsearch = new JTextField();
        bTambah = new JButton("INSERT");
        bKembali = new JButton("EXIT");
        bHapus = new JButton("DELETE");
        bUpdate = new JButton("UPDATE");
        bRefresh = new JButton("CLEAR");

        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        gpanel = new GroupLayout(panel);
        panel.setLayout(gpanel);
        //panelin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detail Contact", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        gpanelin = new GroupLayout(panelin);
        panelin.setLayout(gpanelin);
        lPilihan = new JLabel("DETAIL DATA KONTAK");
        lPilihan1 = new JLabel("TAMBAH DATA");
        lPilihan.setFont(fPilihan);
        lPilihan1.setFont(fPilihan);

        setTitle("Data Contact");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);
        setLayout(null);
        setSize(900, 600);
        getContentPane().setBackground(orange);
        setLocationRelativeTo(null);

        add(panel);
        panel.add(lPilihan);
        panel.add(lPilihan1);
        panel.add(bTambah);
        panel.add(bKembali);
        panel.add(bHapus);
        panel.add(bUpdate);
        panel.add(bRefresh);
        panel.add(panelin);

        panelin.add(lNama);
        panelin.add(lNo);
        panelin.add(lUmur);
        panelin.add(lEmail);
        panelin.add(lNamaisi);
        panelin.add(lNoisi);
        panelin.add(lUmurisi);
        panelin.add(lEmailisi);

        add(lJudul);
        add(lJudul1);
        add(scrollPane);
        add(bSearch);
        add(tfsearch);
        bRefresh.setBackground(yellow);
        bUpdate.setBackground(Color.blue);
        bHapus.setBackground(Color.red);
        bTambah.setBackground(Color.pink);
        bKembali.setBackground(WHITE);
        bSearch.setBackground(yellow);
        panelin.setBackground(white);
        panel.setBackground(lightGray);

        panel.setBounds(540, 50, 330, 480);
        panelin.setBounds(30, 70, 275, 150);
        lPilihan.setBounds(70, 30, 200, 20);
        bRefresh.setBounds(120, 200, 100, 20);
        bUpdate.setBounds(60, 250, 100, 30);
        bHapus.setBounds(180, 250, 100, 30);
        lPilihan1.setBounds(100, 325,200,20);
        bTambah.setBounds(110, 360, 100, 30);
        bKembali.setBounds(110, 400, 100, 30);
        lJudul.setBounds(220, 20, 160, 20);
        lJudul1.setBounds(50,325,470,430);

        scrollPane.setBackground(pink);
        scrollPane.setBounds(50,100,470,430);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        tfsearch.setBounds(50,60,370,20);
        bSearch.setBounds(420,60,100,20);

        lNama.setBounds(20,25,80,20);
        lNamaisi.setBounds(80,25,200,20);
        lNo.setBounds(20,50, 80, 20);
        lNoisi.setBounds(80,50,200,20);
        lUmur.setBounds(20,75,80,20);
        lUmurisi.setBounds(80,75,200,20);
        lEmail.setBounds(20,100,80,20);
        lEmailisi.setBounds(80,100,200,20);
        bHapus.setEnabled(false);
        bUpdate.setEnabled(false);
    }
}
