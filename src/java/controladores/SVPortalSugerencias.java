import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.SugerenciaDAO;
import modelo.dto.SugerenciaDTO;

@WebServlet(name = "SVPortalSugerencias", urlPatterns = {"/SVPortalSugerencias"})
public class SVPortalSugerencias extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipoDocumento = request.getParameter("Documentos");
        String nroDocumento = request.getParameter("NroDoc");
        String primerNombre = request.getParameter("PrimerNombre");
        String segundoNombre = request.getParameter("SegundoNombre");
        String primerApellido = request.getParameter("PrimerApellido");
        String segundoApellido = request.getParameter("SegundoApellido");
        String celular = request.getParameter("Celular");
        String correo = request.getParameter("Correo");
        String observaciones = request.getParameter("Obs");
        
        // Corrección para evitar NullPointerException
        byte[] imagen = null;
        String imagenReclamante = request.getParameter("imagen_reclamante");
        if (imagenReclamante != null) {
            imagen = imagenReclamante.getBytes();
        }
        
        String pedidoConsumidor = request.getParameter("pedido_consumidor");
        // Suponiendo que la fecha es el momento actual
        Timestamp fecha = new Timestamp(System.currentTimeMillis());

        SugerenciaDTO sugerencia = new SugerenciaDTO();
        sugerencia.setTipo_documento(tipoDocumento);
        sugerencia.setNro_documento(nroDocumento);
        sugerencia.setPrimer_nombre(primerNombre);
        sugerencia.setSegundo_nombre(segundoNombre);
        sugerencia.setPrimer_apellido(primerApellido);
        sugerencia.setSegundo_apellido(segundoApellido);
        sugerencia.setCelular(celular);
        sugerencia.setCorreo(correo);
        sugerencia.setObservaciones(observaciones);
        sugerencia.setImagen(imagen);
        sugerencia.setPedido_consumidor(pedidoConsumidor);
        sugerencia.setFecha(fecha);

        SugerenciaDAO sugerenciaDAO = new SugerenciaDAO();
        boolean exito = sugerenciaDAO.insertarSugerencia(sugerencia);

        if (exito) {
            response.getWriter().write("Sugerencia registrada correctamente.");
        } else {
            response.getWriter().write("Error al registrar la sugerencia.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}


