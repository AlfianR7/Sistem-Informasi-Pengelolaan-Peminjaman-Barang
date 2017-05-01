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

/**
 *
 * @author Alfian R7
 */
// Created by:
// Nama     :Alfian Rahman Aziz
// NIM      : 1301150063
public class Aplikasi {

    private ArrayList<Petugas> daftarPetugas;
    private ArrayList<Anggota> daftarAnggota;
    private ArrayList<Peminjaman> daftarPeminjaman;
    private ArrayList<Barang> daftarBarang;
    private ArrayList<Barang> daftarBarangPinjaman;

    private SaveFile save;
    private int IntAuth;

    public Aplikasi() {
        daftarPetugas = new ArrayList();
        daftarAnggota = new ArrayList();
        daftarPeminjaman = new ArrayList();
        daftarBarang = new ArrayList();
        daftarBarangPinjaman = new ArrayList<>();
        save = new SaveFile();

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
        List listAng = daftarAnggota.stream()
                .filter(a -> !(a instanceof Anggota))
                .map(a -> a.toString()).collect(Collectors.toList());
        return (String[]) listAng.stream().toArray(size -> new String[size]);
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
        List listPtg = daftarPetugas.stream().map(P -> "ID Petugas : " + P.getIdPetugas() + ", "
                + "Nama Petugas : " + P.getNama() + ", "
                + "Jenis Kelamin : " + P.getJenisKelamin()).collect(Collectors.toList());
        return (String[]) listPtg.stream().toArray(arr -> new String[arr]);
    }

    public Petugas getPetugas(String idPetugas) {
        return daftarPetugas.stream()
                .filter(p -> p.getIdPetugas().equals(idPetugas))
                .findFirst().orElse(null);
    }

    public Petugas getPetugasUsername(String user) {
        return daftarPetugas.stream()
                .filter(p -> p.getUser().equals(user))
                .findFirst().orElse(null);
    }

    public String[] getListPetugas() {
        List idPtg = daftarPetugas.stream()
                .filter(p -> !(p instanceof Petugas))
                .map(p -> p.toString()).collect(Collectors.toList());
        return (String[]) idPtg.stream().toArray(size -> new String[size]);
    }

//####################################################################################################
//####################################################################################################
// LOGIN PETUGAS
    public void LoginPetugas(String username, String pass) {
        Petugas P = getPetugasUsername(username);
        if ("admin".equals(username) || P.getUser().equals(username)) {
            if ("admin".equals(pass) || P.getPass().equals(pass)) {
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
    public void addBarang(String namaBarang) {
        daftarBarang.add(new Barang(namaBarang));
    }

    public void addBarangPinjaman(String idBarang, String namaBarang) {
        daftarBarangPinjaman.removeAll(daftarBarangPinjaman);
        daftarBarangPinjaman.add(new Barang(idBarang, namaBarang));
    }

    public String[] ListBarang() throws IOException {
        List listBrg = daftarBarang.stream().map(B -> "ID Barang : " + B.getIdBarang() + ", "
                + "Nama Barang : " + B.getNamaBarang() + ", "
                + "Status : " + B.getStatus()).collect(Collectors.toList());
        return (String[]) listBrg.stream().toArray(arr -> new String[arr]);
    }

    public String[] getListBarang() {
        List listBrg = daftarBarang.stream()
                .filter(b -> !(b instanceof Barang))
                .map(b -> b.toString()).collect(Collectors.toList());
        return (String[]) listBrg.stream().toArray(size -> new String[size]);
    }

    public Barang getBarang(String idBarang) {
        return daftarBarang.stream()
                .filter(b -> b.getIdBarang().equals(idBarang))
                .findFirst().orElse(null);
    }

    public Barang getBarangNama(String namaBarang) {
        return daftarBarang.stream()
                .filter(b -> b.getNamaBarang().equals(namaBarang))
                .findFirst().orElse(null);
    }
////####################################################################################################
////####################################################################################################

//// DATA PEMINJAMAN
    public void addPeminjaman(String idBarang, String namaAnggota) {
        Barang b = getBarang(idBarang);
        Anggota a = getAnggotaNama(namaAnggota);
        try {
            if (b.getIdBarang().equals(idBarang)) {
                daftarPeminjaman.add(new Peminjaman(daftarBarangPinjaman, a));
            }
        } catch (Exception e) {
            System.out.println("Data Barang Tidak sesuai");
        }
    }

    public Peminjaman getpeminjaman(String idPeminjam) {
        return daftarPeminjaman.stream()
                .filter(p -> p.getIdPinjaman().equals(idPeminjam))
                .findFirst().orElse(null);
    }

    public void ListPeminjaman() {
        for (Peminjaman x : daftarPeminjaman) {
            x.ViewListPeminjaman();
        }
    }

    public String[] getListpeminjaman() {
        List idPnj = daftarPeminjaman.stream()
                .filter(e -> !(e instanceof Peminjaman))
                .map(e -> e.toString()).collect(Collectors.toList());
        return (String[]) idPnj.stream().toArray(size -> new String[size]);
    }

////####################################################################################################
////####################################################################################################
    public void viewList(String[] list) {
        Arrays.stream(list).forEach(System.out::println);
    }

    public int LoginAuth() {
        return IntAuth;
    }
////####################################################################################################
////####################################################################################################
// UPDATE DATA FROM FILE

// FILE ANGGOTA
    public void loadAnggota() throws FileNotFoundException, IOException {
        try {
            daftarAnggota = (ArrayList<Anggota>) save.getObject("fileAnggota.txt");
//            System.out.println("debugAnggota0");
        } catch (FileNotFoundException ex) {
            File f = new File("fileAnggota.txt");
            f.createNewFile();
//            System.out.println("debugAnggota1");
        } catch (EOFException ex) {
            daftarAnggota = new ArrayList<>();
//            System.out.println("debugAnggota2");
        } catch (IOException | ClassNotFoundException ex) {
//            System.out.println("debugAnggota3");
            throw new IOException("error " + ex.getMessage());
        }
//        System.out.println("debugAnggota4");

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

// FILE BARANG
    public void loadBarang() throws FileNotFoundException, IOException {
        try {
            daftarBarang = (ArrayList<Barang>) save.getObject("fileBarang.txt");
//            System.out.println("debugBarang0");
        } catch (FileNotFoundException ex) {
            File f = new File("fileBarang.txt");
            f.createNewFile();
//            System.out.println("debugBarang1");
        } catch (EOFException ex) {
            daftarBarang = new ArrayList<>();
//            System.out.println("debugBarang2");
        } catch (IOException | ClassNotFoundException ex) {
//            System.out.println("debugBarang3");
            throw new IOException("error " + ex.getMessage());
        }
//        System.out.println("debugBarang4");

        }

    

    public void saveBarang() throws FileNotFoundException, IOException {
        try {
            save.saveObject(daftarBarang, "fileBarang.txt");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }

// FILE PEMINJAMAN
    public void loadPeminjaman() throws FileNotFoundException, IOException {
        try {
            daftarPeminjaman = (ArrayList<Peminjaman>) save.getObject("filePeminjaman.txt");
//            System.out.println("debugpinjam0");

        } catch (FileNotFoundException ex) {
            File f = new File("filePeminjaman.txt");
            f.createNewFile();
//            System.out.println("debugpinjam1");

        } catch (EOFException ex) {
            daftarPeminjaman = new ArrayList<>();
//            System.out.println("debugpinjam2");

        } catch (IOException | ClassNotFoundException ex) {
//            System.out.println("debugpinjam3");

            throw new IOException("error " + ex.getMessage());
        }
//        System.out.println("debugpinjam4");

    }

    public void savePeminjaman() throws FileNotFoundException, IOException {
        try {
            save.saveObject(daftarPeminjaman, "filePeminjaman.txt");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }

//FILE PETUGAS
    public void loadPetugas() throws FileNotFoundException, IOException {
        try {
            daftarPetugas = (ArrayList<Petugas>) save.getObject("filePetugas.txt");
//            System.out.println("debugpetugas0");

        } catch (FileNotFoundException ex) {
            File f = new File("filePetugas.txt");
            f.createNewFile();
//            System.out.println("debugpetugas1");

        } catch (EOFException ex) {
            daftarPetugas = new ArrayList<>();
//            System.out.println("debugpetugas2");

        } catch (IOException | ClassNotFoundException ex) {
//            System.out.println("debugpetugas3");

            throw new IOException("error " + ex.getMessage());
        }
//        System.out.println("debugpetugas4");

    }

    public void savePetugas() throws FileNotFoundException, IOException {
        try {
            save.saveObject(daftarPetugas, "filePetugas.txt");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }
}
