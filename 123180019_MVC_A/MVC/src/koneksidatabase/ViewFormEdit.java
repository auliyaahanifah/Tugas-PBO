package koneksidatabase;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

import static java.awt.Color.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewFormEdit extends JFrame{

    JLabel lnim = new JLabel("NIM      ");
    JTextField tfnim = new JTextField();
    JLabel lnama = new JLabel("Nama     ");
    JTextField tfnama = new JTextField();
    JLabel lalamat = new JLabel("Alamat    ");
    JTextArea taalamat = new JTextArea();

    JButton btnTambahPanel = new JButton("Edit");
    JButton btnBatalPanel = new JButton("Batal");

    public ViewFormEdit() {
        setTitle("Edit Data");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(800, 600);
        getContentPane().setBackground(orange);

        JLabel label = new JLabel("Edit Data Mahasiswa");
        add(label, BorderLayout.CENTER);
        label.setBounds(300, 20, 200, 20);

        add(lnim);
        lnim.setBounds(200, 80, 90, 20);
        add(tfnim);
        tfnim.setBackground(Color.lightGray);
        tfnim.setBounds(280, 80, 90, 20);
        add(lnama);
        lnama.setBounds(200, 110, 90, 20);
        add(tfnama);
        tfnama.setBounds(280, 110, 250, 20);
        add(lalamat);
        lalamat.setBounds(200, 140, 90, 20);
        add(taalamat);
        taalamat.setBounds(280, 140, 250, 20);

        add(btnTambahPanel);
        btnTambahPanel.setBounds(250, 190, 100, 20);
        btnTambahPanel.setBackground(Color.blue);

        add(btnBatalPanel);
        btnBatalPanel.setBounds(370, 190, 100, 20);
        btnBatalPanel.setBackground(Color.lightGray);
    }

    public String getTfnim() {
        return tfnim.getText();
    }

    public String getTfnama() {
        return tfnama.getText();
    }

    public String getTaalamat() {
        return taalamat.getText();
    }


}

