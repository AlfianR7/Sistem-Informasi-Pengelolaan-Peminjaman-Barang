package Model;

import java.sql.SQLException;
import java.util.ArrayList;

public class Peminjaman {
    private ArrayList<Barang> pinjaman;
    private Anggota peminjam;

    public Peminjaman(ArrayList<Barang> pinjaman, Anggota peminjam) {
        this.pinjaman = pinjaman;
        this.peminjam = peminjam;
    }
    
    public void addPinjaman(Barang b){
        pinjaman.add(new Barang(b.getIdBarang(), b.getNamaBarang()));
    }

    public void setPeminjam(Anggota a) {
        this.peminjam = a;
    }
    
    
}
