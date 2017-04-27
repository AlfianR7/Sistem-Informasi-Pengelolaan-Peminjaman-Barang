package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Barang {

    private int ID = 1;
    private String idBarang;
    private String namaBarang;
    private String Status;

    public Barang(String namaBarang, String Status) {
        this.namaBarang = namaBarang;
        this.Status = Status;
        idBarang ="BRG "+ID;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIoBarang(String idBarang) {
        this.idBarang = idBarang;
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

    public String toString() {
        String s = "ID Barang = " + idBarang + ", " + "Nama Barang = " + namaBarang + ", " + "Status Barang = " + Status;
        return s;
    }
    
}
