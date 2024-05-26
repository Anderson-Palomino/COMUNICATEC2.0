package controladores.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SVArranque", urlPatterns = {"/SVArranque"}, loadOnStartup = 1)
public class SVArranque extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Realiza cualquier lógica adicional aquí si es necesario
        
        // Redirigir a la página de inicio (index.jsp)
        response.sendRedirect(request.getContextPath() + "./vista/index.jsp");
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
        return "Servlet de inicio para redirigir a la página de inicio (index.jsp)";
    }
}


