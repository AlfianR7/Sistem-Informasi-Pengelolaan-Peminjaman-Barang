package Model;
public class Anggota extends Orang {
    private String noAnggota;
    private String Jabatan;
    private String tahunMasuk;

    public Anggota(String noAnggota, String Jabatan, String nama, char jenisKelamin) {
        super(nama, jenisKelamin);
        this.noAnggota = noAnggota;
        this.Jabatan = Jabatan;
    }
 
    public String getNoAnggota() {
        return noAnggota;
    }

    public void setNoAnggota(String noAnggota) {
        this.noAnggota = noAnggota;
    }

    public String getJabatan() {
        return Jabatan;
    }

    public void setJabatan(String Jabatan) {
        this.Jabatan = Jabatan;
    }

    public String getTahunMasuk() {
        return tahunMasuk;
    }

    public void setTahunMasuk(String tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }
    
    
    

    
    
}
