package Model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Anggota extends Orang implements Serializable {

    private static int ID = 1;
    private final String idAnggota;

    public Anggota(String nama, String jenisKelamin) {
        super(nama, jenisKelamin);
        idAnggota = "AGT" + (ID++);
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public String toString() {
        String s = "ID Anggota = " + idAnggota + ", " + "Nama = " + nama + ", " + "Jenis Kelamin = " + jenisKelamin;
        return s;
    }

}
