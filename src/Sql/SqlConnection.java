package Sql;

import java.sql.*;
import javax.swing.JOptionPane;

public class SqlConnection {
    
    Connection conectar = null;
    
    String usuario = "postgres";
    String contrasenia = "117";
    String nomBD = "App";
    String ip = "localhost";
    String puerto = "5432";
    String cadena = "jdbc:postgresql://" +ip+ ":" +puerto+ "/" +nomBD;
    
    public Connection conectar(){
        
        try {
            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Error al conectar a la Base de datos, Error: " +e.toString());
        }
        
        return conectar;
    }
}
