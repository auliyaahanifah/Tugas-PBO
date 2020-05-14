package Controller;

import Main.MVCMenuAdmin;
import Main.MVCMenuMember;
import Main.Member;
import Model.ModelSignIn;
import View.ViewLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerSignIn implements ActionListener {

    ViewLogin viewLogin;
    ModelSignIn modelSignIn;

    public ControllerSignIn(ViewLogin viewLogin, ModelSignIn modelSignIn) {
        this.viewLogin = viewLogin;
        this.modelSignIn = modelSignIn;

        viewLogin.moveSignIn();
        viewLogin.bSignIn.addActionListener(this);
        viewLogin.bSignUp.addActionListener(this);
        viewLogin.bBatal.addActionListener(this);
        viewLogin.bSimpan.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewLogin.bSignIn){
            signIn();
        } else if (e.getSource() == viewLogin.bSignUp){
            viewLogin.moveSignUp();
        } else if (e.getSource() == viewLogin.bBatal){
            viewLogin.moveSignIn();
        } else if (e.getSource() == viewLogin.bSimpan){
            signUp();
        }
        reset();
    }

    public void signIn(){
        String email = viewLogin.getEmail();
        String password = viewLogin.getPassword();

        if (email.equals("admin") && password.equals("admin123")){
            JOptionPane.showMessageDialog(null, "Berhasil Masuk!");
            viewLogin.setVisible(false);
            MVCMenuAdmin mvcMenuAdmin = new MVCMenuAdmin();
        } else {
            if (email.equals("") || password.equals("")) {
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
            } else {
                if (modelSignIn.getCountForSignIn(email, password) == 1) {
                    JOptionPane.showMessageDialog(null, "Berhasil Masuk!");
                    viewLogin.setVisible(false);

                    String data[] = modelSignIn.getMember(email, password);
                    Member member = new Member(data[0], data[1]);

                    MVCMenuMember mvcMenuMember = new MVCMenuMember(member);
                } else {
                    JOptionPane.showMessageDialog(null, "Email / Password Salah");
                }
            }
        }
    }

    public void signUp(){
        String email = viewLogin.getEmail1();
        String name = viewLogin.getName();
        String noHp = viewLogin.getNoHp();
        String address = viewLogin.getAddress();
        String password = viewLogin.getPassword1();

        if (email.equals("") || name.equals("") || noHp.equals("") || address.equals("") || password.equals("") ){
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
        } else {
            if (modelSignIn.insertMember(email,name,noHp,address,password) == 1){
                JOptionPane.showMessageDialog(null,"Berhasil Daftar!");
                viewLogin.moveSignIn();
            } else {
                JOptionPane.showMessageDialog(null,"Email Telah Terdaftar!");
            }
        }
    }

    public void reset(){
        viewLogin.tfPassword.setText("");
        viewLogin.tfPassword1.setText("");
        viewLogin.tfEmail.setText("");
        viewLogin.tfEmail1.setText("");
        viewLogin.tfAddress.setText("");
        viewLogin.tfName.setText("");
        viewLogin.tfNoHp.setText("");
    }
}
