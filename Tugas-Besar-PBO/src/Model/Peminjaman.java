package Model;

import java.util.ArrayList;

public class Peminjaman {
    private ArrayList<Barang> pinjaman;
    private Anggota[] peminjam;
    
    
    public void addPinjaman(Barang b){
        pinjaman.add(new Barang(b.getNoBarang(), b.getNamaBarang()));
    }

    public void setPeminjam(Anggota[] a) {
        this.peminjam = a;
    }
    
    
}
