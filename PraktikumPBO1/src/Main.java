
import java.util.Scanner;
public class Main{

    public static void main(String[] args) {
        String nama;
        int banyak, max, min;
        float mean, jumlah= 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Nama = ");
        nama = sc.nextLine();
        System.out.print("Masukan banyak nilai = ");
        banyak = sc.nextInt();
        int[] nilai = new int[banyak];
        for (int i = 0; i < banyak; i++)
        {
            System.out.print("Nilai ke-" + (1 + i) + " = ");
            nilai[i] = sc.nextInt();
            jumlah = jumlah + nilai[i];
        }
        mean = jumlah / banyak;
        System.out.println();
        max = nilai[0];
        min = nilai[0];
        for (int i = 0; i < banyak; i++)
        {
            if (max <= nilai[i]) max = nilai[i];
            if (min >= nilai[i]) min = nilai[i];
        }
        System.out.println("Nama = " + nama);
        System.out.println("Nilai Tertinggi = " + max);
        System.out.println("Nilai Terendah = " + min);
        System.out.println("Rata-rata = " + mean);
    }
}

