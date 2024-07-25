package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.CelularesDAO;
import modelo.dto.CarritoDTO;
import modelo.dto.CelularesDTO;

@WebServlet(name = "SVIos", urlPatterns = {"/SVIos"})
public class SVIos extends HttpServlet {

    CelularesDAO celdao = new CelularesDAO();
    CelularesDTO p = new CelularesDTO();
    List<CelularesDTO> productos = new ArrayList<>();
    int item;
    double totalPagar = 0;
    int cantidad = 1;
    int idp;
    CarritoDTO car;
    boolean productoExiste = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String accion = request.getParameter("accion");
            HttpSession session = request.getSession();
            List<CarritoDTO> listaCarrito = (List<CarritoDTO>) session.getAttribute("listaCarrito");
            if (listaCarrito == null) {
                listaCarrito = new ArrayList<>();
            }

            productos = celdao.listar();

            switch (accion != null ? accion : "default") {
                case "Comprar":
                    totalPagar = 0.0;
                    idp = Integer.parseInt(request.getParameter("id"));
                    p = celdao.listarId(idp);
                    productoExiste = false;

                    // Verifica si el producto ya está en el carrito
                    for (CarritoDTO carrito : listaCarrito) {
                        if (carrito.getIdProducto() == p.getId()) {
                            carrito.setCantidad(carrito.getCantidad() + cantidad);
                            carrito.setSubTotal(carrito.getCantidad() * carrito.getPreciocompra());
                            productoExiste = true;
                            break;
                        }
                    }

                    // Si no existe, agrégalo al carrito
                    if (!productoExiste) {
                        item = listaCarrito.size() + 1;
                        CarritoDTO car = new CarritoDTO();
                        car.setItem(item);
                        car.setIdProducto(p.getId());
                        car.setNombre(p.getNombre());
                        car.setImagen(p.getImagen());
                        car.setPreciocompra(p.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubTotal(cantidad * p.getPrecio());
                        listaCarrito.add(car);
                    }

                    // Calcular el total
                    totalPagar = listaCarrito.stream().mapToDouble(CarritoDTO::getSubTotal).sum();

                    session.setAttribute("listaCarrito", listaCarrito);
                    session.setAttribute("contador", listaCarrito.size());
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("carrito", listaCarrito);  // Aquí debería ser la lista completa

                    request.getRequestDispatcher("./vista/Carrito.jsp").forward(request, response);
                    break;
                default:
                    request.setAttribute("productos", productos);
                    request.getRequestDispatcher("./vista/Ios.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en el servidor: " + e.getMessage());
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
    }
}
