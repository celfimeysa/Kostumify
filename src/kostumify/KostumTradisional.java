/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kostumify;

/**
 *
 * @author asus
 */
//MODUL 5 : INHERITANCE
 public class KostumTradisional extends Kostum {
    private String asalDaerah;
    private String jenisKelamin;


    public KostumTradisional(String kodeKostum,
                             String namaKostum,
                             double hargaSewa,
                             int stok,
                             String kondisi,
                             String asalDaerah,
                             String jenisKelamin) {


        super(kodeKostum, namaKostum, hargaSewa, stok, kondisi);
        this.setAsalDaerah(asalDaerah);
        this.setJenisKelamin(jenisKelamin);
    }

    public String getAsalDaerah() {
        return asalDaerah;
    }

    public void setAsalDaerah(String asalDaerah) {
        if (asalDaerah != null && !asalDaerah.trim().isEmpty()) {
            this.asalDaerah = asalDaerah;
        }
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        if (jenisKelamin != null && !jenisKelamin.trim().isEmpty()) {
            this.jenisKelamin = jenisKelamin;
        }
    }

    // MODUL 5 - METHOD OVERRIDING

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Asal Daerah  : " + asalDaerah);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
    }
   }
