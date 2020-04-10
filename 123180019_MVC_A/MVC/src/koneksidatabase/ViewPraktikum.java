package koneksidatabase;

import java.awt.*;

import static java.awt.Color.*;
import static java.awt.SystemColor.window;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ViewPraktikum extends JFrame {

    JLabel lNim = new JLabel("Nim  ");
    JTextField tfnim = new JTextField();
    JLabel lNamaMhs = new JLabel ("Nama Mahasiswa  ");
    JTextField tfNamaMhs = new JTextField();
    JLabel lAlamatMhs = new JLabel ("Alamat Mahasiswa ");
    JTextField tfAlamatMhs = new JTextField();


    JButton btnTambahPanel = new JButton("Tambah");
    JButton btnBatalPanel = new JButton("Batal");
    JButton btnHapusPanel = new JButton("Hapus");
    JButton btnEditPanel = new JButton("Edit");
    JLabel lform= new JLabel ("FORM PENGISIAN DATA MAHASISWA");
    JLabel lData= new JLabel (" 'DATA MAHASISWA'  ");

    JTable tabel;
    DefaultTableModel tableModel;

    JScrollPane scrollPane;  //buat scroll
    Object namaKolom[] = {"NIM","Nama","Alamat"}; //membuat kolom dalam array


    public ViewPraktikum(){

        tableModel = new DefaultTableModel(namaKolom,0); //0 baris
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        tabel.setBackground(pink);

        setTitle("Data Mahasiswa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(600, 500);
        getContentPane().setBackground(orange);

        //TABEL
        add(scrollPane);
        scrollPane.setBackground(PINK);
        scrollPane.setBounds(20, 215, 700, 300);
        //scrollPane.setBounds(20, 145, 700, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(lform);
        lform.setBounds(160,5, 720, 20);
        add(lNim);
        lNim.setBounds(20, 35, 250, 20);
        add(tfnim);
        tfnim.setBounds(150, 35, 250, 20);
        add(lNamaMhs);
        lNamaMhs.setBounds(20, 60, 250, 20);
        add(tfNamaMhs);
        tfNamaMhs.setBounds(150, 60, 250, 20);
        add(lAlamatMhs);
        lAlamatMhs.setBounds(20, 85, 250, 20);
        add(tfAlamatMhs);
        tfAlamatMhs.setBounds(150, 85, 250, 20);

        add(btnTambahPanel);
        btnTambahPanel.setBounds(175, 115, 90, 20);
        btnTambahPanel.setBackground(pink);
        add(btnBatalPanel);
        btnBatalPanel.setBounds(285, 115, 90, 20);
        btnBatalPanel.setBackground(Color.lightGray);

        add(lData);
        lData.setBounds(300, 155,720, 20);
        //lData.setForeground(BLACK);
        add(btnHapusPanel);
        btnHapusPanel.setBounds(20, 185, 90, 20);
        btnHapusPanel.setBackground(Color.red);
        add(btnEditPanel);
        btnEditPanel.setBounds(130, 185, 90, 20);
        btnEditPanel.setBackground(Color.blue);
    }
    public String getNim(){
        return tfnim.getText();
    }

    public String getNamaMhs(){
        return tfNamaMhs.getText();
    }

    public String getAlamatMhs(){
        return tfAlamatMhs.getText();
    }
}