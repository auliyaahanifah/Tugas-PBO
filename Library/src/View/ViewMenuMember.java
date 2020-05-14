package View;

import Main.MVCMemberHome;
import Main.MVCMemberKembali;
import Main.MVCMemberPinjam;
import Main.Member;

import javax.swing.*;

import static java.awt.Color.red;

public class ViewMenuMember extends JFrame {
    Member member;

    public MVCMemberPinjam mvcMemberPinjam;
    public MVCMemberKembali mvcMemberKembali;
    public MVCMemberHome mvcMemberHome;

    public JPanel pMenu = new JPanel();

    public JButton bHome = new JButton("Home");
    public JButton bPinjam = new JButton("Pinjam");
    public JButton bKembali = new JButton("Kembali");
    public JButton bLogout = new JButton("Logout");
    JLabel lLine = new JLabel("____________________________________________________________________________________________________________________________________________________");

    public ViewMenuMember (Member member){
        this.member = member;
        mvcMemberPinjam = new MVCMemberPinjam(member);
        mvcMemberKembali = new MVCMemberKembali(member);
        mvcMemberHome = new MVCMemberHome(member);

        setDefaultCloseOperation(3);
        setLocation(0, 0);
        setResizable(false);
        setVisible(true);
        setLayout(null);
        setSize(800, 720);

        add(pMenu);
        add(mvcMemberHome.viewMemberHome.pHome);
        add(mvcMemberPinjam.viewMemberPinjam.pPinjam);
        add(mvcMemberKembali.viewMemberKembali.pKembali);

        reset();

        mvcMemberHome.viewMemberHome.pHome.setVisible(true);

        bLogout.setBackground(red);

        bHome.setBounds(260,10,90,20);
        bPinjam.setBounds(360,10,90,20);
        bKembali.setBounds(460,10,90,20);
        bLogout.setBounds(680,10,90,20);
        lLine.setBounds(0,25,1280,20);

        pMenu.setBounds(0,0,1280,50);
        pMenu.setLayout(null);

        pMenu.add(bHome);
        pMenu.add(bPinjam);
        pMenu.add(bKembali);
        pMenu.add(bLogout);
        pMenu.add(lLine);
    }

    public void reset() {
        mvcMemberHome.viewMemberHome.pHome.setVisible(false);
        mvcMemberPinjam.viewMemberPinjam.pPinjam.setVisible(false);
        mvcMemberKembali.viewMemberKembali.pKembali.setVisible(false);
    }
}
