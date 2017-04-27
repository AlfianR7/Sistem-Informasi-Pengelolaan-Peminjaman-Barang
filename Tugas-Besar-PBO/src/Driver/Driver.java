package Driver;

import ViewConsole.ViewConsole;
import Model.Aplikasi;
public class Driver {
    public static void main(String[] args) {
        Aplikasi apk = new Aplikasi();
        ViewConsole view = new ViewConsole(apk);
        view.Menu();
    }
}