public class PrismaSegitiga extends Segitiga {

    double tinggiPrisma;
    private  double volume ;

    public PrismaSegitiga(double alas, double tinggi) {
        super(alas, tinggi);
    }

    @Override
    double  luasSegitiga (){
        return luas ;  // luasnya static
    }

    double Volume (double Tinggi3d){
        this.tinggiPrisma = Tinggi3d;
        volume =   luasSegitiga() * tinggiPrisma ;
        return volume ;
    }

}