
package servicios.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConectaDB {
    public Connection getConexion() throws SQLException{
        Connection cnx = null;
        
        String hostname = "localhost";
        String username = "root";
        String password = "";
        String database = "paginawebcelulares";
        String port = "3306";
        
        String url = "jdbc:mysql://localhost:3306/paginawebcelulares?useTimeZone=true&serverTimezone=UTC&autoReconnect=true";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectaDB.class.getName()).log(Level.SEVERE, null, ex);
            // Manejar la excepción de clase no encontrada
        }

        return cnx;
    }

    public static void main(String[] args) throws SQLException {
        ConectaDB cdb = new ConectaDB();
        Connection cnx = cdb.getConexion();
        System.out.println("" + cnx.getCatalog());
    }
       
    
}
