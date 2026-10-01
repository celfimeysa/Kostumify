/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kostumify;

/**
 *
 * @author asus
 */
public class Kostum {
      //MODUL 4 - ENCAPSULATION
    private String kodeKostum;
    private String namaKostum;
    private double hargaSewa;
    private int stok;
    private String kondisi;

    private static int jumlahKostum = 0;

    // MODUL 3 - CONSTRUCTOR
    public Kostum(String kodeKostum, String namaKostum,
                  double hargaSewa, int stok, String kondisi) {

        // MODUL 4 - penggunaan this
        this.setKodeKostum(kodeKostum);
        this.setNamaKostum(namaKostum);
        this.setHargaSewa(hargaSewa);
        this.setStok(stok);
        this.setKondisi(kondisi);

        jumlahKostum++;
    }

    // MODUL 4 - GETTER DAN SETTER

    public String getKodeKostum() {
        return kodeKostum;
    }

    public void setKodeKostum(String kodeKostum) {
        if (kodeKostum != null && !kodeKostum.trim().isEmpty()) {
            this.kodeKostum = kodeKostum;
        }
    }

    public String getNamaKostum() {
        return namaKostum;
    }

    public void setNamaKostum(String namaKostum) {
        if (namaKostum != null && !namaKostum.trim().isEmpty()) {
            this.namaKostum = namaKostum;
        }
    }

    public double getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(double hargaSewa) {
        if (hargaSewa > 0) {
            this.hargaSewa = hargaSewa;
        } else {
            this.hargaSewa = 1;
        }
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        } else {
            this.stok = 0;
        }
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        if (kondisi != null && !kondisi.trim().isEmpty()) {
            this.kondisi = kondisi;
        }
    }


    public static int getJumlahKostum() {
        return jumlahKostum;
    }

    // MODUL 3 - METHOD
    public void tampilkanInfo() {

        System.out.println("Kode       : " + kodeKostum);
        System.out.println("Nama       : " + namaKostum);
        System.out.println("Harga Sewa : Rp"
                + String.format("%.0f", hargaSewa) + "/hari");
        System.out.println("Stok       : " + stok);
        System.out.println("Kondisi    : " + kondisi);
    }

    public double hitungSewa(int hari) {
        return hargaSewa * hari;
    }

    public double hitungSewa(int hari, int jumlah) {
        return hargaSewa * hari * jumlah;
    }
}
    

