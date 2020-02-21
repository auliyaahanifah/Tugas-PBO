public class PersegiPanjang {


    private double pjgDbl , lebarDbl  ;
    private int pjgInt , lebarInt ;
    static double luas;

    PersegiPanjang(double pjg ,double lebar ) {
        this.pjgDbl = pjg ;
        this.lebarDbl = lebar ;
    }

    double  luasPersegiPanjang (){
        this.luas = pjgDbl * lebarDbl ;
        return luas ;
    }

    int luasPersegiPanjang (int pjg, int lebar){
        this.pjgInt = pjg ;
        this.lebarInt = lebar ;
        luas = pjgInt * lebarInt ;
        return (int) luas;
    }

    void Volume (){
        System.out.println("Tiap Volume berbeda=beda");
    }
}
