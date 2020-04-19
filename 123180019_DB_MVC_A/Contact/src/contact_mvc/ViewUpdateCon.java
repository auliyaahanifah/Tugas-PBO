package contact_mvc;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.orange;

public class ViewUpdateCon extends JFrame {
    Font fJudul;
    JLabel lJudul, lNama, lNo, lUmur,lEmail;
    JTextField tfNama, tfNo, tfUmur, tfEmail;
    JButton bEdit, bKembali;

    public ViewUpdateCon(){
        fJudul = new Font("Tahoma", Font.BOLD,20);
        lJudul = new JLabel("EDIT KONTAK"); lJudul.setFont(fJudul);
        lNama = new JLabel("Nama");
        lNo = new JLabel("No.Hp");
        lUmur = new JLabel("Umur");
        lEmail = new JLabel("Email");
        tfNama = new JTextField();
        tfNo = new JTextField();
        tfUmur = new JTextField();
        tfEmail = new JTextField();
        bEdit = new JButton("EDIT");
        bKembali = new JButton("KEMBALI");

        setTitle("EDIT KONTAK");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);
        setLayout(null);
        setSize(700, 500);
        getContentPane().setBackground(orange);
        setLocationRelativeTo(null);

        add(lJudul);
        lJudul.setBounds(280,30,200,30);
        add(lNama);
        lNama.setBounds(200,100,80,20);
        add(tfNama);
        tfNama.setBounds(260,100,225,20);
        add(lNo);
        lNo.setBounds(200,130,80,20);
        add(tfNo);
        tfNo.setBounds(260,130,225,20);
        add(lUmur);
        lUmur.setBounds(200,160,80,20);
        add(tfUmur);
        tfUmur.setBounds(260,160,225,20);
        add(lEmail);
        lEmail.setBounds(200,190,80,20);
        add(tfEmail);
        tfEmail.setBounds(260,190,225,20);

        add(bEdit);
        bEdit.setBackground(Color.blue);
        bEdit.setBounds(280,230,90,30);
        add(bKembali);
        bKembali.setBackground(Color.red);
        bKembali.setBounds(380,230,90,30);
    }
}
