package HangMan;

import java.util.Scanner;
public class Hangman {
    static Scanner data = new Scanner (System.in);
    static Scanner dt = new Scanner (System.in);
    static int pilih; static String nama;
    
    public static void main(String[] args) {
        System.out.println("+++Selamat datang di game Hangman+++");
        boolean ulang = true; String keluar;
        InputNama(); // memanggil method InputNama
        
        while (ulang==true){
            AcakPilihan(); // memanggil method AcakPilihan
            Tebak(); // memanggil method Tebak
            Jawaban();  // memanggil method Jawaban
            Pertanyaan();   // memanggil method Pertanyaan
            
            // Konfirmasi keluar dari permaianan
            System.out.println("\nMasih ingin lanjut ?\nTekan \"N\" untuk keluar\nTekan selain \"N\" untuk lanjut");
            keluar = dt.nextLine();
            if (keluar.equalsIgnoreCase("N")) {
                break;
            }
        }
    }
    // Method untuk memasukkan nama user
    public static String InputNama() {
        System.out.print("Masukkan nama Anda : ");
        nama = dt.nextLine(); return nama;
    }

    // Method untuk mengambil angka acak
    public static int AcakPilihan() {
        pilih = (int) (Math.random()*29); return pilih;
    }
    // Method untuk menjawab kata yang akan ditebak
    public static void Tebak() {
        int nyawa = 4; 
        String kuis;
        String kunci = Jawaban();
        String kosong = "";
        for (int i = 0; i < kunci.length(); i++) {
            kosong += "_";
        }
        char[] ubahkosong = kosong.toCharArray(); // ubah String ke Array
        char[] ubahkunci = kunci.toCharArray(); // ubah String ke Array
        do {
            if (nyawa==0) {
                System.out.println(HangMan(4));
                System.out.println(nama+", kamu kalah");
                System.out.println("Jawaban yang benar "+Jawaban());
                break;
            } else if (nyawa==3) {
                System.out.println(HangMan(1));
                System.out.println("Nyawa "+nyawa);
            } else if (nyawa==2) {
                System.out.println(HangMan(2));
                System.out.println("Nyawa "+nyawa);
            } else if (nyawa==1) {
                System.out.println(HangMan(3));
                System.out.println("Nyawa "+nyawa);
            } else {
                System.out.println(HangMan(0));
                System.out.println("Nyawa "+nyawa);
            }
            System.out.println("Pertanyaan : "+Pertanyaan()); // menampilkan pertanyaan
            // untuk menampilkan kata yang ingin ditebak format ( _ _ _ _ )
            for (int i = 0; i < kosong.length(); i++) {
                System.out.print(ubahkosong[i]+" ");
            } System.out.println();
            // untuk memasukkan inputan huruf yang ditebak
            System.out.print("Tebak huruf satu persatu : ");
            kuis = data.next();
            String kuis2 = kuis.toLowerCase(); // ubah inputan jadi huruf kecil
            char tebak = kuis2.charAt(0); // mengambil huruf pertama dari inputan

            // untuk mengubah kata kosong menjadi kata yang ditebak jika benar
            if (kunci.contains(kuis2)) {
                for (int i = 0; i < kunci.length(); i++) {
                    if (ubahkunci[i]==tebak) {
                        ubahkosong[i]=tebak; }
                }
            } else {
                nyawa -= 1;
            }
            String lihat = new String(ubahkosong); // variabel lihat = variabel ubah kosong
            // cek apakah variabel lihat sudah berisi semua karakter dari variabel kunci
            if (lihat.contains(kunci)) {
                System.out.println();
                System.out.println("Jawaban Anda Benar = " + Jawaban());
                System.out.println(HangMan(5));
                System.out.println("Selamat " + nama + " kamu menang");
                break;
            } System.out.println();
        } while (nyawa <=4 );
    }
    // Method untuk Pertanyaan dengan urutan dari method AcakPilihan
    public static String Pertanyaan() {
        String Pertanyaan[] = {"pemain terbaik dunia 2014","pemain terbaik dunia 4 kali","pemain termahal","no 11 barcelona","gelandang dortmund","gelandang Munchen",
        "kiper Chelsea","striker MU","striker MU","gelandang madrid","gelandang hotspur","no 10 chelsea","striker arsenal","striker arsenal",
        "raja assist chelsea","striker chelsea","kapten MU","pencetak gol terbanyak chelsea","kapten Chelsea","gelandang bertahan chelsea",
        "gelandang MU","kapten Liverpool","kiper Liverpool","kiper MU","kiper Mancherter City","gelandang Chelsea","bek Chelsea","bek Madrid",
        "bek Barcelona"};
        for (int i = 0; i < Pertanyaan.length; i++) {
            Pertanyaan[i] = Pertanyaan[i];
        }
        return Pertanyaan[pilih];
    }
    // Method untuk Jawaban dengan urutan dari method AcakPilihan    
    public static String Jawaban() {
        String Jawaban[] = {"ronaldo","messi","bale","neymar","reus","gotze","courtois","persie","falcao","rodriguez","lamela","hazard",
                            "sanchez","giroud","fabregas","costa","rooney","lampard","terry","matic","fellaini","gerrard","mignolet","gea",
                            "hart","oscar","cahill","ramos","pique"};
        for (int i = 0; i < Jawaban.length; i++) {
            Jawaban[i]=Jawaban[i];
        }
        return Jawaban[pilih];
    }
    // method berisi gambar HangMan
    public static String HangMan(int a) {
        String gambar[] = new String[6];
        gambar[0] = "=================\n|          PLAY |\n|           OR  |\n|      O   DIE! |\n|     /|\\       |\n|     / \\       |\n=================";
        gambar[1] = "=============|===\n|            O  |\n|               |\n|      O        |\n|     /|\\       |\n|     / \\       |\n=================";
        gambar[2] = "=============|===\n|            O  |\n|               |\n|            O  |\n|           /|\\ |\n|           / \\ |\n=================";
        gambar[3] = "=============|===\n|            O  |\n|           /|\\ |\n|           / \\ |\n|               |\n|               |\n=================";
        gambar[4] = "=============|===\n|            O  |\n|  You          |\n|    Die!   \\O/ |\n|            |  |\n|           / \\ |\n=================";
        gambar[5] = "=================\n|   Hore!!!     |\n|               |\n|     \\O/       |\n|      |        |\n|     / \\       |\n=================";
        return gambar[a];
    }
}