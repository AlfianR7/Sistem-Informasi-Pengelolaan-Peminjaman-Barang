package Model;
public class Barang {
    private String noBarang;
    private String namaBarang;
    private String Status;

    public Barang(String noBarang, String namaBarang) {
        this.noBarang = noBarang;
        this.namaBarang = namaBarang;
    }

    public String getNoBarang() {
        return noBarang;
    }

    public void setNoBarang(String noBarang) {
        this.noBarang = noBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
}
