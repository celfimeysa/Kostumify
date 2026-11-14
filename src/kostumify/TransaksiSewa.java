/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kostumify;

/**
 *
 * @author ASUS
 */
import java.io.FileWriter;
import java.io.IOException;

public class TransaksiSewa {
    
     public void prosesSewa(Pelanggan pelanggan, Kostum kostum) {
        System.out.println();
        System.out.println("======= DETAIL TRANSAKSI SEWA =======");
        System.out.println("ID Pelanggan : " + pelanggan.getIdPelanggan());
        System.out.println("Nama         : " + pelanggan.getNama());
        System.out.println("Kostum       : " + kostum.getNamaKostum());
        System.out.println("Transaksi sewa berhasil diproses.");
        
        try {
            FileWriter penulis = new FileWriter("log_transaksi.txt", true);

            penulis.write("ID Pelanggan : " + pelanggan.getIdPelanggan() + "\n");
            penulis.write("Nama         : " + pelanggan.getNama() + "\n");
            penulis.write("Kostum       : " + kostum.getNamaKostum() + "\n");
            penulis.write("Status       : Berhasil\n");
            penulis.write("------------------------------\n");

            penulis.close();

            System.out.println("Log transaksi berhasil disimpan.");
    }   catch (IOException e) {
            System.out.println("Gagal menyimpan log: " + e.getMessage());
}
    }
}
