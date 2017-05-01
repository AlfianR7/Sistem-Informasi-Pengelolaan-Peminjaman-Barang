package ViewConsole;

import java.util.Scanner;
import Model.Aplikasi;
import Model.Anggota;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.io.IOException;

/**
 *
 * @author Alfian R7
 */
// Created by:
// Nama     :Alfian Rahman Aziz
// NIM      : 1301150063

public class ViewConsole {

    private Aplikasi model;
    private Scanner scanInt;
    private Scanner scanStr;

    public ViewConsole(Aplikasi model) {
        this.model = model;
        scanInt = new Scanner(System.in);
        scanStr = new Scanner(System.in);
    }

    public int InputInt() {
        try {
            return scanInt.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Inputan Salah \n" + "Inputan harus berupa angka");
        } finally {
            scanInt = new Scanner(System.in);
        }
    }

    public void Menu() {
        int n = 0;
        do {
            try {
                System.out.println("Menu");
                System.out.println("1.Login Petugas");
                System.out.println("2.Daftar Anggota Baru");
                System.out.println("3.Daftar Petugas Baru");
                System.out.println("4.Load Data");
                System.out.println("0. Exit");
                System.out.println("Pilih Inputan");
                n = InputInt();
                switch (n) {
                    case 1:
                        System.out.println("Masukan User dan Password");
                        String user = scanStr.nextLine();
                        String pass = scanStr.nextLine();
                        model.LoginPetugas(user, pass);

                        if (model.LoginAuth() == 1) {
                            int m = 0;
                            do {
                                try {
                                    System.out.println("Tab Petugas");
                                    System.out.println("1.Delete Anggota");
                                    System.out.println("2.View Anggota");
                                    System.out.println("3.View Petugas");
                                    System.out.println("4.View peminjaman");
                                    System.out.println("5.View Barang");
                                    System.out.println("6.Input Barang");
                                    System.out.println("7.Pinjaman");
                                    System.out.println("0.Kembali");

                                    System.out.println("Pilih inputan");
                                    m = InputInt();
                                    switch (m) {
                                        case 1:
                                            System.out.println("Delete anggota berdasarkan index : ");
                                            System.out.println("1.Index ID anggota");
                                            System.out.println("2.Nama Anggota");
                                            System.out.println("3.Kembali");
                                            int intdel = InputInt();
                                            try {
                                                if (intdel == 1) {
                                                    System.out.println("Masukan ID anggota");
                                                    String inputan = scanStr.nextLine();
                                                    model.deleteAnggotaIndexID(inputan);
                                                    break;
                                                } else if (intdel == 2) {
                                                    System.out.println("Masukan Nama Anggota");
                                                    String inputan = scanStr.nextLine();
                                                    model.deleteAnggotaIndexNama(inputan);
                                                    break;
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Error");
                                                break;
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Daftar Anggota ");
                                            model.viewList(model.ListAnggota());
                                            System.out.println("-------------------------------------");
                                            break;
                                        case 3:
                                            System.out.println("Daftar Petugas");
                                            model.viewList(model.ListPetugas());
                                            System.out.println("-------------------------------------");
                                            break;
                                        case 4:
                                            System.out.println("Daftar Peminjaman");
                                            model.ListPeminjaman();
                                            System.out.println("-------------------------------------");
                                            break;
                                        case 5:
                                            System.out.println("Daftar Barang");
                                            model.viewList(model.ListBarang());
                                            System.out.println("-------------------------------------");
                                            break;
                                        case 6:
                                            System.out.println("Input Barang");
                                            System.out.println("-------------------------------------");
                                            System.out.println("Nama Barang");
                                            String namaBarang = scanStr.nextLine();
                                            model.addBarang(namaBarang);
                                            model.saveBarang();
                                            System.out.println("-------------------------------------");
                                            break;
                                        case 7:
                                            System.out.println("Pinjaman ");
                                            System.out.println("Masukan ID Barang");
                                            String idBarang = scanStr.nextLine();
                                            System.out.println("Masukan Nama Barang");
                                            String namaBarangP = scanStr.nextLine();
                                            System.out.println("Masukan Nama Anggota");
                                            String namaAnggota = scanStr.nextLine();
                                            model.addBarangPinjaman(idBarang, namaBarangP);
                                            model.addPeminjaman(idBarang, namaAnggota);
                                            model.savePeminjaman();
                                            break;
                                    }
                                } catch (Exception e) {
                                    System.out.println("Terjadi Kesalahan , silahkan coba lagi");
                                } finally {
                                    scanInt = new Scanner(System.in);
                                    scanStr = new Scanner(System.in);
                                }
                            } while (m != 0);
                        } else {
                            break;
                        }
                        break;
                    case 2:
                        System.out.println("Registrasi Anggota");
                        String nama;
                        System.out.println("Masukan Nama");
                        nama = scanStr.nextLine();
                        System.out.println("Pilih Jenis Kelamin");
                        int x = 0;
                        String jenisKelamin = "X";
                        System.out.println("1.Laki-Laki");
                        System.out.println("2.Perempuan");
                        System.out.println("0.Exit");
                        System.out.println("Pilih Inputan");
                        x = InputInt();
                        if (x != 0) {
                            if (x == 1) {
                                jenisKelamin = "Laki-Laki";
                            } else if (x == 2) {
                                jenisKelamin = "Perempuan";
                            }
                        }
                        model.addAnggota(nama, jenisKelamin);
                        model.saveAnggota();
                        break;
                    case 3:
                        String Nama;
                        System.out.println("Masukan Nama");
                        Nama = scanStr.nextLine();
                        System.out.println("Masukan Password");
                        String password;
                        password = scanStr.nextLine();
                        System.out.println("Pilih Jenis Kelamin");
                        int xp = 0;
                        String JenisKelamin = "X";
                        System.out.println("1.Laki-Laki");
                        System.out.println("2.Perempuan");
                        System.out.println("0.Exit");
                        System.out.println("Pilih Inputan");
                        x = InputInt();
                        if (x != 0) {
                            if (x == 1) {
                                JenisKelamin = "Laki-Laki";
                            } else if (x == 2) {
                                JenisKelamin = "Perempuan";
                            }
                        }
                        model.addPetugas(Nama, JenisKelamin, password);
                        model.savePetugas();
                        break;
                    case 4:
                        System.out.println("Load Data");

                        model.loadBarang();
                        model.loadPetugas();
                        model.loadPeminjaman();
                        model.loadAnggota();

                        break;
                    case 0:
                        System.out.println("Terima Kasih");
                        break;
                    default:
                        throw new IllegalStateException("Inputan Salah");
                }
            } catch (Exception e) {
                System.out.println("Terjadi Kesalahan , silahkan coba lagi");
            } finally {
                scanInt = new Scanner(System.in);
                scanStr = new Scanner(System.in);
            }
        } while (n
                != 0);
    }
}
