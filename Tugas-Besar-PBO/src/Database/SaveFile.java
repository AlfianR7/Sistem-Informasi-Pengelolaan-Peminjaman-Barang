package Database;

import java.io.*;

/**
 *
 * @author Alfian R7
 */
// Created by:
// Nama     :Alfian Rahman Aziz
// NIM      : 1301150063
public class SaveFile {

    public void saveObject(Object o, String file) throws FileNotFoundException, IOException {
        FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(o);
        oout.flush();
    }

    public Object getObject(String file) throws FileNotFoundException, IOException,
            ClassNotFoundException, EOFException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        return ois.readObject();
    }
}

//public class Database {
//    private String dbuser = "root";
//    private String dbpasswd = "";
//    private Statement stmt = null;
//    private Connection con = null;
//    private ResultSet rs = null;
//    
//    public Database(){
//        try{
//            Class.forName("org.gjt.mm.mysql.Driver");
//        } catch(Exception e){
//            JOptionPane.showMessageDialog(null, ""+e.getMessage(),"JDBC Driver Error", JOptionPane.WARNING_MESSAGE);
//        }
//        
//        try{
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventarisbarang",dbuser, dbpasswd);
//            stmt = con.createStatement();
//        } catch (Exception e){
//            JOptionPane.showMessageDialog(null, ""+e.getMessage(),"Connection Error", JOptionPane.WARNING_MESSAGE);
//        }
//    }
//    
//    public ResultSet getData(String SQLString){
//        try{
//            rs = stmt.executeQuery(SQLString);
//        } catch (Exception e){
//            JOptionPane.showConfirmDialog(null, "Error: "+e.getMessage(), "Commmunication Error", JOptionPane.WARNING_MESSAGE);
//        }
//        
//        return rs;
//    }
//    
//    public void query (String SQLString){
//        try{
//            stmt.executeUpdate(SQLString);
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(null, "Error :"+e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
//        }
//    }
