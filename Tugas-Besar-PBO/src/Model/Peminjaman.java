package Model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

// Created by:
// Nama     :Ahmad Fathoni Z
// NIM      : 1301154217

public class Peminjaman implements Serializable {
    
    private static int ID = 1;
    private final String idPinjaman;
    private ArrayList<Barang> pinjaman;
    private Anggota peminjam;
    

    public Peminjaman(ArrayList<Barang> pinjaman, Anggota peminjam) {
        this.pinjaman = pinjaman;
        this.peminjam = peminjam;
        idPinjaman = "PNJ" + (ID++);
    }
    
    
    public String getIdPinjaman(){
        return idPinjaman;
    }
    public void addPinjaman(Barang b){
        pinjaman.add(new Barang(b.getIdBarang(), b.getNamaBarang()));
    }

    public void setPeminjam(Anggota a) {
        this.peminjam = a;
    }
 
    public  void ViewListPeminjaman(){
        System.out.println("Nama Peminjam");
        System.out.println(this.peminjam.nama);
        System.out.println("Barang yang dipinjam");
        for (Barang x : pinjaman){
            System.out.println(" ID Pinjaman : "+ idPinjaman +" ID Barang : " + x.getIdBarang() + " Nama Barang : "+  x.getNamaBarang());
        }
        System.out.println("----------------------------------------------");
    }
    
    public String toString(){
        String z=null;
        for (Barang x : pinjaman){
            z = "Peminjam : "+ pinjaman+ " ID Pinjaman : "+ idPinjaman +" ID Barang : " + x.getIdBarang() + " Nama Barang : "+  x.getNamaBarang();
        }return z;
    }
}
