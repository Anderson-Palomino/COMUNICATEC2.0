
package modelo.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.SugerenciaDTO;


public class SugerenciaDAO {
    private final Connection connection;

    public SugerenciaDAO(Connection connection) {
        this.connection = connection;
    }
    public void addSugerencia(SugerenciaDTO sugerencia) throws SQLException {
        String sql = "INSERT INTO sugerencias (tipo_documento, nro_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, celular, correo, observaciones, imagen, pedido_consumidor, fecha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, sugerencia.getTipoDocumento());
            stmt.setString(2, sugerencia.getNroDocumento());
            stmt.setString(3, sugerencia.getPrimerNombre());
            stmt.setString(4, sugerencia.getSegundoNombre());
            stmt.setString(5, sugerencia.getPrimerApellido());
            stmt.setString(6, sugerencia.getSegundoApellido());
            stmt.setString(7, sugerencia.getCelular());
            stmt.setString(8, sugerencia.getCorreo());
            stmt.setString(9, sugerencia.getObservaciones());
            stmt.setBytes(10, sugerencia.getImagen());
            stmt.setString(11, sugerencia.getPedidoConsumidor());
            stmt.executeUpdate();
        }
    }
    public List<SugerenciaDTO> getAllSugerencias() throws SQLException {
        List<SugerenciaDTO> sugerencias = new ArrayList<>();
        String sql = "SELECT * FROM sugerencias";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                SugerenciaDTO sugerencia = new SugerenciaDTO();
                sugerencia.setId(rs.getInt("id"));
                sugerencia.setTipoDocumento(rs.getString("tipo_documento"));
                sugerencia.setNroDocumento(rs.getString("nro_documento"));
                sugerencia.setPrimerNombre(rs.getString("primer_nombre"));
                sugerencia.setSegundoNombre(rs.getString("segundo_nombre"));
                sugerencia.setPrimerApellido(rs.getString("primer_apellido"));
                sugerencia.setSegundoApellido(rs.getString("segundo_apellido"));
                sugerencia.setCelular(rs.getString("celular"));
                sugerencia.setCorreo(rs.getString("correo"));
                sugerencia.setObservaciones(rs.getString("observaciones"));
                sugerencia.setImagen(rs.getBytes("imagen"));
                sugerencia.setPedidoConsumidor(rs.getString("pedido_consumidor"));
                sugerencia.setFecha(rs.getTimestamp("fecha"));
                sugerencias.add(sugerencia);
            }
        }
        return sugerencias;
    }
}
