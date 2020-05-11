public class AsistenAdminProses {
    protected double nilai;
    private double tTulis;
    private double tCoding;
    private double tWawancara;

    public AsistenAdminProses(double tTulis, double tCoding, double tWawancara) {
        this.tTulis = tTulis;
        this.tCoding = tCoding;
        this.tWawancara = tWawancara;
    }
    public String kelulusan(double nilai) {
        if (nilai>85) {
            return "LOLOS";
        } else {
            return "GAGAL";
        }
    }
    public double getHasilNilai() {
        nilai = (tTulis + tCoding + tWawancara);
        return nilai;
    }
}