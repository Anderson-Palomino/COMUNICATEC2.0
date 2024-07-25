<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="modelo.dto.UsuarioDTO" %>
<%
    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
    boolean estaLogueado = usuario != null;
    Integer contador = (Integer) session.getAttribute("contador");
    if (contador == null) {
        contador = 0; // Valor predeterminado si no hay productos en el carrito
    }
%>
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
        <nav class="navegador">
            <ul class="menu">
                <li><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a></li>
                <li><a href="${pageContext.request.contextPath}/SVADMIcelular">CELadmi</a></li>
                <li><a href="${pageContext.request.contextPath}/SVReporteUsuarios">USUAadmi</a></li>
                <li>
                    <a href="#" id="submenubtn">Celulares <i class="fas fa-chevron-down"></i></a>
                    <ul class="submenu">
                        <li><a href="${pageContext.request.contextPath}/SVIos">IOS</a></li>
                        <li><a href="${pageContext.request.contextPath}/SVAndroid">Android</a></li>
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
                <li class="carrito">
                    <a href="${pageContext.request.contextPath}/SVProductos?accion=Carrito">
                        <i class="fa fa-shopping-cart"></i> Carrito(<%= contador %>)
                    </a>
                </li>
            </ul>
        </nav>
    </header>
</body>
</html>