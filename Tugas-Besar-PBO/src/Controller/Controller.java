/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import ViewConsole.GUITest;
import ViewConsole.ViewGUISelection;
import ViewGUI.ViewGUIAnggota;
import ViewGUI.ViewGUIDeleteAnggota;
import ViewGUI.ViewGUIData;
import ViewGUI.ViewGUIPetugasLogin;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;

/**
 *
 * @author Alfian R7
 */
public abstract class Controller extends MouseAdapter implements ActionListener {
    
    private Aplikasi app;
    
    private JPanel mainpanel;
    private ViewGUIAnggota viewAnggota;
    private ViewGUIDeleteAnggota deleteAnggota;
    private GUITest viewTest;
    private ViewGUISelection viewSelection;
    private ViewGUIData viewData;
    private ViewGUIPetugasLogin viewPetugasLogin;   
    private ActionListener ae;

    public Controller(Aplikasi app) {
        this.app = app;
        
        viewAnggota = new ViewGUIAnggota();
        deleteAnggota = new ViewGUIDeleteAnggota();
        viewTest = new GUITest();
        viewSelection = new ViewGUISelection();
        viewData = new ViewGUIData(app);
        viewPetugasLogin = new ViewGUIPetugasLogin();
        
        
        
        viewAnggota.addActionListener(ae);
        deleteAnggota.addListener(ae);
        viewSelection.addListener(ae);
        viewData.addListener(ae);
        viewPetugasLogin.addListener(ae);
        
    
    }
    
    
    
}
