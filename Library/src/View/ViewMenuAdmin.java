package View;

import Main.MVCAdminBook;
import Main.MVCAdminHistory;
import Main.MVCAdminMember;

import javax.swing.*;

import static java.awt.Color.red;
import static java.awt.Color.yellow;

public class ViewMenuAdmin extends JFrame{

    public MVCAdminMember mvcAdminMember = new MVCAdminMember();
    public MVCAdminBook mvcAdminBook = new MVCAdminBook();
    public MVCAdminHistory mvcAdminHistory = new MVCAdminHistory();

    public JPanel pMenu = new JPanel();

    public JButton bMember = new JButton("Member");
    public JButton bBook = new JButton("Book");
    public JButton bHistory = new JButton("History");
    public JButton bLogout = new JButton("Logout");
    JLabel lLine = new JLabel("____________________________________________________________________________________________________________________________________________________");

    public ViewMenuAdmin(){
        setDefaultCloseOperation(3);
        setLocation(0, 0);
        setResizable(false);
        setVisible(true);
        setLayout(null);
        setSize(800, 720);

        add(pMenu);
        add(mvcAdminMember.viewAdminMember.pMember);
        add(mvcAdminBook.viewAdminBook.pBook);
        add(mvcAdminHistory.viewAdminHistory.pHistory);

        reset();

        mvcAdminMember.viewAdminMember.pMember.setVisible(true);

        bLogout.setBackground(red);

        bMember.setBounds(260,10,90,20);
        bBook.setBounds(360,10,90,20);
        bHistory.setBounds(460,10,90,20);
        bLogout.setBounds(680,10,90,20);
        lLine.setBounds(0,25,1280,20);

        pMenu.setBounds(0,0,1280,50);
        pMenu.setLayout(null);

        pMenu.add(bMember);
        pMenu.add(bBook);
        pMenu.add(bHistory);
        pMenu.add(bLogout);
        pMenu.add(lLine);

    }

    public void reset() {
        mvcAdminMember.viewAdminMember.pMember.setVisible(false);
        mvcAdminBook.viewAdminBook.pBook.setVisible(false);
        mvcAdminHistory.viewAdminHistory.pHistory.setVisible(false);
    }

}
