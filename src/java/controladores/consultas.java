package controladores;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import servicios.conexiones.ConectaDB;

/**
 * 
 * @author ander
 */
public class consultas extends ConectaDB {

    public boolean autenticacion(String usuario, String contraseña) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            String consulta = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?";
            con = getConexion();
            pst = con.prepareStatement(consulta, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            rs = pst.executeQuery();

            if (rs.absolute(1)) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        consultas co = new consultas();
        System.out.println(co.autenticacion("and@gmail.com", "$2y$10$P2TBSwnP93wgfHHyDk6oBegdDzLxJbwHb3/xIelJS3oZy4Nqs0HIy"));
    }
}

