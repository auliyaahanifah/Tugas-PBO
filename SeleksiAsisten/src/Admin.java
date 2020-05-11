public class Admin extends AsistenAdminProses implements Seleksi{
    private double nilai;
    private double tJaringan;
    private String nama;
    private String nim;

    public Admin (double tJaringan, double tTulis, double tCoding, double tWawancara, String nama, String nim) {
        super(tTulis,tCoding,tWawancara);
        this.tJaringan = tJaringan;
        this.nama = nama;
        this.nim = nim;
    }

    public double hasilNilai() {
        nilai = (getHasilNilai() + (tJaringan))/4;
        return nilai;
    }

    @Override
    public void getHasil() {
        System.out.println("============================== KETERANGAN ============================== ");
        System.out.println("Kepada " +nim+ " Atas Nama " +nama+ " Dinyatakan > " +kelulusan(hasilNilai()) + " < Seleksi Admin Laboratorium");
        System.out.println("Dengan Nilai Akhir : " + hasilNilai());
        System.out.println();
    }
}