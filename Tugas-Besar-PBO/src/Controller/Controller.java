package Controller;

import Model.*;
import ViewGUI.AddAnggota;
import ViewGUI.AddPeminjaman;
import ViewGUI.AllMenus;
import ViewGUI.Login;
import ViewGUI.MainMenu;
import ViewGUI.View;
import ViewGUI.AddPetugas;
import ViewGUI.AddBarang;
import ViewGUI.ViewAnggotaAndDelete;
import ViewGUI.ViewBarang;
import ViewGUI.ViewPeminjaman;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Alfian R7
 */
// Created by:
// Nama     :Alfian Rahman Aziz
// NIM      : 1301150063

public class Controller extends MouseAdapter implements ActionListener {

    private Aplikasi app;

    private View view;

    public Controller(Aplikasi app) {
        this.app = app;

        MainMenu M = new MainMenu();
        M.setVisible(true);
        M.addListener((ActionListener) this);
        view = M;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (view instanceof MainMenu) {
            MainMenu M = (MainMenu) view;
            if (source.equals(M.getBtnAnggota())) {
                AddAnggota a = new AddAnggota();
                a.setVisible(true);
                a.addListener(this);
                M.dispose();
                view = a;
            } else if (source.equals(M.getBtnPetugas())) {
                AddPetugas p = new AddPetugas();
                p.setVisible(true);
                p.addListener(this);
                M.dispose();
                view = p;
            } else if (source.equals(M.getLogin())) {
                Login L = new Login();
                L.setVisible(true);
                L.addListener(this);
                M.dispose();
                view = L;
            }
        } else if (view instanceof AddAnggota) {
            AddAnggota a = (AddAnggota) view;
            if (source.equals(a.getBtnBack())) {
                MainMenu M = new MainMenu();
                M.setVisible(true);
                M.addListener(this);
                a.dispose();
                view = M;
            } else if (source.equals((a.getBtnAdd()))) {
                String nama = a.GetNamaAnggota();
                String JenisKelamin = a.getJenisKelamin();
                try {
                    app.addAnggota(nama, JenisKelamin);
                    app.saveAnggota();
                    javax.swing.JOptionPane.showMessageDialog(null, "Anggota Baru telah di tambahkan");
                } catch (IOException io) {
                    a.ViewErrorMsg(io.getMessage());
                }
                a.reset();
            }
        } else if (view instanceof AddPetugas) {
            AddPetugas p = (AddPetugas) view;
            if (source.equals(p.getBtnBack())) {
                MainMenu M = new MainMenu();
                M.setVisible(true);
                M.addListener(this);
                p.dispose();
                view = M;
            } else if (source.equals((p.getBtnAdd()))) {
                String nama = p.GetNamaPetugas();
                String JenisKelamin = p.getJenisKelamin();
                String pass = p.getPasswordPetugas();
                try {
                    app.addPetugas(nama, JenisKelamin, pass);
                    app.savePetugas();
                    JOptionPane.showMessageDialog(null, "Petugas telah ditambahkan");
                } catch (IOException io) {
                    p.ViewErrorMsg(io.getMessage());
                }
                p.reset();
            }
        } else if (view instanceof Login) {
            Login l = (Login) view;
            if (source.equals(l.getBtnBack())) {
                MainMenu M = new MainMenu();
                M.setVisible(true);
                M.addListener(this);
                l.dispose();
                view = M;
            } else if (source.equals(l.getBtnLogin())) {
                String username = l.getUsername();
                String password = l.getPassword();
                Petugas p = app.getPetugasUsername(username);
                if (source.equals(l.getBtnRefresh())) {
                    try {
                        app.loadPetugas();
                    } catch (IOException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try {
                    if ("admin".equals(username) || p.getUser().equals(username)) {
                        if ("admin".equals(password) || p.getPass().equals(password)) {
                            AllMenus Am = new AllMenus();
                            Am.setVisible(true);
                            Am.addListener(this);
                            l.dispose();
                            view = Am;
                        }
                    }
                } catch (Exception io) {
                    JOptionPane.showMessageDialog(null, "Username atau password tidak sesuai");
                    l.reset();
                }
            }
        } else if (view instanceof AllMenus) {
            AllMenus Am = (AllMenus) view;
            if (source.equals(Am.getBtnAnggota())) {
                ViewAnggotaAndDelete Vd = new ViewAnggotaAndDelete();
                Vd.setVisible(true);
                Vd.addListener(this);
                Am.dispose();
                view = Vd;
            } else if (source.equals(Am.getBtnBarang())) {
                ViewBarang Vb = new ViewBarang();
                Vb.setVisible(true);
                Vb.addListener(this);
                Am.dispose();
                view = Vb;
            } else if (source.equals(Am.getBtnPeminjaman())) {
                ViewPeminjaman Vp = new ViewPeminjaman();
                Vp.setVisible(true);
                Vp.addListener(this);
                Am.dispose();
                view = Vp;
            } else if (source.equals(Am.getBtnAddPinjaman())) {
                AddPeminjaman Ap = new AddPeminjaman();
                Ap.setVisible(true);
                Ap.addListener(this);
                Am.dispose();
                view = Ap;
            } else if (source.equals(Am.getBtnLogout())) {
                MainMenu M = new MainMenu();
                M.setVisible(true);
                M.addListener(this);
                Am.dispose();
                view = M;
            } else if (source.equals(Am.getBtnAddBarang())) {
                AddBarang Ab = new AddBarang();
                Ab.setVisible(true);
                Ab.addListener(this);
                Am.dispose();
                view = Ab;
            }
        } else if (view instanceof ViewAnggotaAndDelete) {
            ViewAnggotaAndDelete Vd = (ViewAnggotaAndDelete) view;
            if (source.equals(Vd.getBtnBack())) {
                AllMenus Am = new AllMenus();
                Am.setVisible(true);
                Am.addListener(this);
                Vd.dispose();
                view = Am;
            } else if (source.equals(Vd.getBtnRefresh())) {
                try {
                    app.loadAnggota();
                    Vd.setListAnggota(app.ListAnggota());
                } catch (IOException io) {
                    Vd.ViewErrorMsg(io.getMessage());
                }
            }
            if (source.equals(Vd.getBtnDelete())) {
                String id = Vd.getDeleteID();
                try {
                    app.deleteAnggotaIndexID(id);
                    app.saveAnggota();
                } catch (Exception io) {
                    JOptionPane.showMessageDialog(null, "ID tidak Terdaftar");
                }
            } else if (source.equals(Vd.getBtnDelete())) {
                String nama = Vd.getDeleteNama();
                try {
                    app.deleteAnggotaIndexNama(nama);
                    app.saveAnggota();
                } catch (Exception io) {
                    JOptionPane.showMessageDialog(null, "Nama tidak Terdaftar");
                }
            }
        } else if (view instanceof ViewBarang) {
            ViewBarang Vb = (ViewBarang) view;
            if (source.equals(Vb.getBack())) {
                AllMenus Am = new AllMenus();
                Am.setVisible(true);
                Am.addListener(this);
                Vb.dispose();
                view = Am;
            } else if (source.equals(Vb.getRefresh())) {
                try {
                    app.loadBarang();
                    Vb.setListbarang(app.ListBarang());
                } catch (Exception io) {
                    Vb.ViewErrorMsg(io.getMessage());
                }
                Vb.setDetailBarang("");
            }
        } else if (view instanceof ViewPeminjaman) {
            ViewPeminjaman Vp = (ViewPeminjaman) view;
            if (source.equals(Vp.getBack())) {
                AllMenus Am = new AllMenus();
                Am.setVisible(true);
                Am.addListener(this);
                Vp.dispose();
                view = Am;
            } else if (source.equals(Vp.getRefesh())) {
                try {
                    app.loadPeminjaman();
                    Vp.setListPeminjaman(app.getListpeminjaman());
                } catch (Exception io) {
                    Vp.ViewErrorMsg(io.getMessage());
                }
            }
        } else if (view instanceof AddPeminjaman) {
            AddPeminjaman Ap = (AddPeminjaman) view;
            if (source.equals(Ap.getBtnBack())) {
                AllMenus Am = new AllMenus();
                Am.setVisible(true);
                Am.addListener(this);
                Ap.dispose();
                view = Am;
            } else if (source.equals(Ap.getBtnADD())) {
                String ID = Ap.getIDBarang();
                String nama = Ap.getNamaAnggota();
                String namaA = Ap.getNamaAnggota();
                try {
                    app.addPeminjaman(ID, namaA);
                    app.savePeminjaman();
                    JOptionPane.showMessageDialog(null, "Data Telah di inputkan");
                } catch (Exception io) {
                    Ap.ViewErrorMsg(io.getMessage());
                }
            }
            Ap.reset();
        } else if (view instanceof AddBarang) {
            AddBarang Ab = (AddBarang) view;
            if (source.equals(Ab.getBtnBack())) {
                AllMenus Am = new AllMenus();
                Am.setVisible(true);
                Am.addListener(this);
                Ab.dispose();
                view = Am;
            } else if (source.equals(Ab.getBtnAdd())) {
                String nama = Ab.getNamaBarang();
                try {
                    app.addBarang(nama);
                    app.saveBarang();
                    JOptionPane.showMessageDialog(null, "Barang telah di inputkan");
                } catch (Exception io) {
                    Ab.ViewErrorMsg(io.getMessage());
                }
            }
            Ab.reset();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (view instanceof ViewAnggotaAndDelete) {
            ViewAnggotaAndDelete Va = (ViewAnggotaAndDelete) view;
            String IDanggota = Va.getSelectedIdAnggota();
            if (IDanggota != null) {
                Va.setDetailAnggota(app.getAnggota(IDanggota).toString());
            }
        } else if (view instanceof ViewBarang) {
            ViewBarang Vb = (ViewBarang) view;
            String IDBarang = Vb.getSelelctedIDBarang();
            if (IDBarang != null) {
                Vb.setDetailBarang(app.getBarang(IDBarang).toString());
            }
        } else if (view instanceof ViewPeminjaman) {
            ViewPeminjaman Vp = (ViewPeminjaman) view;
            String IDPeminjaman = Vp.getSelectedIdPeminjaman();
            if (IDPeminjaman != null) {
                Vp.setDetailPeminjaman(app.getpeminjaman(IDPeminjaman).toString());
            }
        }
    }

}
