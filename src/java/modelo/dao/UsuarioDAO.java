package modelo.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletContext;
import modelo.dto.UsuarioDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import servicios.ConexionDB;

public class UsuarioDAO {

    //private final Connection conexion;
    Connection conexion;
    ConexionDB cdb = new ConexionDB();
    PreparedStatement ps;
    ResultSet rs;
    
    
    public UsuarioDAO() {
        this.conexion = ConexionDB.obtenerConexion();
    }

    public UsuarioDTO validarUsuario(String correo, String contrasena) {
        UsuarioDTO usuario = null;
        String sql = "SELECT idUsuario, nombres, apellidos, correo, contrasena, code, correo_verificado FROM usuarios WHERE correo = ? AND contrasena = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, correo);
            ps.setString(2, contrasena);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new UsuarioDTO();
                    usuario.setId(rs.getInt("idUsuario"));
                    usuario.setNombres(rs.getString("nombres"));
                    usuario.setApellidos(rs.getString("apellidos"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setContrasena(rs.getString("contrasena"));
                    usuario.setCode(rs.getString("code"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public boolean registrarUsuario(UsuarioDTO usuario) {
        System.out.println("Correo ya registrado: " + usuario.getCorreo());
        if (correoExiste(usuario.getCorreo())) {
            return false;
        }

        String query = "INSERT INTO usuarios (nombres, apellidos, correo, contrasena, code) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, usuario.getNombres());
            pstmt.setString(2, usuario.getApellidos());
            pstmt.setString(3, usuario.getCorreo());
            pstmt.setString(4, usuario.getContrasena());
            pstmt.setString(5, usuario.getCode());
            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Usuario registrado: " + usuario.getCorreo());
            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean correoExiste(String correo) {
        String query = "SELECT correo FROM usuarios WHERE correo = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, correo);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    //----------
    public List lista() {
        List<UsuarioDTO> usuarios = new ArrayList<>();
        String cadSQL = "SELECT id, nombres, apellidos, correo FROM usuarios";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //conexion = cdb.obtenerConexion();
            ps = conexion.prepareStatement(cadSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                UsuarioDTO u = new UsuarioDTO();
                u.setId(rs.getInt("id"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setCorreo(rs.getString("correo"));
                usuarios.add(u);

            }

        } catch (SQLException e) {
            System.out.println("Error al obtener usuarios: " + e.getMessage());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return usuarios;
    }

    public JasperPrint exportarPDF(ServletContext context) throws JRException {
        // Obtener lista de usuarios 
        List<UsuarioDTO> usuarios = lista();
        // Ruta del archivo JRXML
        String jrxmlFilePath = context.getRealPath("/reporte/ReporteCelulares.jrxml");

        // Compilar el archivo JRXML a Jasper
        JasperReport jasperReportFuente = JasperCompileManager.compileReport(jrxmlFilePath);

        // Crear un datasource para llenar el reporte
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(usuarios);

        // Llenar el reporte con los datos
        JasperPrint jasperPrint = 
                JasperFillManager.fillReport(jasperReportFuente,
                    new HashMap<>(),
                    dataSource);

        return jasperPrint;
    }

}
