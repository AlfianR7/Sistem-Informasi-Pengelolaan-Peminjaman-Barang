package Driver;

import ViewConsole.ViewConsole;
import Model.Aplikasi;
import Controller.Controller;

public class Driver {

    public static void main(String[] args) {
        Aplikasi apk = new Aplikasi();

        new Controller(apk);
        
        ViewConsole view = new ViewConsole(apk);
        view.Menu();
    }
}
