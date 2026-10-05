/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kostumify;

/**
 *
 * @author asus
 */
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static Kostum[] daftarKostum = new Kostum[100];
    static int jumlahData = 0;

    public static void main(String[] args) {

        daftarKostum[jumlahData++] = new KostumTradisional(
                "TRD001",
                "Kebaya Jawa",
                75000,
                3,
                "Baik",
                "Jawa Tengah",
                "Wanita"
        );

        daftarKostum[jumlahData++] = new KostumTradisional(
                "TRD002",
                "Baju Adat Sunda",
                80000,
                2,
                "Baik",
                "Jawa Barat",
                "Pria"
        );

        daftarKostum[jumlahData++] = new KostumKarakter(
                "KRT001",
                "Kostum Spiderman",
                120000,
                2,
                "Sangat Baik",
                "Spiderman",
                "M"
        );

        daftarKostum[jumlahData++] = new KostumKarakter(
                "KRT002",
                "Kostum Elsa",
                110000,
                3,
                "Baik",
                "Elsa",
                "M"
        );

        daftarKostum[jumlahData++] = new KostumAnime(
                "ANM001",
                "Kostum Naruto",
                100000,
                2,
                "Baik",
                "Naruto",
                "Naruto Uzumaki"
        );

        int pilihan;

        do {

            tampilkanMenu();

            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                    tambahKostum();
                    break;

                case 2:
                    tampilkanSemuaKostum();
                    break;

                case 3:
                    menuPencarian();
                    break;

                case 4:
                    simulasiDynamicBinding();
                    break;

                case 5:
                    sewaKostum();
                    break;

                case 6:
                    System.out.println();
                    System.out.println("Terima kasih telah menggunakan Kostumify!");
                    break;

                default:
                    System.out.println();
                    System.out.println("Pilihan menu tidak tersedia.");
            }

        } while (pilihan != 6);

        input.close();
    }

    static void tampilkanMenu() {

        System.out.println();
        System.out.println("==================================================");
        System.out.println("                    KOSTUMIFY");
        System.out.println("           Your Costume, Your Character");
        System.out.println("==================================================");
        System.out.println("1. Tambah Data Kostum");
        System.out.println("2. Tampilkan Seluruh Kostum");
        System.out.println("3. Cari Kostum");
        System.out.println("4. Simulasi Dynamic Binding");
        System.out.println("5. Sewa Kostum");
        System.out.println("6. Keluar");
        System.out.println("--------------------------------------------------");
        System.out.println(
                "Total kostum terdaftar : "
                + Kostum.getJumlahKostum()
        );
        System.out.println("==================================================");
    }

    static void tambahKostum() {

        System.out.println();
        System.out.println("----------- TAMBAH DATA KOSTUM -----------");
        System.out.println("1. Kostum Tradisional");
        System.out.println("2. Kostum Karakter");
        System.out.println("3. Kostum Anime");

        System.out.print("Pilih jenis kostum: ");
        int jenis = input.nextInt();
        input.nextLine();

        if (jenis < 1 || jenis > 3) {

            System.out.println("Jenis kostum tidak tersedia.");
            return;
        }

        System.out.print("Kode kostum       : ");
        String kode = input.nextLine();

        System.out.print("Nama kostum       : ");
        String nama = input.nextLine();

        System.out.print("Harga sewa/hari   : ");
        double harga = input.nextDouble();

        System.out.print("Stok              : ");
        int stok = input.nextInt();

        input.nextLine();

        System.out.print("Kondisi           : ");
        String kondisi = input.nextLine();

        if (jenis == 1) {

            System.out.print("Asal daerah       : ");
            String asalDaerah = input.nextLine();

            System.out.print("Jenis kelamin     : ");
            String jenisKelamin = input.nextLine();

            daftarKostum[jumlahData++]
                    = new KostumTradisional(
                            kode,
                            nama,
                            harga,
                            stok,
                            kondisi,
                            asalDaerah,
                            jenisKelamin
                    );

            System.out.println();
            System.out.println("Kostum tradisional berhasil ditambahkan.");

        } else if (jenis == 2) {

            System.out.print("Nama karakter     : ");
            String namaKarakter = input.nextLine();

            System.out.print("Ukuran kostum     : ");
            String ukuran = input.nextLine();

            daftarKostum[jumlahData++]
                    = new KostumKarakter(
                            kode,
                            nama,
                            harga,
                            stok,
                            kondisi,
                            namaKarakter,
                            ukuran
                    );

            System.out.println();
            System.out.println("Kostum karakter berhasil ditambahkan.");

        } else {

            System.out.print("Nama anime        : ");
            String namaAnime = input.nextLine();

            System.out.print("Nama tokoh        : ");
            String namaTokoh = input.nextLine();

            daftarKostum[jumlahData++]
                    = new KostumAnime(
                            kode,
                            nama,
                            harga,
                            stok,
                            kondisi,
                            namaAnime,
                            namaTokoh
                    );

            System.out.println();
            System.out.println("Kostum anime berhasil ditambahkan.");
        }
    }

    static void tampilkanSemuaKostum() {

        System.out.println();
        System.out.println("==================================================");
        System.out.println("              DAFTAR SELURUH KOSTUM");
        System.out.println("==================================================");

        if (jumlahData == 0) {

            System.out.println("Belum ada data kostum.");

        } else {

            for (int i = 0; i < jumlahData; i++) {

                System.out.println();
                System.out.println("Data ke-" + (i + 1));

                System.out.println("--------------------------------------------------");

                daftarKostum[i].tampilkanInfo();

                System.out.println("--------------------------------------------------");
            }
        }
    }

    static void menuPencarian() {

        System.out.println();
        System.out.println("--------------- CARI KOSTUM ----------------");
        System.out.println("1. Cari berdasarkan nama");
        System.out.println("2. Cari berdasarkan nomor data");

        System.out.print("Pilih: ");
        int pilihan = input.nextInt();
        input.nextLine();

        if (pilihan == 1) {

            System.out.print("Masukkan nama kostum: ");

            String nama = input.nextLine();

            cariData(nama);

        } else if (pilihan == 2) {

            System.out.print("Masukkan nomor data: ");
            int nomor = input.nextInt();
            cariData(nomor);

        } else {
            System.out.println("Pilihan tidak tersedia.");
        }
    }

    static void cariData(String nama) {

        boolean ditemukan = false;

        for (int i = 0; i < jumlahData; i++) {

            if (daftarKostum[i]
                    .getNamaKostum()
                    .equalsIgnoreCase(nama)) {

                System.out.println();
                System.out.println("Kostum ditemukan:");
                System.out.println("--------------------------------------------------");
                daftarKostum[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {

            System.out.println("Kostum dengan nama tersebut tidak ditemukan.");
        }
    }

    static void cariData(int nomorData) {

        if (nomorData >= 1
                && nomorData <= jumlahData) {

            System.out.println();
            System.out.println("Kostum ditemukan:");

            System.out.println("--------------------------------------------------");

            daftarKostum[nomorData - 1]
                    .tampilkanInfo();

        } else {

            System.out.println("Nomor data tidak tersedia.");
        }
    }

    static void simulasiDynamicBinding() {

        System.out.println();
        System.out.println("--------- SIMULASI DYNAMIC BINDING ---------");
        System.out.println("Pilih nomor data kostum:");

        for (int i = 0; i < jumlahData; i++) {

            System.out.println((i + 1) + ". " + daftarKostum[i].getNamaKostum());
        }

        System.out.print("Pilihan: ");
        int nomor = input.nextInt();
        input.nextLine();

        if (nomor >= 1 && nomor <= jumlahData) {

            Kostum kostumDipilih
                    = daftarKostum[nomor - 1];

            prosesKostum(kostumDipilih);

        } else {

            System.out.println("Nomor data tidak tersedia.");
        }
    }

    static void prosesKostum(Kostum kostum) {

        System.out.println();
        System.out.println("Objek diterima oleh method prosesKostum().");
        System.out.println("Tipe referensi: Kostum");
        System.out.println();
        System.out.println("Method tampilkanInfo() dipanggil:");

        System.out.println("--------------------------------------------------");

        kostum.tampilkanInfo();

        System.out.println("--------------------------------------------------");

        System.out.println("Java memanggil method sesuai objek aslinya.");
    }

    static void sewaKostum() {

        System.out.println();
        System.out.println("--------------- SEWA KOSTUM ----------------");

        System.out.print("Masukkan kode kostum : ");
        String kode = input.nextLine();
        Kostum kostum = cariDenganKode(kode);

        if (kostum == null) {
            System.out.println("Kode kostum tidak ditemukan.");
            return;
        }

        System.out.println();
        System.out.println("Kostum yang dipilih:");
        System.out.println("--------------------------------------------------");
        kostum.tampilkanInfo();
        System.out.println("--------------------------------------------------");

        System.out.print("Jumlah hari sewa     : ");
        int hari = input.nextInt();

        System.out.print("Jumlah kostum        : ");
        int jumlah = input.nextInt();

        input.nextLine();

        if (hari <= 0 || jumlah <= 0) {
            System.out.println("Jumlah hari dan jumlah kostum " + "harus lebih dari 0.");
            return;
        }

        if (jumlah > kostum.getStok()) {

            System.out.println();
            System.out.println("Stok tidak mencukupi.");
            System.out.println("Stok tersedia : " + kostum.getStok());

            return;
        }

        double total = kostum.hitungSewa(
                hari,
                jumlah);

        kostum.setStok(kostum.getStok() - jumlah);

        System.out.println();
        System.out.println("==================================================");
        System.out.println("                 DETAIL SEWA");
        System.out.println("==================================================");
        System.out.println("Nama Kostum   : " + kostum.getNamaKostum());
        System.out.printf("Harga/Hari    : Rp%.0f%n", kostum.getHargaSewa());
        System.out.println("Jumlah Hari   : " + hari);
        System.out.println("Jumlah Kostum : " + jumlah);
        System.out.println("Stok Sisa     : " + kostum.getStok());
        System.out.println("--------------------------------------------------");
        System.out.printf("TOTAL BIAYA   : Rp%.0f%n", total);
        System.out.println("==================================================");
        System.out.println("Penyewaan berhasil!");
    }

    static Kostum cariDenganKode(String kode) {

        for (int i = 0; i < jumlahData; i++) {

            if (daftarKostum[i]
                    .getKodeKostum()
                    .equalsIgnoreCase(kode)) {

                return daftarKostum[i];
            }
        }

        return null;
    }
}
