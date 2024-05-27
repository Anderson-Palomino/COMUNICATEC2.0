package controladores;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import modelo.dao.SugerenciaDAO;
import modelo.dto.SugerenciaDTO;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet("/SVPortalSugerencias")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2) 
public class SVPortalSugerencias extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection connection;

    @Override
    public void init() throws ServletException {
        // Inicialización de la conexión con la base de datos
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/paginawebcelulares?useTimeZone=true&serverTimezone=UTC&autoReconnect=true");
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (SQLException ex) {
            Logger.getLogger(SVPortalSugerencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SugerenciaDAO sugerenciaDAO = new SugerenciaDAO(connection);

        // Obtener parámetros del formulario
        String tipoDocumento = request.getParameter("Documentos");
        String nroDocumento = request.getParameter("NroDoc");
        String primerNombre = request.getParameter("PrimerNombre");
        String segundoNombre = request.getParameter("SegundoNombre");
        String primerApellido = request.getParameter("PrimerApellido");
        String segundoApellido = request.getParameter("SegundoApellido");
        String celular = request.getParameter("Celular");
        String correo = request.getParameter("Correo");
        String observaciones = request.getParameter("Obs");
        Part imagenPart = request.getPart("imagen_reclamante");
        String pedidoConsumidor = request.getParameter("pedido_consumidor");

        // Convertir imagen a arreglo de bytes
        byte[] imagen = null;
        if (imagenPart != null && imagenPart.getSize() > 0) {
            imagen = imagenPart.getInputStream().readAllBytes();
        }

        // Crear un nuevo objeto SugerenciaDTO y establecer sus campos
        SugerenciaDTO sugerencia = new SugerenciaDTO();
        sugerencia.setTipoDocumento(tipoDocumento);
        sugerencia.setNroDocumento(nroDocumento);
        sugerencia.setPrimerNombre(primerNombre);
        sugerencia.setSegundoNombre(segundoNombre);
        sugerencia.setPrimerApellido(primerApellido);
        sugerencia.setSegundoApellido(segundoApellido);
        sugerencia.setCelular(celular);
        sugerencia.setCorreo(correo);
        sugerencia.setObservaciones(observaciones);
        sugerencia.setImagen(imagen);
        sugerencia.setPedidoConsumidor(pedidoConsumidor);

        try {
            // Guardar la sugerencia en la base de datos
            sugerenciaDAO.addSugerencia(sugerencia);
            response.sendRedirect("success.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SugerenciaDAO sugerenciaDAO = new SugerenciaDAO(connection);
        try {
            // Obtener todas las sugerencias de la base de datos
            List<SugerenciaDTO> sugerencias = sugerenciaDAO.getAllSugerencias();
            request.setAttribute("sugerencias", sugerencias);
            request.getRequestDispatcher("listaSugerencias.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void destroy() {
        // Cerrar la conexión con la base de datos cuando se destruye el servlet
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
        }
    }
}