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
}