/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kostumify;

public class RuangPenyimpanan {

    private String namaRuangan;
    private int kapasitasKostum;

    public RuangPenyimpanan(String namaRuangan, int kapasitasKostum) {
        this.namaRuangan = namaRuangan;
        this.kapasitasKostum = kapasitasKostum;
    }

    public void tampilkanInfoRuangan() {
        System.out.println();
        System.out.println("======= INFORMASI RUANG PENYIMPANAN =======");
        System.out.println("Nama Ruangan     : " + namaRuangan);
        System.out.println("Kapasitas Kostum : " + kapasitasKostum + " kostum");
    }
}
