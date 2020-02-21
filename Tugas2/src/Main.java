import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int pilih;
        char lanjut=0;
        do {
            System.out.println(" ");
            System.out.println("---------------Menu---------------");
            System.out.println("1. PersegiPanjang dan turunannya |");
            System.out.println("2. Segitiga dan turunannya       |");
            System.out.println("----------------------------------");
            System.out.print("Pilihan : ");
            pilih = input.nextInt();

            if (pilih == 1) {
                double pjg,lebar ,Tinggi ;

                System.out.println("\n-----PERSEGIPANJANG DAN URUTANNYA-----");
                System.out.print("Panjang : " );
                pjg = input.nextDouble();
                System.out.print("Lebar : " );
                lebar = input.nextDouble();
                System.out.print("Tinggi  : ");
                Tinggi = input.nextDouble();

                System.out.println("\n--------PersegiPanjang--------");
                PersegiPanjang persegi = new PersegiPanjang(pjg, lebar );
                System.out.println("Luas PersegiPanjang (Bisa Koma): " +  persegi.luasPersegiPanjang());
                System.out.println("Luas JajarGenjang (Pembulatan): " +  persegi.luasPersegiPanjang( (int)pjg, (int)lebar)  );

                System.out.println("\n------Balok------");
                VolBalok vol = new VolBalok(pjg,lebar);
                System.out.print("Volume Balok : " + vol.Volume(Tinggi));

                System.out.println("\n\n------Limas PersegiPanjang------");
                LimasPersegiPanjang limas = new LimasPersegiPanjang (pjg, lebar);
                System.out.println("Volum1e Limas PersegiPanjang : " + limas.Volume(Tinggi));

            }
            else if (pilih == 2) {
                double alas ,tinggi , Tinggi3d ;

                System.out.println("-----SEGITIGA DAN TURUNANNYA-----");
                System.out.print("Alas : " );
                alas = input.nextDouble();
                System.out.print("Tinggi alas : " );
                tinggi = input.nextDouble();
                System.out.print("Tinggi Bangun 3D : " );
                Tinggi3d = input.nextDouble();

                System.out.println("\n--------Segitiga--------");
                Segitiga s3 = new Segitiga(alas ,tinggi );
                System.out.println("Luas Segitiga(Bisa Koma) : " +  s3.luasSegitiga());
                System.out.println("Luas Segitiga(Pembulatan) : " +  s3.luasSegitiga((int)alas,(int)tinggi));

                System.out.println("\n------Prisma Segitiga------");
                PrismaSegitiga ps = new PrismaSegitiga(alas, tinggi );
                System.out.print("Volume Prisma Segitiga : " + ps.Volume(Tinggi3d));

                System.out.println("\n\n-------Limas Segitiga-------");
                LimasSegitiga limas = new LimasSegitiga (alas,tinggi);
                System.out.println("Volum1e Limas Segitiga: " + limas.Volume(Tinggi3d));

            }
            else {
                System.out.println("Masukkan Pilihan dengan Benar :) \n");
            }
            System.out.println(" ");
            System.out.print("Ingin Melanjutkan (y/n) ? ");
            lanjut = input.next().charAt(0);
        } while (lanjut=='y');

    }

}

