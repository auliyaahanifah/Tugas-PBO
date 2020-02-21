public class LimasSegitiga extends Segitiga{

    double tinggiLimas;
    private  double volume ;

    public LimasSegitiga(double alas, double tinggi) {
        super(alas, tinggi);
    }

    @Override
    double  luasSegitiga (){
        return luas ;
    }

    double Volume (double Tinggi3d){
        this.tinggiLimas = Tinggi3d;
        volume =   1.0/3.0 * luasSegitiga() * tinggiLimas ;
        return volume ;
    }

}