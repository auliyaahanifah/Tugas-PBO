import javax.swing.*;


public class Swing extends JFrame {
    JPanel panell = new JPanel();
    final JTextField fnama = new JTextField(100);
    JLabel lnama = new JLabel ("Nama Lengkap ");
    final JTextField fnim = new JTextField(10);
    JLabel lnim = new JLabel("Nim");
    JLabel ljekel = new  JLabel ("Jenis Kelamin ");
    JRadioButton rbPria = new JRadioButton("Laki-laki");
    JRadioButton rbWanita = new JRadioButton("Perempuan");

    JLabel lagama = new JLabel("Agama ");
    String[] namaAgama =
            {"Islam", "Kristen", "Katolik", "Hindu", "Budha"};
    JComboBox cmbAgama = new JComboBox(namaAgama);

    JLabel lprodi = new JLabel("Prodi ");
    String[] namaProdi =
            {"T. Industri", "T. INFORMATIKA", "Sistem Informasi", "T. Kimia (S1)", "T. Kimia (D3)"};
    JComboBox cmbProdi = new JComboBox(namaProdi);

    final JTextArea falamat = new JTextArea();
    JLabel lalamat = new JLabel("Alamat");

    JButton jbSimpan =new JButton("Simpan");
    JButton jbBatal =new JButton("Batal");
    public Swing(){
        setTitle("BIODATA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(800, 600);

        ButtonGroup group = new ButtonGroup();
        group.add(rbPria);
        group.add(rbWanita);
        add(lnama);
        lnama.setBounds(10, 10, 150, 20);
        add(fnama);
        fnama.setBounds(130, 10, 250, 20);
        add(lnim);
        lnim.setBounds(10, 30, 120, 20);
        add(fnim);
        fnim.setBounds(130, 35, 150, 20);
        add(ljekel);
        ljekel.setBounds(10, 55, 120, 20);
        add(rbPria);
        rbPria.setBounds(130,55, 100, 20);
        add(rbWanita);
        rbWanita.setBounds(230,55, 100, 20);
        add(lagama);
        lagama.setBounds(10,70, 150, 20);
        add(cmbAgama);
        cmbAgama.setBounds(130,75, 150, 20);
        add(lprodi);
        lprodi.setBounds(10, 100, 166, 20);
        add(cmbProdi);
        cmbProdi.setBounds(130, 100, 166,20 );
        add(lalamat);
        lalamat.setBounds(10, 120, 500, 50);
        add(falamat);
        falamat.setBounds(130, 120, 500, 50);
        add(jbSimpan);
        jbSimpan.setBounds(250, 400, 100, 20);
        add(jbBatal);
        jbBatal.setBounds(400,400,100,20);


    }
}
