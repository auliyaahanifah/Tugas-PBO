public class Asisten extends AsistenAdminProses implements Seleksi{
    private double nilai;
    private double tMicroteaching;
    private String nama;
    private String nim;

    public Asisten (double tMicroteaching, double tTulis, double tCoding, double tWawancara, String nama, String nim) {
        super(tTulis,tCoding,tWawancara);
        this.tMicroteaching = tMicroteaching;
        this.nama = nama;
        this.nim = nim;
    }

    public double hasilNilai() {
        nilai = (getHasilNilai() + (tMicroteaching))/4;
        return nilai;
    }

    @Override
    public void getHasil() {
        System.out.println("============================== KETERANGAN ============================== ");
        System.out.println("Kepada " +nim+ " Atas Nama " +nama+ " Dinyatakan > " +kelulusan(hasilNilai()) + " < Seleksi Asisten Laboratorium");
        System.out.println("Dengan Nilai Akhir : " + hasilNilai());
        System.out.println();
    }
}