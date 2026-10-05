/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kostumify;

/**
 *
 * @author asus
 */
public class KostumAnime extends Kostum {

    private String namaAnime;
    private String namaTokoh;

    public KostumAnime(String kodeKostum,
                       String namaKostum,
                       double hargaSewa,
                       int stok,
                       String kondisi,
                       String namaAnime,
                       String namaTokoh) {

        super(kodeKostum, namaKostum, hargaSewa, stok, kondisi);

        this.setNamaAnime(namaAnime);
        this.setNamaTokoh(namaTokoh);
    }

    public String getNamaAnime() {
        return namaAnime;
    }

    public void setNamaAnime(String namaAnime) {
        if (namaAnime != null && !namaAnime.trim().isEmpty()) {
            this.namaAnime = namaAnime;
        }
    }

    public String getNamaTokoh() {
        return namaTokoh;
    }

    public void setNamaTokoh(String namaTokoh) {
        if (namaTokoh != null && !namaTokoh.trim().isEmpty()) {
            this.namaTokoh = namaTokoh;
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();

        System.out.println("Nama Anime    : " + namaAnime);
        System.out.println("Nama Tokoh    : " + namaTokoh);
    }
}
