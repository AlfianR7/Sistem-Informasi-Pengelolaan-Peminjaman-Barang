package Database;

import java.io.*;

public class SaveFile {

    public void saveObject(Object o, String file) throws FileNotFoundException, IOException {
        FileOutputStream fout = new FileOutputStream("fileAnggota.txt");
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(o);
        oout.flush();
    }

    public Object getObject(String file) throws FileNotFoundException, IOException,
        ClassNotFoundException, EOFException {
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream("fileAnggota.txt"));
            return oin.readObject();
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
