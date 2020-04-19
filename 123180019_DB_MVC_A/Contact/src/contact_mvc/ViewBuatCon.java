package contact_mvc;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.orange;

public class ViewBuatCon extends JFrame {
    Font fJudul,fKata;
    JLabel lJudul, lNama, lNo, lUmur,lEmail;
    JTextField tfNama, tfNo, tfUmur, tfEmail;
    JButton bTambah, bBatal;

    public ViewBuatCon(){
        setSize(700, 500);
        getContentPane().setBackground(orange);
        setVisible(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Tambah Contact");

        fJudul = new Font("Tahoma", Font.BOLD, 20);
        fKata = new Font("Tahoma", Font.CENTER_BASELINE, 14);
        lJudul = new JLabel("    Buat Cotact"); lJudul.setFont(fJudul);
        lNama = new JLabel("Nama"); lNama.setFont(fKata);
        lNo = new JLabel("No.HP"); lNo.setFont(fKata);
        lUmur = new JLabel("Umur"); lUmur.setFont(fKata);
        lEmail = new JLabel("Email"); lEmail.setFont(fKata);

        tfNama = new JTextField();
        tfNo = new JTextField();
        tfUmur = new JTextField();
        tfEmail = new JTextField();

        bBatal = new JButton("BATAL");
        bTambah = new JButton("TAMBAH");

        bBatal.setBackground(Color.red);
        bTambah.setBackground(Color.pink);
        add(lJudul);
        add(lNama);
        add(lNo);
        add(lUmur);
        add(lEmail);
        add(tfNama);
        add(tfNo);
        add(tfUmur);
        add(tfEmail);
        add(bBatal);
        add(bTambah);

        lJudul.setBounds(280,30,200,30);
        lNama.setBounds(200,100,80,20);
        tfNama.setBounds(260,100,225,20);
        lNo.setBounds(200,130,80,20);
        tfNo.setBounds(260,130,225,20);
        lUmur.setBounds(200,160,80,20);
        tfUmur.setBounds(260,160,225,20);
        lEmail.setBounds(200,190,80,20);
        tfEmail.setBounds(260,190,225,20);
        bTambah.setBounds(280,230,90,30);
        bBatal.setBounds(  380,230,90,30);
    }
}
