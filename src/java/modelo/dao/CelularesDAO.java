package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.CelularesDTO;
import servicios.ConexionDB;

public class CelularesDAO {

    Connection conexion;
    ConexionDB cdb = new ConexionDB();
    PreparedStatement ps;
    ResultSet rs;

    public CelularesDAO() {
        conexion = new ConexionDB().obtenerConexion();
    }

    
    public CelularesDTO get(int idp) {
        CelularesDTO c = null;
        String cadSQL = "SELECT id, nombre, tipo, precio, imagen FROM celulares WHERE id=? ";

        try {
            //conexion = cdb.obtenerConexion();
            ps = conexion.prepareStatement(cadSQL);
            ps.setInt(1, idp);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                c = new CelularesDTO();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setTipo(rs.getString("tipo"));
                c.setPrecio(rs.getDouble("precio"));
                c.setImagen(rs.getString("imagen"));
            }
            rs.close();
        } catch (SQLException e) {
        }
        return c;
    }
    
    //listar los ios
    public List listar() {
        List<CelularesDTO> ios = new ArrayList<>();
        String SQL = "SELECT * FROM celulares WHERE tipo='ios'";

        try {
            conexion = cdb.obtenerConexion();
            ps = conexion.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                CelularesDTO ai = new CelularesDTO();
                ai.setId(rs.getInt(1));
                ai.setNombre(rs.getString(2));
                ai.setTipo(rs.getString(3));
                ai.setPrecio(rs.getDouble(4));
                ai.setImagen(rs.getString(5));
                ios.add(ai);
            }
        } catch (SQLException e) {
        }
        return ios;
    }

    //listar los android
    public List list() {
        List<CelularesDTO> android = new ArrayList<>();
        String SQL = "SELECT * FROM celulares WHERE tipo='android'";

        try {
            conexion = cdb.obtenerConexion();
            ps = conexion.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                CelularesDTO an = new CelularesDTO();
                an.setId(rs.getInt(1));
                an.setNombre(rs.getString(2));
                an.setTipo(rs.getString(3));
                an.setPrecio(rs.getDouble(4));
                an.setImagen(rs.getString(5));
                android.add(an);
            }
        } catch (Exception e) {
        }
        return android;
    }

    public List cel() {
        List<CelularesDTO> producto = new ArrayList<>();
        String cadSQL = "SELECT id, nombre, tipo, precio, imagen FROM celulares";

        try {
            conexion = cdb.obtenerConexion();
            ps = conexion.prepareStatement(cadSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                CelularesDTO c = new CelularesDTO();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setTipo(rs.getString("tipo"));
                c.setPrecio(rs.getDouble("precio"));
                c.setImagen(rs.getString("imagen"));
                producto.add(c);
            }
        } catch (Exception e) {
        }
        return producto;
    }

    //Metodo para eliminar paquetes
    public String delete(int idp) {
        String resp = "";
        //PreparedStatement ps;
        //ResultSet rs;
        String cadSQL = "DELETE FROM celulares where id=?";
        try {
            //conexion = cdb.obtenerConexion();
            ps = conexion.prepareStatement(cadSQL);
            ps.setInt(1, idp);
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                resp = "No se ha eliminado";
            }
            ps.close();
        } catch (SQLException ex) {
            resp = ex.getMessage();
        }
        return resp;
    }
    
    //Metodo para agregar nuevos paquetes
    public String insertUpdate(CelularesDTO c) {
        String resp = "";
        String cadSQL = "";

        try {
            if (c.getId() == 0) {
                // Es una inserción
                cadSQL = "INSERT INTO celulares (nombre, tipo, precio, imagen) VALUES(?,?,?,?)";
                //conexion = cdb.obtenerConexion();
                ps = conexion.prepareStatement(cadSQL);
                //rs = ps.executeQuery();

                ps.setString(1, c.getNombre());
                ps.setString(2, c.getTipo());
                ps.setDouble(3, c.getPrecio());
                ps.setString(4, c.getImagen());
            } else {
                // Es una actualización
                cadSQL = "UPDATE celulares SET nombre=?, tipo=?, precio=?, imagen=? WHERE id=?";
                ps = conexion.prepareStatement(cadSQL);

                ps.setString(1, c.getNombre());
                ps.setString(2, c.getTipo());
                ps.setDouble(3, c.getPrecio());
                ps.setString(4, c.getImagen());
                ps.setInt(5, c.getId());
            }

            int ctos = ps.executeUpdate();

            if (ctos > 0) {
                resp = "Registro exitoso";
            } else {
                resp = "No se ha registrado";
            }
        } catch (SQLException ex) {
            resp = "Error en la inserción o actualización: " + ex.getMessage();
        }

        return resp;
    }
}
