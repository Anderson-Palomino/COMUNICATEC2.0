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
        conexion = cdb.obtenerConexion();
    }
    public CelularesDTO listarId(int id){
        String sql="select * from producto where id="+id;
        CelularesDTO p = new CelularesDTO();
        try {
            conexion=cdb.obtenerConexion();
            ps=conexion.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setTipo(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setImagen(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return p;
    }
    // Obtener celular por id
    public CelularesDTO get(int idp) {
        CelularesDTO c = null;
        String cadSQL = "SELECT id, nombre, tipo, precio, imagen FROM celulares WHERE id=?";

        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return c;
    }

    // Listar los ios
    public List<CelularesDTO> listar() {
        List<CelularesDTO> ios = new ArrayList<>();
        String SQL = "SELECT * FROM celulares WHERE tipo='ios'";

        try {
            ps = conexion.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                CelularesDTO ai = new CelularesDTO();
                ai.setId(rs.getInt("id"));
                ai.setNombre(rs.getString("nombre"));
                ai.setTipo(rs.getString("tipo"));
                ai.setPrecio(rs.getDouble("precio"));
                ai.setImagen(rs.getString("imagen"));
                ios.add(ai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ios;
    }

    // Listar los android
    public List<CelularesDTO> list() {
        List<CelularesDTO> android = new ArrayList<>();
        String SQL = "SELECT * FROM celulares WHERE tipo='android'";

        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return android;
    }

    // Listar todos los productos
    public List<CelularesDTO> cel() {
        List<CelularesDTO> producto = new ArrayList<>();
        String cadSQL = "SELECT id, nombre, tipo, precio, imagen FROM celulares";

        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return producto;
    }

    // Método para eliminar productos
    public String delete(int idp) {
        String resp = "";
        String cadSQL = "DELETE FROM celulares WHERE id=?";

        try {
            ps = conexion.prepareStatement(cadSQL);
            ps.setInt(1, idp);
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                resp = "No se ha eliminado";
            }
        } catch (SQLException ex) {
            resp = ex.getMessage();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resp;
    }

    // Método para agregar o actualizar productos
    public String insertUpdate(CelularesDTO c) {
        String resp = "";
        String cadSQL = "";

        try {
            if (c.getId() == 0) {
                // Es una inserción
                cadSQL = "INSERT INTO celulares (nombre, tipo, precio, imagen) VALUES(?,?,?,?)";
                ps = conexion.prepareStatement(cadSQL);
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
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resp;
    }
}
