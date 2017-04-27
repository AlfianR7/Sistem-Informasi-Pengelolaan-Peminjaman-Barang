package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Petugas extends Orang {

    private int ID = 1;
    private String idPetugas;
    private String user;
    private String pass;

    public Petugas(String nama, String jenisKelamin, String pass) {
        super(nama, jenisKelamin);
        this.user = nama;
        this.pass = pass;
        idPetugas = "PTG" + ID;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getIdPetugas() {
        return idPetugas;
    }

    public void setIdPetugas(String idPetugas) {
        this.idPetugas = idPetugas;
    }

    public String toString() {
        String x = "ID Petugas = " + idPetugas + ", " + "Nama = " + nama + ", " + "Jenis Kelamin = " + jenisKelamin;
        return x;
    }

}
