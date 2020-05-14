package View;

        import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
        import java.awt.*;

public class ViewMemberKembali extends JFrame {
    Font font = new Font(Font.MONOSPACED, Font.BOLD, 45);//membuat font
    Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 20);

    public JPanel pKembali = new JPanel();

    JLabel lJudulHome = new JLabel("Buku Kembali");
    JLabel lJudul1 = new JLabel("Klik pada tabel Buku yang ingin dikembalikan");

    JLabel lSearch = new JLabel("SEARCH");
    public JTextField tfSearch = new JTextField();

    public JButton bSearch = new JButton("SEARCH");
    public JButton bRefresh = new JButton("REFRESH");

    public JTable table;
    public DefaultTableModel tableModel;
    JScrollPane scrollPane;

    public Object coloumnName[] = {"NoCard", "#", "Title","Author","Tgl Pinjam"};

    public  ViewMemberKembali() {
        tableModel = new DefaultTableModel(coloumnName, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        pKembali.setLayout(null);
        pKembali.setSize(800,670);

        lJudulHome.setFont(font);
        pKembali.add(lJudulHome);
        lJudulHome.setBounds(40, 60, 500, 50);

        lJudul1.setFont(font1);
        pKembali.add(lJudul1);
        //lJudul1.setBounds(80, 80, 500,50);
        lJudul1.setBounds(80, 140, 600,50);

        pKembali.add(scrollPane);
        scrollPane.setBounds(75, 250, 600, 400);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pKembali.add(lSearch);
        lSearch.setBounds(75,200,80,20);
        pKembali.add(tfSearch);
        tfSearch.setBounds(130,200,350,20);

        pKembali.add(bSearch);
        bSearch.setBounds(480,200,90,20);
        pKembali.add(bRefresh);
        bRefresh.setBounds(570,200,100,20);
    }

    public String getSearch() {
        return tfSearch.getText();
    }
}
