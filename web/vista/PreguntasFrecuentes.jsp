<%@page import="modelo.dto.CategoriaDTO"%>
<%@page import="modelo.dto.PreguntaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="servicios.ConexionDB"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Preguntas frecuentes</title>
        <link href="<%=request.getContextPath()%>/css/headerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="<%=request.getContextPath()%>/css/footerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="<%=request.getContextPath()%>/css/preguntasFrecuenciasCSS.css" rel="stylesheet" type="text/css"/>
        <link href="<%=request.getContextPath()%>/css/style_preguntasfre.css" rel="stylesheet" type="text/css"/>
        <link href="<%=request.getContextPath()%>/css/pf.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="icon" href="<%=request.getContextPath()%>/img/favicon_2.png" />
    </head>

    <jsp:include page="header.jsp" />
    <body>           

        <div class="containerPF">

            <h1>Preguntas Frecuentes</h1>
            <div class="categorias" id="categorias">
                <div class="categoria activa" data-categoria="metodos-pago" id="categoria-metodos-pago">
                    <svg  viewbox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" clip-rule="evenodd"><path d="M21.19 7h2.81v15h-21v-5h-2.81v-15h21v5zm1.81 1h-19v13h19v-13zm-9.5 1c3.036 0 5.5 2.464 5.5 5.5s-2.464 5.5-5.5 5.5-5.5-2.464-5.5-5.5 2.464-5.5 5.5-5.5zm0 1c2.484 0 4.5 2.016 4.5 4.5s-2.016 4.5-4.5 4.5-4.5-2.016-4.5-4.5 2.016-4.5 4.5-4.5zm.5 8h-1v-.804c-.767-.16-1.478-.689-1.478-1.704h1.022c0 .591.326.886.978.886.817 0 1.327-.915-.167-1.439-.768-.27-1.68-.676-1.68-1.693 0-.796.573-1.297 1.325-1.448v-.798h1v.806c.704.161 1.313.673 1.313 1.598h-1.018c0-.788-.727-.776-.815-.776-.55 0-.787.291-.787.622 0 .247.134.497.957.768 1.056.344 1.663.845 1.663 1.746 0 .651-.376 1.288-1.313 1.448v.788zm6.19-11v-4h-19v13h1.81v-9h17.19z"/></svg>
                    <p>Métodos de pago</p>
                </div>
                <div class="categoria" data-categoria="entregas" id="categoria-entregas">
                    <svg viewbox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" clip-rule="evenodd"><path d="M7 24h-5v-9h5v1.735c.638-.198 1.322-.495 1.765-.689.642-.28 1.259-.417 1.887-.417 1.214 0 2.205.499 4.303 1.205.64.214 1.076.716 1.175 1.306 1.124-.863 2.92-2.257 2.937-2.27.357-.284.773-.434 1.2-.434.952 0 1.751.763 1.751 1.708 0 .49-.219.977-.627 1.356-1.378 1.28-2.445 2.233-3.387 3.074-.56.501-1.066.952-1.548 1.393-.749.687-1.518 1.006-2.421 1.006-.405 0-.832-.065-1.308-.2-2.773-.783-4.484-1.036-5.727-1.105v1.332zm-1-8h-3v7h3v-7zm1 5.664c2.092.118 4.405.696 5.999 1.147.817.231 1.761.354 2.782-.581 1.279-1.172 2.722-2.413 4.929-4.463.824-.765-.178-1.783-1.022-1.113 0 0-2.961 2.299-3.689 2.843-.379.285-.695.519-1.148.519-.107 0-.223-.013-.349-.042-.655-.151-1.883-.425-2.755-.701-.575-.183-.371-.993.268-.858.447.093 1.594.35 2.201.52 1.017.281 1.276-.867.422-1.152-.562-.19-.537-.198-1.889-.665-1.301-.451-2.214-.753-3.585-.156-.639.278-1.432.616-2.164.814v3.888zm3.79-19.913l3.21-1.751 7 3.86v7.677l-7 3.735-7-3.735v-7.719l3.784-2.064.002-.005.004.002zm2.71 6.015l-5.5-2.864v6.035l5.5 2.935v-6.106zm1 .001v6.105l5.5-2.935v-6l-5.5 2.83zm1.77-2.035l-5.47-2.848-2.202 1.202 5.404 2.813 2.268-1.167zm-4.412-3.425l5.501 2.864 2.042-1.051-5.404-2.979-2.139 1.166z"/></svg>
                    <p>Entregas</p>
                </div>
                <div class="categoria" data-categoria="seguridad" id="categoria-seguridad">
                    <svg viewbox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" clip-rule="evenodd"><path d="M12 0c-3.371 2.866-5.484 3-9 3v11.535c0 4.603 3.203 5.804 9 9.465 5.797-3.661 9-4.862 9-9.465v-11.535c-3.516 0-5.629-.134-9-3zm0 1.292c2.942 2.31 5.12 2.655 8 2.701v10.542c0 3.891-2.638 4.943-8 8.284-5.375-3.35-8-4.414-8-8.284v-10.542c2.88-.046 5.058-.391 8-2.701zm5 7.739l-5.992 6.623-3.672-3.931.701-.683 3.008 3.184 5.227-5.878.728.685z"/></svg>
                    <p>Seguridad</p>
                </div>
                <div class="categoria" data-categoria="cuenta" id="categoria-cuenta">
                    <svg viewbox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" clip-rule="evenodd"><path d="M9.484 15.696l-.711-.696-2.552 2.607-1.539-1.452-.698.709 2.25 2.136 3.25-3.304zm0-5l-.711-.696-2.552 2.607-1.539-1.452-.698.709 2.25 2.136 3.25-3.304zm0-5l-.711-.696-2.552 2.607-1.539-1.452-.698.709 2.25 2.136 3.25-3.304zm10.516 11.304h-8v1h8v-1zm0-5h-8v1h8v-1zm0-5h-8v1h8v-1zm4-5h-24v20h24v-20zm-1 19h-22v-18h22v18z"/></svg>
                    <p>Cuenta</p>
                </div>
            </div>
            <br />

            <c:forEach var="p1" items="${cat1}">
                <div class="faq-item">
                    <div class="question">
                        <h2>${p1.getPregunta()}</h2>
                        <div class="icon">+</div>
                    </div>
                    <div class="answer">
                        <p>${p1.getRespuesta()}</p>
                    </div>
                </div>
            </c:forEach>


            <c:forEach var="p2" items="${cat2}">
                <p>${p2.getPregunta()}</p>
                <p>${p2.getRespuesta()}</p>
            </c:forEach>

            <c:forEach var="p3" items="${cat3}">
                <p>${p3.getPregunta()}</p>
                <p>${p3.getRespuesta()}</p>
            </c:forEach>

            <c:forEach var="p4" items="${cat4}">
                <p>${p4.getPregunta()}</p>
                <p>${p4.getRespuesta()}</p>
            </c:forEach>

        </div>

        <script src="<%=request.getContextPath()%>/js/preguntasFrecuentes.js"></script>
    </body>



    <script
        src="https://kit.fontawesome.com/81581fb069.js"
        crossorigin="anonymous"
        >

    </script>

    <script>const categorias = document.querySelectorAll('#categorias .categoria');
        const contenedorPreguntas = document.querySelectorAll('.contenedor-preguntas');
        let categoriaActiva = null;

        categorias.forEach((categoria) => {
            categoria.addEventListener('click', (e) => {
                categorias.forEach((elemento) => {
                    elemento.classList.remove('activa');
                });

                e.currentTarget.classList.toggle('activa');
                categoriaActiva = categoria.dataset.categoria;


                // Activamos el contenedor de preguntas que corresponde
                contenedorPreguntas.forEach((contenedor) => {
                    if (contenedor.dataset.categoria === categoriaActiva) {
                        contenedor.classList.add('activo');
                    } else {
                        contenedor.classList.remove('activo');
                    }
                });
            });
        });</script>
    <script>
        const preguntas = document.querySelectorAll(' .contenedor-pregunta');
        preguntas.forEach((pregunta) => {
            pregunta.addEventListener('click', (e) => {
                e.currentTarget.classList.toggle('activa');

                const respuesta = pregunta.querySelector('.respuesta');
                const alturaRealRespuesta = respuesta.scrollHeight;

                if (!respuesta.style.maxHeight) {
                    // Si esta vacio el maxHeight entonces ponemos un valor.
                    respuesta.style.maxHeight = alturaRealRespuesta + 'px';
                } else {
                    respuesta.style.maxHeight = null;
                }

                // [Opcional] Reiniciamos las demas preguntas
                preguntas.forEach((elemento) => {
                    // Solamente queremos ejecutar el codigo para las preguntas que no 
                    // sean la pregunta a la que le dimos click.
                    if (pregunta !== elemento) {
                        elemento.classList.remove('activa');
                        elemento.querySelector('.respuesta').style.maxHeight = null;
                    }
                });


            });
            });</script>

    <jsp:include page="footer.jsp" />
</html>
