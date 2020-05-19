package Perpustakaan;

import javax.swing.*;
import java.awt.*;

public class ViewHome extends JFrame {

    JPanel panel = new JPanel();

    JLabel lJudulHome = new JLabel("PERPUSTAKAAN");
    JLabel lSelamat = new JLabel("Selamat Datang Di");
    JLabel lSambutan = new JLabel("Ruang Baca");
    JLabel lBawahJudul = new JLabel("Disini kita membaca dengan senang hati!");

    JButton bHome = new JButton("HOME");
    JButton bPinjam = new JButton("PINJAM");
    JButton bTampil = new JButton("TAMPIL");
    JButton bAboutUs = new JButton("ABOUT US");
    JButton bLogout = new JButton("LOG OUT");

    public ViewHome(){
        setDefaultCloseOperation(3);
        setLocation(350, 100);
        setResizable(false);
        setVisible(false);
        setLayout(null);
        setSize(600, 500);
        setTitle("PERPUSTAKAAN");

        panel.setBounds(0,0,600,500);
        panel.setBackground(Color.PINK);
        //panel.setBorder(BorderFactory.createLineBorder(Color.white));
        panel.setVisible(true);
        panel.setLayout(null);
        add(panel);

        panel.add(lJudulHome);
        lJudulHome.setBounds(250,100, 100,20);
        lJudulHome.setVisible(true);
        panel.add(lSelamat);
        lSelamat.setBounds(300,200,200,20);
        lSelamat.setVisible(true);
        panel.add(lSambutan);
        lSambutan.setBounds(320,220,200,20);
        lSambutan.setVisible(true);
        panel.add(lBawahJudul);
        lBawahJudul.setBounds(250,240,300,20);
        lBawahJudul.setVisible(true);

        panel.add(bHome);
        bHome.setBounds(100,150,100,40);
        bHome.setVisible(true);
        panel.add(bPinjam);
        bPinjam.setBounds(100,200,100,40);
        bPinjam.setVisible(true);
        panel.add(bTampil);
        bTampil.setBounds(100,250,100,40);
        bTampil.setVisible(true);
        panel.add(bAboutUs);
        bAboutUs.setBounds(100,300,100,40);
        bAboutUs.setVisible(true);
        panel.add(bLogout);
        bLogout.setBounds(450,20,100,40);
        bLogout.setBackground(Color.red);
        bLogout.setVisible(true);
    }
}
