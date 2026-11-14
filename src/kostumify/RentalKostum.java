/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kostumify;

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RentalKostum {

    private String namaRental;
    private ArrayList<Kostum> daftarKostum;
    private HashMap<String, Pelanggan> dataPelanggan;
    private RuangPenyimpanan ruangPenyimpanan;

    public RentalKostum(String namaRental) {
        this.namaRental = namaRental;
        this.ruangPenyimpanan = new RuangPenyimpanan("Ruang Penyimpanan Kostum", 100);
        this.daftarKostum = new ArrayList<>();
        this.dataPelanggan = new HashMap<>();
    }

    public void bukaRental() {
        System.out.println();
        System.out.println("======================================");
        System.out.println("Selamat datang di " + namaRental);
        System.out.println("======================================");

        ruangPenyimpanan.tampilkanInfoRuangan();
    }

    public void tambahKostum(Kostum kostum) {
        daftarKostum.add(kostum);
        System.out.println("Kostum berhasil ditambahkan.");
    }

    public void tambahPelanggan(Pelanggan pelanggan) {
        dataPelanggan.put(
                pelanggan.getIdPelanggan(),
                pelanggan
        );

        System.out.println("Pelanggan berhasil ditambahkan.");
    }

    public void lihatSemuaKostum() {
        System.out.println();
        System.out.println("======= DAFTAR SELURUH KOSTUM =======");

        if (daftarKostum.isEmpty()) {
            System.out.println("Belum ada data kostum.");
        } else {
            for (int i = 0; i < daftarKostum.size(); i++) {
                System.out.println();
                System.out.println("Data ke-" + (i + 1));
                daftarKostum.get(i).tampilkanInfo();
            }
        }
    }

    public void lihatSemuaPelanggan() {
        System.out.println();
        System.out.println("======= DAFTAR SELURUH PELANGGAN =======");

        if (dataPelanggan.isEmpty()) {
            System.out.println("Belum ada data pelanggan.");
        } else {
            for (String id : dataPelanggan.keySet()) {
                Pelanggan pelanggan = dataPelanggan.get(id);

                System.out.println("------------------------------");
                System.out.println("ID Pelanggan : " + pelanggan.getIdPelanggan());
                System.out.println("Nama         : " + pelanggan.getNama());
            }
        }
    }

    public Pelanggan getPelanggan(String idPelanggan) {
        return dataPelanggan.get(idPelanggan);
    }

    public Kostum getKostum(int index) {
        return daftarKostum.get(index);
    }

    public int getJumlahKostum() {
        return daftarKostum.size();
    }
    
    public Kostum cariKostum(String nama) {
        for (Kostum kostum : daftarKostum) {
            if (kostum.getNamaKostum().equalsIgnoreCase(nama)) {
                return kostum;
        }
    }

    return null;
}

    public Kostum cariKostum(int nomorData) {
        if (nomorData >= 1 && nomorData <= daftarKostum.size()) {
            return daftarKostum.get(nomorData - 1);
    }

        return null;
}
    
    public void simpanData() {
        try {
            FileOutputStream file = new FileOutputStream("data_kostumify.dat");
            ObjectOutputStream output = new ObjectOutputStream(file);

            output.writeObject(daftarKostum);
            output.writeObject(dataPelanggan);

            output.close();
            file.close();

            System.out.println("Data berhasil disimpan.");
        }catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public void muatData() {
        try {
            FileInputStream file = new FileInputStream("data_kostumify.dat");
            ObjectInputStream input = new ObjectInputStream(file);

            daftarKostum = (ArrayList<Kostum>) input.readObject();
            dataPelanggan = (HashMap<String, Pelanggan>) input.readObject();

            input.close();
            file.close();

            System.out.println("Data berhasil dimuat.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
    }
    
        public void lihatLogTransaksi() {
        File fileLog = new File("log_transaksi.txt");

        try {
            Scanner pembaca = new Scanner(fileLog);

            System.out.println();
            System.out.println("======= RIWAYAT TRANSAKSI =======");

            while (pembaca.hasNextLine()) {
                System.out.println(pembaca.nextLine());
            }

            pembaca.close();
        } catch (FileNotFoundException e) {
            System.out.println("File log transaksi belum tersedia.");
        }
    }
}