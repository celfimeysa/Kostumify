/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kostumify;

/**
 *
 * @author ASUS
 */
public class TransaksiSewa {
    
     public void prosesSewa(Pelanggan pelanggan, Kostum kostum) {
        System.out.println();
        System.out.println("======= DETAIL TRANSAKSI SEWA =======");
        System.out.println("ID Pelanggan : " + pelanggan.getIdPelanggan());
        System.out.println("Nama         : " + pelanggan.getNama());
        System.out.println("Kostum       : " + kostum.getNamaKostum());
        System.out.println("Transaksi sewa berhasil diproses.");
    }
}
