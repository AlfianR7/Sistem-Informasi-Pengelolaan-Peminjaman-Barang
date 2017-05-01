package Driver;

import ViewConsole.ViewConsole;
import Model.Aplikasi;
import Controller.Controller;

/**
 *
 * @author Alfian R7
 */
// Created by:
// Nama     :Alfian Rahman Aziz
// NIM      : 1301150063
public class Driver {

    public static void main(String[] args) {
        Aplikasi apk = new Aplikasi();

        new Controller(apk);
        
        ViewConsole view = new ViewConsole(apk);
        view.Menu();
    }
}
