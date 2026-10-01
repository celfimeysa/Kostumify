/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kostumify;

/**
 *
 * @author asus
 */
public class KostumKarakter extends Kostum {
    private String namaKarakter;
    private String ukuranKostum;


    public KostumKarakter(String kodeKostum,
                          String namaKostum,
                          double hargaSewa,
                          int stok,
                          String kondisi,
                          String namaKarakter,
                          String ukuranKostum) {
        super(kodeKostum, namaKostum, hargaSewa, stok, kondisi);
        this.setNamaKarakter(namaKarakter);
        this.setUkuranKostum(ukuranKostum);
    }

    public String getNamaKarakter() {
        return namaKarakter;
    }

    public void setNamaKarakter(String namaKarakter) {
        if (namaKarakter != null && !namaKarakter.trim().isEmpty()) {
            this.namaKarakter = namaKarakter;
        }
    }

    public String getUkuranKostum() {
        return ukuranKostum;
    }

    public void setUkuranKostum(String ukuranKostum) {
        if (ukuranKostum != null && !ukuranKostum.trim().isEmpty()) {
            this.ukuranKostum = ukuranKostum;
        }
    }
    
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Nama Karakter : " + namaKarakter);
        System.out.println("Ukuran        : " + ukuranKostum);
    }
}
