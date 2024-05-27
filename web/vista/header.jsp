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
    <body>
        <header class="containerHeader">
            <a href="${pageContext.request.contextPath}/index.jsp" class="logoMenu">
                <img src="${pageContext.request.contextPath}/img/logo.png" alt="Logo"/>
            </a>
            <nav class="navegador"> <!-- Barra de navegación -->
                <ul class="menu">
                    <li><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a></li>
                    <li>
                        <a href="#" id="submenubtn">Celulares <i class="fas fa-chevron-down"></i></a>
                        <!-- Agrega la clase 'fas' para indicar que es un ícono de FontAwesome -->
                        <ul class="submenu">
                            <li><a href="${pageContext.request.contextPath}/VentanaIOS.jsp">IOS</a></li>
                            <li><a href="${pageContext.request.contextPath}/VentanaAndroid.jsp">Android</a></li>
                        </ul>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/vista/Contactanos.jsp">Contactanos</a></li>
                    <li><a href="${pageContext.request.contextPath}/vista/Nosotros.jsp">Nosotros</a></li>
                        <c:choose>
                            <c:when test="${not empty sessionScope.usuario}">
                            <li>
                                <a href="#">Hola, ${sessionScope.usuario.nombres} <i class="fas fa-chevron-down"></i></a>
                                <ul class="submenu">
                                    <li><a href="${pageContext.request.contextPath}/CerrarSesionServlet">Cerrar sesión</a></li>
                                </ul>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${pageContext.request.contextPath}/vista/Ingresar.jsp">Ingresar</a></li>
                            <li><a href="${pageContext.request.contextPath}/vista/Registrarse.jsp">Registrarse</a></li>
                            </c:otherwise>
                        </c:choose>

                </ul>
            </nav> <!-- Fin de la barra de navegación -->
        </header>
    </body>
</html>