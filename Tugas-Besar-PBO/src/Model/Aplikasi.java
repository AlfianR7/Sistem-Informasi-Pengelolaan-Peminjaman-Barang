package Model;

import java.util.ArrayList;

public class Aplikasi {
    ArrayList<Petugas> daftarPetugas;
    ArrayList<Anggota> daftarAnggota;
    ArrayList<Peminjaman> daftarPeminjaman;
    ArrayList<Barang> daftarBarang;

    public Aplikasi(){
        daftarPetugas = new ArrayList();
        daftarAnggota = new ArrayList();
        daftarPeminjaman = new ArrayList();
        daftarBarang = new ArrayList();
    }
    
}
