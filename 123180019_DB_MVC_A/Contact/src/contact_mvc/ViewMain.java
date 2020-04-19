package contact_mvc;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.orange;

public class ViewMain extends JFrame {
    Font fJudul;
    JLabel lJudul;
    JButton bBuatK,bLihatK;

    public ViewMain(){
        setLayout(null);
        setVisible(true);
        setSize(700, 500);
        getContentPane().setBackground(orange);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(new java.awt.Color(204, 202, 78));
        setTitle("Menu");

        fJudul = new Font("Tahoma", Font.BOLD, 20);
        lJudul = new JLabel("Menu Utama");
        lJudul.setFont(fJudul);
        bBuatK = new JButton("INSERT");
        bLihatK = new JButton("VIEW");

        bBuatK.setBackground(Color.pink);
        bLihatK.setBackground(Color.RED);
        add(lJudul);
        add(bBuatK);
        add(bLihatK);

        lJudul.setBounds(280,50,160,20);
        bBuatK.setBounds(250,100,190,30);
        bLihatK.setBounds(250,150,190,30);
    }
}
