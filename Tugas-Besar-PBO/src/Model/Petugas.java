package Model;
public class Petugas extends Orang{
    private String noPetugas;
    private String tahunMasuk;

    public Petugas(String noPetugas, String tahunMasuk, String nama, char jenisKelamin) {
        super(nama, jenisKelamin);
        this.noPetugas = noPetugas;
        this.tahunMasuk = tahunMasuk;
    }

    public String getNoPetugas() {
        return noPetugas;
    }

    public void setNoPetugas(String noPetugas) {
        this.noPetugas = noPetugas;
    }

    public String getTahunMasuk() {
        return tahunMasuk;
    }

    public void setTahunMasuk(String tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }
    
    
}
