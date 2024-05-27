package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.dto.SugerenciaDTO;
import servicios.ConexionDB;

public class SugerenciaDAO {
    private final String INSERT_SQL = "INSERT INTO sugerencias (tipo_documento, nro_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, celular, correo, observaciones, imagen, pedido_consumidor, fecha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public boolean insertarSugerencia(SugerenciaDTO sugerencia) {
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {

            stmt.setString(1, sugerencia.getTipo_documento());
            stmt.setString(2, sugerencia.getNro_documento());
            stmt.setString(3, sugerencia.getPrimer_nombre());
            stmt.setString(4, sugerencia.getSegundo_nombre());
            stmt.setString(5, sugerencia.getPrimer_apellido());
            stmt.setString(6, sugerencia.getSegundo_apellido());
            stmt.setString(7, sugerencia.getCelular());
            stmt.setString(8, sugerencia.getCorreo());
            stmt.setString(9, sugerencia.getObservaciones());
            stmt.setBytes(10, sugerencia.getImagen());
            stmt.setString(11, sugerencia.getPedido_consumidor());
            stmt.setTimestamp(12, sugerencia.getFecha());

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
