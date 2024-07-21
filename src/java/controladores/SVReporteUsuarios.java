package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.UsuarioDAO;
import modelo.dto.UsuarioDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

public class SVReporteUsuarios extends HttpServlet {

    UsuarioDAO usdao = new UsuarioDAO();
    List<UsuarioDTO> usuarios = new ArrayList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        usuarios = usdao.lista();
        
        if (request.getParameter("accion") != null) {
            String accion = request.getParameter("accion");
            switch (accion) {
                case "pdf":
                    try {
                        //Llenar el reporte con datos
                        JasperPrint jasperPrint = new UsuarioDAO().exportarPDF(getServletContext());

                        //Configurar la respuesta HTTP
                        response.setContentType("application/pdf");
                        response.setCharacterEncoding("UTF-8");
                        response.setHeader("Content-Disposition", "inline; filename=reporte.pdf");

                        //Esportar el reporte a la salida del servlet
                        JasperExportManager.exportReportToPdfStream(jasperPrint, 
                                response.getOutputStream());
                        
                    } catch (JRException e) {
                        throw new ServletException(e);
                    }
                    break;
            }

        } else {
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("./vista/ReporteUsuarios.jsp").forward(request, response);
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
