import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int banyak;
        double tTulis=0;
        double tCoding=0;
        double tWawancara=0;
        double tMicroteaching=0;
        double tJaringan=0;
        String nama, nim, back;

        do{
            try{
                System.out.println("========== MENU PENDAFTARAN ==========");
                System.out.println("1. Asisten Laboratorium");
                System.out.println("2. Admin Laboratorium");
                System.out.print("Pilih Jenis Pendaftaran: ");
                int menu = input.nextInt();

                switch (menu) {
                    case 1:
                        System.out.println("\nPENDAFTARAN ASISTEN LABORATORIUM");
                        System.out.print("Berapa data yang akan di inputkan : ");
                        banyak = input.nextInt();
                        for (int i = 0; i < banyak; i++) {
                            input.nextLine();
                            System.out.print("Masukkan NIM\t\t\t: ");
                            nim = input.nextLine();
                            System.out.print("Masukkan Nama\t\t\t: ");
                            nama = input.nextLine();
                            System.out.print("Nilai Tes Tulis \t\t: ");
                            tTulis = input.nextInt();
                            System.out.print("Nilai Tes Coding\t \t: ");
                            tCoding = input.nextInt();
                            System.out.print("Nilai Tes Wawancara \t: ");
                            tWawancara = input.nextInt();
                            System.out.print("Nilai Tes Microteaching\t: ");
                            tMicroteaching = input.nextInt();
                            Asisten asisten = new Asisten(tMicroteaching,tTulis,tCoding,tWawancara,nama,nim);
                            asisten.getHasil();
                            System.out.println();
                        }
                        break;
                    case 2:
                        System.out.println("\nFORM PENDAFTARAN ADMIN LABORATORIUM");
                        System.out.print("Berapa data yang akan di inputkan : ");
                        banyak = input.nextInt();
                        for (int i = 0; i < banyak; i++) {
                            input.nextLine();
                            System.out.print("Masukkan NIM\t\t: ");
                            nim = input.nextLine();
                            System.out.print("Masukkan Nama\t\t: ");
                            nama = input.nextLine();
                            System.out.print("Nilai Tes Tulis\t\t: ");
                            tTulis = input.nextInt();
                            System.out.print("Nilai Tes Coding\t: ");
                            tCoding = input.nextInt();
                            System.out.print("Nilai Tes Wawancara\t: ");
                            tWawancara = input.nextInt();
                            System.out.print("Nilai Tes Jaringan\t: ");
                            tJaringan = input.nextInt();
                            Admin admin = new Admin(tJaringan,tTulis,tCoding,tWawancara,nama,nim);
                            admin.getHasil();
                            System.out.println();
                        }
                        break;
                }
            }catch (Exception e2){
                System.err.println("Input Harus Bilangan Bulat");
            }finally {
                input.nextLine();
                System.out.print("Kembali ke menu utama? (y/n) : ");
                back = input.nextLine().toLowerCase();
                System.out.println();
            }
        }while(back.equals("y"));
    }
}