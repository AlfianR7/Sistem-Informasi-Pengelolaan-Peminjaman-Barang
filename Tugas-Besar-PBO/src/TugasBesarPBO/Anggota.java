package TugasBesarPBO;
public class Anggota extends Orang {
    private String noAnggota;
    private String Jabatan;

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
    
    

    
    
}
