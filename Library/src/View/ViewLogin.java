package View;

import javax.swing.*;
import java.awt.*;

public class ViewLogin extends JFrame {

    Font font = new Font(Font.MONOSPACED, Font.BOLD, 45);//membuat font
    Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 20);
    Font font2 = new Font(Font.MONOSPACED, Font.BOLD, 17);

    JLabel label = new JLabel("LOGIN");
    JLabel label2 = new JLabel("Sebelum masuk Login terlebih dahulu. tidak punya AKUN? klik SIGN UP");
    JLabel label1 = new JLabel("SIGN UP");
    JLabel label3 = new JLabel("Daftarkan Diri Anda terlebih dahulu");

    JLabel lEmail = new JLabel("Email");
    public JTextField tfEmail = new JTextField();
    JLabel lPassword = new JLabel("Password");
    public JPasswordField tfPassword = new JPasswordField();

    JLabel lEmail1 = new JLabel("Email");
    public JTextField tfEmail1 = new JTextField();
    JLabel lName = new JLabel("Name");
    public JTextField tfName = new JTextField();
    JLabel lNoHp = new JLabel("No Hp");
    public  JTextField tfNoHp = new JTextField();
    JLabel lAddress = new JLabel("Address");
    public JTextField tfAddress = new JTextField();
    JLabel lPassword1 = new JLabel("Password");
    public JPasswordField tfPassword1 = new JPasswordField();

    public JButton bSignIn = new JButton("SIGN IN");
    public JButton bSignUp = new JButton("SIGN UP");
    public JButton bSimpan = new JButton("SIMPAN");
    public JButton bBatal = new JButton("BATAL");

    public ViewLogin(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLocation(450,200);
        setResizable(false);
        setVisible(true);
        setLayout(null);
        setSize(800, 500);

        label.setFont(font);
        add(label);
        label.setBounds(320, 50, 150, 50);

        label2.setFont(font2);
        add(label2);
        label2.setBounds(25, 80, 750, 80);

        label1.setFont(font);
        add(label1, BorderLayout.CENTER);
        label1.setBounds(312, 30, 200, 50);

        label3.setFont(font2);
        add(label3);
        label3.setBounds(200, 50, 750, 80);

        lEmail.setFont(font1);
        lPassword.setFont(font1);

        add(lEmail);
        lEmail.setBounds(175, 170, 100, 30);
        add(tfEmail);
        tfEmail.setBounds(280, 170, 250, 30);
        add(lPassword);
        lPassword.setBounds(175, 215, 100, 30);
        add(tfPassword);
        tfPassword.setBounds(280, 215, 250, 30);

        add(bSignIn);
        bSignIn.setBounds(280, 300, 100, 20);
        add(bSignUp);
        bSignUp.setBounds(420, 300, 100, 20);

        lEmail1.setFont(font1);
        lPassword1.setFont(font1);
        lName.setFont(font1);
        lNoHp.setFont(font1);
        lAddress.setFont(font1);

        add(lEmail1);
        lEmail1.setBounds(175, 125, 100, 30);
        add(tfEmail1);
        tfEmail1.setBounds(280, 125, 300, 30);
        add(lPassword1);
        lPassword1.setBounds(175, 170, 100, 30);
        add(tfPassword1);
        tfPassword1.setBounds(280, 170, 300, 30);
        add(lName);
        lName.setBounds(175, 215, 90, 30);
        add(tfName);
        tfName.setBounds(280, 215, 300, 30);
        add(lNoHp);
        lNoHp.setBounds(175, 260, 90, 30);
        add(tfNoHp);
        tfNoHp.setBounds(280, 260, 300, 30);
        add(lAddress);
        lAddress.setBounds(175, 300, 90, 30);
        add(tfAddress);
        tfAddress.setBounds(280, 300, 300, 30);

        add(bBatal);
        bBatal.setBounds(300, 350, 100, 20);
        add(bSimpan);
        bSimpan.setBounds(450, 350, 100, 20);

        moveSignIn();
    }
    public String getEmail() {
        return tfEmail.getText();
    }

    public String getPassword() {
        return tfPassword.getText();
    }

    public String getEmail1() {
        return tfEmail1.getText();
    }

    public String getPassword1() {
        return tfPassword1.getText();
    }

    public String getName() {
        return tfName.getText();
    }

    public String getNoHp() {
        return tfNoHp.getText();
    }

    public String getAddress() {
        return tfAddress.getText();
    }

    public void moveSignUp(){
        label.setVisible(false);
        label2.setVisible(false);
        lEmail.setVisible(false);
        lPassword.setVisible(false);
        tfEmail.setVisible(false);
        tfPassword.setVisible(false);
        bSignIn.setVisible(false);
        bSignUp.setVisible(false);

        label1.setVisible(true);
        label3.setVisible(true);
        lEmail1.setVisible(true);
        lPassword1.setVisible(true);
        tfEmail1.setVisible(true);
        tfPassword1.setVisible(true);
        lName.setVisible(true);
        tfName.setVisible(true);
        lNoHp.setVisible(true);
        tfNoHp.setVisible(true);
        lAddress.setVisible(true);
        tfAddress.setVisible(true);
        bSimpan.setVisible(true);
        bBatal.setVisible(true);
    }

    public void moveSignIn(){
        label.setVisible(true);
        label2.setVisible(true);
        lEmail.setVisible(true);
        lPassword.setVisible(true);
        tfEmail.setVisible(true);
        tfPassword.setVisible(true);
        bSignIn.setVisible(true);
        bSignUp.setVisible(true);

        label1.setVisible(false);
        label3.setVisible(false);
        lEmail1.setVisible(false);
        lPassword1.setVisible(false);
        tfEmail1.setVisible(false);
        tfPassword1.setVisible(false);
        lName.setVisible(false);
        tfName.setVisible(false);
        lNoHp.setVisible(false);
        tfNoHp.setVisible(false);
        lAddress.setVisible(false);
        tfAddress.setVisible(false);
        bSimpan.setVisible(false);
        bBatal.setVisible(false);
    }
}
