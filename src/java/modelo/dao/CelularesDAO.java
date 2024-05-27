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
    Connection cnx;
    ConexionDB cdb = new ConexionDB();
    PreparedStatement ps;
    ResultSet rs;


public List listar() {
        List<CelularesDTO> ios = new ArrayList<>();
        String SQL = "SELECT * FROM celulares WHERE categoria='ios'";

        try {
            cnx = cdb.obtenerConexion();
            ps = cnx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                CelularesDTO c = new CelularesDTO();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setTipo(rs.getString(3));
                c.setPrecio(rs.getDouble(4));
                c.setImagen(rs.getString(5));
                ios.add(c);
            }
        } catch (SQLException e) {
        }
        return ios;
    }
    
    public List list() {
        List<CelularesDTO> android = new ArrayList<>();
        String SQL = "SELECT * FROM celulares WHERE categoria='android'";

        try {
            cnx = cdb.obtenerConexion();
            ps = cnx.prepareStatement(SQL);
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