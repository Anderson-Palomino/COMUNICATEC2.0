<%-- 
    Document   : header
    Created on : 27 may. 2024, 16:02:59
    Author     : ander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <!-- Aquí irían otras configuraciones de tu encabezado, como los enlaces a CSS y scripts -->
    </head>
    
        <header class="containerHeader">
            <a href="${pageContext.request.contextPath}/index.jsp" class="logoMenu">
                <img src="${pageContext.request.contextPath}/img/logo.png" alt="Logo"/>
            </a>
            <nav class="navegador"> <!-- Barra de navegación -->
                <ul class="menu">
                    <li><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a></li>
                    <li><a href="${pageContext.request.contextPath}/SVCelulares">Celulares</a></li>
                    <li><a href="${pageContext.request.contextPath}/vista/Contactanos.jsp">Usuarios</a></li>
                    <li><a href="${pageContext.request.contextPath}/vista/Nosotros.jsp">Ventas</a></li>
                        <c:choose>
                            <c:when test="${not empty sessionScope.usuario}">
                            <li>
                                <a href="#">Hola, ${sessionScope.usuario.nombres} <i class="fas fa-chevron-down"></i></a>
                                <ul class="submenu">
                                    <li><a href="${pageContext.request.contextPath}/CerrarSesionServlet">Cerrar sesión</a></li>
                                </ul>
                            </li>
                        </c:when>
                        </c:choose>
                </ul>
            </nav> <!-- Fin de la barra de navegación -->
        </header>
    
</html>