package controladores;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.CelularesDAO;
import modelo.dto.CelularesDTO;

public class SVADMIcelular extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //crear el objeto paqDAO dentro de PaqueteDAO
        CelularesDAO celdao = new CelularesDAO();
        List<CelularesDTO> producto = new ArrayList<>();

        String accion = request.getParameter("accion");
        producto = celdao.cel();
        if (accion != null) {
            switch (accion) {
                case "Registrar": {
                    //Recibir parámetros del formulario
                    String id = request.getParameter("id");
                    String nombre = request.getParameter("nombre");
                    String tipo = request.getParameter("tipo");
                    String precio = request.getParameter("precio");
                    String imagen = request.getParameter("imagen");

                    // Validar y convertir idPaquete a entero
                    int ids = 0; // Valor por defecto o manejo de error
                    if (!id.isEmpty()) {
                        ids = Integer.parseInt(id);
                    }

                    // Validar y convertir precioPaquete a double
                    double precios = 0.0; // Valor por defecto o manejo de error
                    if (!precio.isEmpty()) {
                        precios = Double.parseDouble(precio);
                    }

                    //crear el objeto Paquete y establecer sus atributos
                    CelularesDTO c = new CelularesDTO();
                    //request.setAttribute("paquetes", paquetes);}
                    c.setId(ids);
                    c.setNombre(nombre);
                    c.setTipo(tipo);
                    c.setPrecio(precios);
                    c.setImagen(imagen);

                    //Insertar la sugerencia en la BD por el modelo DAO
                    String resp = celdao.insertUpdate(c);
                    // Obtener la lista actualizada de paquetes
                    producto = celdao.cel();
                    request.setAttribute("producto", producto);
                    request.getRequestDispatcher("./vista/ADMIcelular_1.jsp").forward(request, response);
                    break;
                }

                case "RegistrarAjax": {
                    //Recibir parámetros del formulario
                    String id = request.getParameter("id");
                    String nombre = request.getParameter("nombre");
                    String tipo = request.getParameter("tipo");
                    String precio = request.getParameter("precio");
                    String imagen = request.getParameter("imagen");

                    // Validar y convertir idPaquete a entero
                    int ids = 0; // Valor por defecto o manejo de error
                    if (!id.isEmpty()) {
                        ids = Integer.parseInt(id);
                    }

                    // Validar y convertir precioPaquete a double
                    double precios = 0.0; // Valor por defecto o manejo de error
                    if (!precio.isEmpty()) {
                        precios = Double.parseDouble(precio);
                    }

                    //crear el objeto Paquete y establecer sus atributos
                    CelularesDTO c = new CelularesDTO();
                    //request.setAttribute("paquetes", paquetes);}
                    c.setId(ids);
                    c.setNombre(nombre);
                    c.setTipo(tipo);
                    c.setPrecio(precios);
                    c.setImagen(imagen);

                    //Insertar la sugerencia en la BD por el modelo DAO
                    String resp = celdao.insertUpdate(c);
                    // Obtener la lista actualizada de paquetes
                    producto = celdao.cel();
                    response.setContentType("application/json;charset=UTF-8");
                    String listaProductoJson = new Gson().toJson(producto);
                    response.getWriter().println(listaProductoJson);
                    //request.setAttribute("producto", producto);
                    //request.getRequestDispatcher("./vista/ADMIcelular_1.jsp").forward(request, response);
                    break;
                }

                case "edit": {
                    Integer idp = Integer.valueOf(request.getParameter("id"));
                    CelularesDTO c = celdao.get(idp);
                    // Establecer atributos en el request para pasar al JSP de edición
                    request.setAttribute("id", "" + c.getId());
                    request.setAttribute("nombre", "" + c.getNombre());
                    request.setAttribute("tipo", "" + c.getTipo());
                    request.setAttribute("precio", "" + c.getPrecio());
                    request.setAttribute("imagen", "" + c.getImagen());
                    request.setAttribute("producto", producto);

                    // Obtener la lista actualizada de paquetes
                    producto = celdao.cel();
                    request.setAttribute("producto", producto);
                    request.getRequestDispatcher("./vista/ADMIcelular_1.jsp").forward(request, response);
                    break;
                }
                case "delete": {
                    Integer idp = Integer.valueOf(request.getParameter("id"));
                    String resp = celdao.delete(idp);
                    // Manejar el resultado del borrado
                    request.setAttribute("mensaje", resp);
                    if (resp.trim().isEmpty()) {
                        request.setAttribute("result", "info");
                    } else {
                        request.setAttribute("result", "error");
                    }           // Actualizar la lista y redirigir a la página de administración
                    producto = celdao.cel();
                    request.setAttribute("producto", producto);
                    request.getRequestDispatcher("./vista/ADMIcelular_1.jsp").forward(request, response);
                    break;
                }
                default:
                    break;
            }
        } else {
            request.setAttribute("producto", producto);
            request.getRequestDispatcher("./vista/ADMIcelular_1.jsp").forward(request, response);
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
