<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Celulares</title>
        <link href="<%=request.getContextPath()%>/css/headerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="<%=request.getContextPath()%>/css/footerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="<%=request.getContextPath()%>/css/ADMIcelular.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="icon" href="<%=request.getContextPath()%>/img/favicon_2.png" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    </head>
    <jsp:include page="ADMIheader.jsp" />

    <body>
        <form action="<%= request.getContextPath()%>/SVADMIcelular" method="post" class="formulario" id="formPaquetes">
            <fieldset>
                <label>ID</label>
                <input type="text" name="id" value="${id}" readonly/>
                <label>nombre</label>
                <input type="text" name="nombre" value="${nombre}"/>
                <label>Categoría</label>
                <select name="tipo">
                    <option value="ios" name="tipo">Ios</option>
                    <option value="android" name="tipo">Android</option>
                </select>
                <label>Precio</label>
                <input type="text" name="precio" value="${precio}"/>

                <!-- comment <input type="text" name="categoria" value=""/> -->
                <label>Imagen</label>
                <input type="text" name="imagen" value="${imagen}"/>

                <input type="submit"  value="Registrar" name="accion"/>
            </fieldset>
        </form>

        <div class="container">
            <table class="tablaRep">
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>NOMBRE</td>
                        <td>TIPO</td>
                        <td>PRECIO</td>
                        <td>IMAGEN</td>
                        <td class="acciones">Acción</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cel" items="${producto}">
                        <tr>
                            <td>${cel.getId()}</td>
                            <td>${cel.getNombre()}</td>
                            <td>${cel.getTipo()}</td>
                            <td>${cel.getPrecio()}</td>
                            <td><img src="${pageContext.request.contextPath}/img/${cel.getImagen()}" alt="celular"/></td>
                            <td class="acciones">
                                <a href="<%=request.getContextPath()%>/SVADMIcelular?accion=edit&id=${cel.id}"><i class="fa-solid fa-pen-to-square editar"></i></a>
                                <a href="<%=request.getContextPath()%>/SVADMIcelular?accion=delete&id=${cel.id}"><i class="fa-sharp fa-solid fa-trash delete"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

    </body>
    <jsp:include page="footer.jsp" />
</html>
