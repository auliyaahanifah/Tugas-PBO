public class Segitiga {

    private double alasDbl , tinggiDbl  ;
    private int alasInt , tinggiInt ;
    static double luas;

    Segitiga(double alas ,double tinggi ) {
        this.alasDbl = alas ;
        this.tinggiDbl = tinggi ;
    }

    double  luasSegitiga (){
        this.luas = 1.0/2.0 * alasDbl * tinggiDbl ;
        return luas ;
    }

    int luasSegitiga (int alas, int tinggi){
        this.alasInt = alas ;
        this.tinggiInt = tinggi ;
        luas = alasInt * tinggiInt / 2  ;
        return (int) luas;
    }

    void Volume (){
        System.out.println("Tiap Volume berbeda=beda");
    }
}