public class VolBalok extends PersegiPanjang {

    double tinggi;
    private double volume ;

    public VolBalok(double pjg, double lebar) {
        super(pjg, lebar);
    }

    @Override
    double  luasPersegiPanjang (){

        return luas ;
    }

    double Volume (double Tinggi3d){
        this.tinggi = Tinggi3d;
        volume =   luasPersegiPanjang() * tinggi ;
        return volume ;
    }

}
