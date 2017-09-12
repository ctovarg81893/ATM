package frames;


import java.awt.HeadlessException;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;
//import java.util.logging.Level;
//import java.util.logging.Logger;



public class DB {
    Connection con = null;
    Statement Sentencia;
public Connection conexion(){
try{
Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
con = DriverManager.getConnection("jdbc:ucanaccess://DB.accdb", "", "");
        //JOptionPane.showMessageDialog(null,"DB Conectada ");
} catch (HeadlessException | ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null,"Error en la conexion: "+e);
}
return con;
}

public int editar_DB (String sql){
try{
    Sentencia=con.createStatement();
    return Sentencia.executeUpdate(sql);
} catch (HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null,"Error en la edicion: "+e);
}
return 0;
}
public ResultSet consultar_DB (String sql){
try{
    Sentencia=con.createStatement();
    return Sentencia.executeQuery(sql);
} catch (HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null,"Error en la consulta: "+e);
}
return null;
}



}
