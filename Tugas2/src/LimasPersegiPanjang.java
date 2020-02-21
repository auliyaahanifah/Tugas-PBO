public class LimasPersegiPanjang extends PersegiPanjang{

    double tinggiLimas;
    private  double volume ;

    public LimasPersegiPanjang(double pjg, double lebar) {
        super(pjg, lebar);
    }

    @Override
    double  luasPersegiPanjang (){
        return luas ;
    }

    double Volume (double Tinggi3d){
        this.tinggiLimas = Tinggi3d;
        volume =   1.0/3.0 * luasPersegiPanjang() * tinggiLimas ;
        return volume ;
    }

}