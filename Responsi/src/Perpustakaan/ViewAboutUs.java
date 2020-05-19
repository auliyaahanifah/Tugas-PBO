package Perpustakaan;

import javax.swing.*;
import java.awt.*;

public class ViewAboutUs extends JFrame {

    JPanel panel = new JPanel();

    JLabel lJudul = new JLabel("PERPUSTAKAAN");
    JLabel lSambutan = new JLabel("ABOUT US");
    JLabel lSambutan1 = new JLabel("Auliyaa Hanifah R.H.");
    JLabel lSambutan2 = new JLabel("Prak PBO A");

    JButton bHome = new JButton("HOME");
    JButton bPinjam = new JButton("PINJAM");
    JButton bTampil = new JButton("TAMPIL");
    JButton bAbout = new JButton("ABOUT US");
    JButton bLogout = new JButton("LOG OUT");

    public ViewAboutUs(){
        setDefaultCloseOperation(3);
        setLocation(350, 100);
        setResizable(false);
        setVisible(false);
        setLayout(null);
        setSize(600, 500);
        setTitle("PERPUSTAKAAN");

        panel.setBounds(0,0,600,500);
        panel.setBackground(Color.pink);
        panel.setBorder(BorderFactory.createLineBorder(Color.white));
        panel.setVisible(true);
        panel.setLayout(null);
        add(panel);

        panel.add(lJudul);
        lJudul.setBounds(250,100,100,20);
        lJudul.setVisible(true);
        panel.add(lSambutan);
        lSambutan.setBounds(300,180,200,20);
        lSambutan.setVisible(true);
        panel.add(lSambutan1);
        lSambutan1.setBounds(280,220,200,20);
        lSambutan1.setVisible(true);
        panel.add(lSambutan2);
        lSambutan2.setBounds(280,240,200,20);
        lSambutan2.setVisible(true);

        panel.add(bHome);
        bHome.setBounds(100,150,100,40);
        bHome.setVisible(true);
        panel.add(bPinjam);
        bPinjam.setBounds(100,200,100,40);
        bPinjam.setVisible(true);
        panel.add(bTampil);
        bTampil.setBounds(100,250,100,40);
        bTampil.setVisible(true);
        panel.add(bAbout);
        bAbout.setBounds(100,300,100,40);
        bAbout.setVisible(true);
        panel.add(bLogout);
        bLogout.setBounds(450, 20, 100, 40);
        bLogout.setBackground(Color.red);
    }
}
