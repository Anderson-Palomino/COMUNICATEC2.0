<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header class="containerHeader">
    <a href="index.jsp" class="logoMenu">
        <!--   <img src="../img/logo.png" alt="Logo"/> Logotipo -->
        <img src="../img/logo.png" alt="Logo"/>
    </a>
    <nav class="navegador"> <!-- Barra de navegación -->
        <ul class="menu">
            <li><a href="index.jsp">Inicio</a></li>
            <li>
                <a href="#" id="submenubtn">Celulares <i class="fas fa-chevron-down"></i></a>
                <!-- Agrega la clase 'fas' para indicar que es un ícono de FontAwesome -->
                <ul class="submenu">
                    <li><a href="<%=request.getContextPath()%>/SVIos">IOS</a></li>
                    <li><a href="<%=request.getContextPath()%>/SVAndroid">Android</a></li>
                </ul>
            </li>
            <li><a href="Contactanos.jsp">Contactanos</a></li>
            <li><a href="Nosotros.jsp">Nosotros</a></li>
            <li><a href="Ingresar.jsp">Ingresar</a></li>
            <li><a href="Registrarse.jsp">Registrarse</a></li>
        </ul>
    </nav> <!-- Fin de la barra de navegación --> 
</header>

