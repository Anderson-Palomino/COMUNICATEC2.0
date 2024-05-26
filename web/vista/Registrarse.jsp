<%-- 
    Document   : Registrarse
    Created on : 26 may. 2024, 17:38:43
    Author     : ander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../css/footerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="../css/headerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="../css/registrarseCSS.css" rel="stylesheet" type="text/css"/>
        <script src="./js/carritoService.js" defer></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>COMUNICATEC&reg; - Registrarse</title>
        <link rel="icon" href="../img/favicon_2.png" /> <!-- Icono del sitio web -->
    </head>
    <jsp:include page="header.jsp" />
    <body>
        <form method="post">
            <div class="containerRegistrar">
                <section class="form-register">
                    <h4>Formulario Registro</h4>
                    <input class="controls" type="text" name="nombres" id="nombres" placeholder="Ingrese su Nombre" value="">
                    <input class="controls" type="text" name="apellidos" id="apellidos" placeholder="Ingrese su Apellido" value="">
                    <input class="controls" type="email" name="correo" id="correo" placeholder="Ingrese su Correo" value="">
                    <input class="controls" type="password" name="contrasena" id="contrasena" placeholder="Ingrese su Contraseña" value="">
                    <p>Estoy de acuerdo con <a href="#">Términos y Condiciones</a></p>
                    <input class="botons" type="submit" value="Registrar" name="registro">
                    <p><a class="buttom" href="Ingresar.php">Ya tengo cuenta</a></p>
                </section>
            </div>
        </form>
    </body>
    <jsp:include page="footer.jsp" />
</html>
