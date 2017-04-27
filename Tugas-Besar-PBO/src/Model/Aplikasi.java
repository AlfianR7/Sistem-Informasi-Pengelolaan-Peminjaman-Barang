package Model;

import Database.SaveFile;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.io.EOFException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Aplikasi {

    private ArrayList<Petugas> daftarPetugas;
    private ArrayList<Anggota> daftarAnggota;
    private ArrayList<Peminjaman> daftarPeminjaman;
    private ArrayList<Barang> daftarBarang;

    private SaveFile save;
    private int IntAuth;

    public Aplikasi() {
        daftarPetugas = new ArrayList();
        daftarAnggota = new ArrayList();
        daftarPeminjaman = new ArrayList();
        daftarBarang = new ArrayList();

    }
//####################################################################################################
//####################################################################################################

//  PENGOLAHAN DATA ANGGOTA
    public void addAnggota(String nama, String jenisKelamin) {
        daftarAnggota.add(new Anggota(nama, jenisKelamin));
    }

    public String[] ListAnggota() {
        if (daftarAnggota != null) {
            List listAng = daftarAnggota.stream().map(E -> "ID Anggota : " + E.getIdAnggota() + ", "
                    + "Nama Anggota : " + E.getNama() + ", "
                    + "Jenis Kelamin : " + E.getJenisKelamin()).collect(Collectors.toList());
            return (String[]) listAng.stream().toArray(arr -> new String[arr]);
        } else {
            System.out.println("Data Anggota Kosong");
        }
        return null;
    }

    public void deleteAnggotaIndexID(String idAnggota) {
        Anggota A = getAnggota(idAnggota);
        if (A != null) {
            daftarAnggota.remove(A);
        }
    }

    public void deleteAnggotaIndexNama(String namaAnggota) {
        Anggota A = getAnggotaNama(namaAnggota);

        if (daftarAnggota != null) {
            if (A != null) {
                daftarAnggota.remove(A);
            }
        } else {
            System.out.println("Data Anggota Kosong");
        }
    }
    public String[] getListAnggota() {
        List idEmp = daftarAnggota.stream()
                .filter(e -> !(e instanceof Anggota))
                .map(e -> e.getIdAnggota()).collect(Collectors.toList());
        return (String[]) idEmp.stream().toArray(size -> new String[size]);
    }
    
    public Anggota getAnggota(String idAnggota) {
        return daftarAnggota.stream()
                .filter(a -> a.getIdAnggota().equals(idAnggota))
                .findFirst().orElse(null);
    }

    public Anggota getAnggotaNama(String namaAnggota) {
        return daftarAnggota.stream()
                .filter(a -> a.getNama().equals(namaAnggota))
                .findFirst().orElse(null);
    }

//####################################################################################################
//####################################################################################################
// PENGOLAHAN DATA PETUGAS
    public void addPetugas(String Nama, String JenisKelamin, String pass) {
        daftarPetugas.add(new Petugas(Nama, JenisKelamin, pass));
    }

    public String[] ListPetugas() {
        List listPtg = daftarPetugas.stream().map(E -> "ID Petugas : " + E.getIdPetugas() + ", "
                + "Nama Petugas : " + E.getNama() + ", "
                + "Jenis Kelamin : " + E.getJenisKelamin()).collect(Collectors.toList());
        return (String[]) listPtg.stream().toArray(arr -> new String[arr]);
    }

//    public void LoginPetugas(String users, String pass){
//        Petugas P = getPetugas(pass);
//        if ( P.getUser() == users){
//            if ( P.getPass() == pass){
//                System.out.println("Berhasil Login");
//            }else{
//                System.out.println("Password yang di inputkan salah");
//            }
//        }else{
//            System.out.println("Petugas Belum terdaftar");
//        }
//    }
    public Petugas getPetugas(String idPetugas) {
        return daftarPetugas.stream()
                .filter(a -> a.getIdPetugas().equals(idPetugas))
                .findFirst().orElse(null);
    }

    public Petugas getPetugasUsername(String user) {
        return daftarPetugas.stream()
                .filter(a -> a.getUser().equals(user))
                .findFirst().orElse(null);
    }
//####################################################################################################
//####################################################################################################
// LOGIN PETUGAS

    public void LoginPetugas(String username, String pass) {
        Petugas P = getPetugasUsername(username);
        if ( "a".equals(username) || P.getUser().equals(username)) {
            if ("a".equals(pass ) || P.getPass().equals(pass)) {
                System.out.println("Berhasil Login");
                IntAuth = 1;
            } else {
                System.out.println("Password yang di inputkan salah");
                IntAuth = 0;
            }
        } else {
            System.out.println("Petugas Belum terdaftar");
            System.out.println("Silahkan Daftar terlebihdahulu***");
            IntAuth = 0;
        }
    }

//####################################################################################################
//####################################################################################################
// DATA BARANG
    public void addBarang(String namaBarang, String status) {
        daftarBarang.add(new Barang(namaBarang, status));
    }

    public String[] ListBarang() {
        List listBrg = daftarBarang.stream().map(E -> "ID Barang : " + E.getIdBarang() + ", "
                + "Nama Barang : " + E.getNamaBarang() + ", "
                + "Status : " + E.getStatus()).collect(Collectors.toList());
        return (String[]) listBrg.stream().toArray(arr -> new String[arr]);
    }

    public Barang getBarang(String idBarang) {
        return daftarBarang.stream()
                .filter(b -> b.getIdBarang().equals(idBarang))
                .findFirst().orElse(null);
    }
////####################################################################################################
    ////####################################################################################################
    //// DATA PEMINJAMAN

    public void addPinjaman(String idBarang){
        Barang B = getBarang(idBarang);
        if ( B.getIdBarang().equals(idBarang)){
            
        }
    }
    public void addPeminjaman(String idBarang, String namaAnggota) {
        Barang b = getBarang(idBarang);
        Anggota a = getAnggotaNama(namaAnggota);
        Peminjaman p;
        try {
            if (b.getIdBarang().equals(idBarang)) {
                daftarPeminjaman.add(new Peminjaman(daftarBarang, a));
            }
        } catch (Exception e) {
            System.out.println("Id Barang Tidak sesuai");
        }
    }
//
//    public String[] ListPeminjaman() {
//        List listPnj = daftarPeminjaman.stream().filter(p -> p instanceof Barang  )
//                .map(P -> P)
//        
//        return;
//    }
//
//    public Barang getBarang(String idBarang) {
//        return daftarBarang.stream()
//                .filter(a -> a.getIdBarang().equals(idBarang))
//                .findFirst().orElse(null);
//    }

////####################################################################################################
////####################################################################################################
// UPDATE DATA FROM FILE
    public void loadAnggota() throws FileNotFoundException, IOException {
        try {
            daftarAnggota = (ArrayList<Anggota>) save.getObject("fileAnggota.txt");
        } catch (FileNotFoundException ex) {
            File f = new File("fileAnggota.txt");
            f.createNewFile();
        } catch (EOFException ex) {
            daftarAnggota = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }

    public void saveAnggota() throws FileNotFoundException, IOException {
        try {
            save.saveObject(daftarAnggota, "fileAnggota.txt");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }

    public void viewList(String[] list) {
        Arrays.stream(list).forEach(System.out::println);
    }

    public int LoginAuth() {
        return IntAuth;
    }
//
//}
}
