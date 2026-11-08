/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kostumify;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static RentalKostum rental = new RentalKostum("Kostumify");
    static TransaksiSewa transaksi = new TransaksiSewa();


    public static void main(String[] args) {

        rental.tambahKostum(new KostumTradisional(
                "TRD001",
                "Kebaya Jawa",
                75000,
                3,
                "Baik",
                "Jawa Tengah",
                "Wanita"
        ));

        rental.tambahKostum(new KostumTradisional(
                "TRD002",
                "Baju Adat Sunda",
                80000,
                2,
                "Baik",
                "Jawa Barat",
                "Pria"
        ));

        rental.tambahKostum(new KostumKarakter(
                "KRT001",
                "Kostum Spiderman",
                120000,
                2,
                "Sangat Baik",
                "Spiderman",
                "M"
        ));

        rental.tambahKostum(new KostumKarakter(
                "KRT002",
                "Kostum Elsa",
                110000,
                3,
                "Baik",
                "Elsa",
                "M"
        ));

        rental.tambahKostum(new KostumAnime(
                "ANM001",
                "Kostum Naruto",
                100000,
                2,
                "Baik",
                "Naruto",
                "Naruto Uzumaki"
        ));
        
        rental.tambahPelanggan(new Pelanggan("PLG001", "Andi"));
        rental.tambahPelanggan(new Pelanggan("PLG002", "Siti"));
        rental.tambahPelanggan(new Pelanggan("PLG003", "Budi"));
     
        rental.bukaRental();
        
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
                    rental.lihatSemuaKostum();
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
                    rental.lihatSemuaPelanggan();
                    break;
                    
                case 7:
                    prosesTransaksiSewa();
                    break;

                case 8:
                    System.out.println();
                    System.out.println("Terima kasih telah menggunakan Kostumify!");
                    break;

                default:
                    System.out.println();
                    System.out.println("Pilihan menu tidak tersedia.");
            }

        } while (pilihan != 8);

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
        System.out.println("6. Kelola Data Pelanggan");
        System.out.println("7. Transaksi Sewa");
        System.out.println("8. Keluar");
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

            rental.tambahKostum(new KostumTradisional(
                            kode,
                            nama,
                            harga,
                            stok,
                            kondisi,
                            asalDaerah,
                            jenisKelamin
            ));

            System.out.println();
            System.out.println("Kostum tradisional berhasil ditambahkan.");

        } else if (jenis == 2) {

            System.out.print("Nama karakter     : ");
            String namaKarakter = input.nextLine();

            System.out.print("Ukuran kostum     : ");
            String ukuran = input.nextLine();

            rental.tambahKostum(new KostumKarakter(
                            kode,
                            nama,
                            harga,
                            stok,
                            kondisi,
                            namaKarakter,
                            ukuran
            ));

            System.out.println();
            System.out.println("Kostum karakter berhasil ditambahkan.");

        } else {

            System.out.print("Nama anime        : ");
            String namaAnime = input.nextLine();

            System.out.print("Nama tokoh        : ");
            String namaTokoh = input.nextLine();

            rental.tambahKostum(new KostumAnime(
                            kode,
                            nama,
                            harga,
                            stok,
                            kondisi,
                            namaAnime,
                            namaTokoh
            ));

            System.out.println();
            System.out.println("Kostum anime berhasil ditambahkan.");
        }
    }

    static void tampilkanSemuaKostum() {
        rental.lihatSemuaKostum();
}

    static void menuPencarian() {

        System.out.println();
        System.out.println("--------------- CARI KOSTUM ----------------");
        System.out.println("1. Cari berdasarkan nama");
        System.out.println("2. Cari berdasarkan nomor data");
        try {
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

            } catch (KostumTidakDitemukanException e) {

            System.out.println("Terjadi kesalahan: " + e.getMessage());

            } catch (InputMismatchException e) {

            System.out.println("Error: Input harus berupa angka.");
            input.nextLine();
    
            } finally {

            System.out.println("Proses pencarian selesai.");
            }

            }
    

    static void cariData(String nama) throws KostumTidakDitemukanException {
        Kostum kostum = rental.cariKostum(nama);

    if (kostum != null) {
        System.out.println();
        System.out.println("Kostum ditemukan:");
        System.out.println("--------------------------------------------------");
        kostum.tampilkanInfo();
    } else {
        throw new KostumTidakDitemukanException(
                "Kostum dengan nama '" + nama + "' tidak ditemukan."
        );
    }
    }
    

    static void cariData(int nomorData) throws KostumTidakDitemukanException {
        Kostum kostum = rental.cariKostum(nomorData);

    if (kostum != null) {
        System.out.println();
        System.out.println("Kostum ditemukan:");
        System.out.println("--------------------------------------------------");
        kostum.tampilkanInfo();
    } else {
        throw new KostumTidakDitemukanException(
                "Nomor data " + nomorData + " tidak tersedia."
        );
    }
    }


   static void simulasiDynamicBinding() {

        System.out.println();
        System.out.println("--------- SIMULASI DYNAMIC BINDING ---------");
        System.out.println("Pilih nomor data kostum:");

        for (int i = 0; i < rental.getJumlahKostum(); i++) {
            System.out.println((i + 1) + ". " + rental.getKostum(i).getNamaKostum());
        }

        System.out.print("Pilihan: ");
        int nomor = input.nextInt();
        input.nextLine();

        if (nomor >= 1 && nomor <= rental.getJumlahKostum()) {

        Kostum kostumDipilih = rental.getKostum(nomor - 1);

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
        
        kostum.tampilkanJenisKostum();
        if (kostum instanceof dapatDisewa){
            ((dapatDisewa) kostum).prosesSewa();
        }
        if (kostum instanceof dapatDinilai){
            ((dapatDinilai)kostum).beriPenilaian();
        }
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

        double total = kostum.hitungSewa(hari,jumlah);

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

        for (int i = 0; i < rental.getJumlahKostum(); i++) {

            Kostum kostum = rental.getKostum(i);

            if (kostum.getKodeKostum().equalsIgnoreCase(kode)) {
                return kostum;
            }
        }

        return null;
    }
    
    static void menuPelanggan() {

    int pilihan;

    do {
        System.out.println();
        System.out.println("========== KELOLA DATA PELANGGAN ==========");
        System.out.println("1. Tambah Data Pelanggan");
        System.out.println("2. Cari Data Pelanggan");
        System.out.println("3. Tampilkan Semua Pelanggan");
        System.out.println("4. Kembali ke Menu Utama");
        System.out.print("Pilih: ");

        pilihan = input.nextInt();
        input.nextLine();

        switch (pilihan) {

            case 1:
                tambahPelanggan();
                break;

            case 2:
                cariPelanggan();
                break;

            case 3:
                tampilkanPelanggan();
                break;

            case 4:
                System.out.println("Kembali ke menu utama.");
                break;

            default:
                System.out.println("Pilihan tidak tersedia.");
        }

    } while (pilihan != 4);
}
    static void tambahPelanggan() {

        System.out.println();
        System.out.println("======= TAMBAH DATA PELANGGAN =======");

        System.out.print("Masukkan ID pelanggan: ");
        String id = input.nextLine();

        if (rental.getPelanggan(id) != null) {
            System.out.println("ID pelanggan sudah terdaftar.");
            return;
        }

        System.out.print("Masukkan nama pelanggan: ");
        String nama = input.nextLine();

        Pelanggan pelanggan = new Pelanggan(id, nama);
        rental.tambahPelanggan(pelanggan);

        System.out.println("Data pelanggan berhasil ditambahkan.");
}
    static void cariPelanggan() {

        System.out.println();
        System.out.println("======= CARI DATA PELANGGAN =======");

        System.out.print("Masukkan ID pelanggan: ");
        String id = input.nextLine();

        Pelanggan pelanggan = rental.getPelanggan(id);

        if (pelanggan != null) {

            System.out.println();
            System.out.println("Pelanggan ditemukan:");
            System.out.println("ID Pelanggan : " + pelanggan.getIdPelanggan());
            System.out.println("Nama         : " + pelanggan.getNama());

        } else {

            System.out.println("Pelanggan dengan ID tersebut tidak ditemukan.");
        }
    }
    
    static void tampilkanPelanggan() {
        rental.lihatSemuaPelanggan();
}
    
    static void prosesTransaksiSewa() {

        System.out.println();
        System.out.println("======= PROSES TRANSAKSI SEWA =======");
        System.out.print("Masukkan ID pelanggan: ");
        String idPelanggan = input.nextLine();

        Pelanggan pelanggan = rental.getPelanggan(idPelanggan);

        if (pelanggan == null) {
            System.out.println("Pelanggan tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan kode kostum: ");
        String kodeKostum = input.nextLine();

        Kostum kostum = cariDenganKode(kodeKostum);

        if (kostum == null) {
            System.out.println("Kostum tidak ditemukan.");
            return;
        }

        transaksi.prosesSewa(pelanggan, kostum);
}
}