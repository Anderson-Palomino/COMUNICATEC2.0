<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libro de Reclamaciones</title>
        <link href="${pageContext.request.contextPath}/css/headerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/css/footerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/css/libroReclamacionesCSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="icon" href="${pageContext.request.contextPath}/img/favicon_2.png" />
        <script>
            // Función para mostrar la vista previa de la imagen seleccionada
            function mostrarVistaPrevia(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        document.getElementById('vista_previa').setAttribute('src', e.target.result);

                        reader.readAsDataURL(input.files[0]);

                    }
        </script>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="containerLR">
            <c:if test="${not empty mensaje}">
                <p style="color: green">${mensaje}</p>
            </c:if>
            <c:if test="${not empty error}">
                <p style="color: red">${error}</p>
            </c:if>
            <h1>Libro de Reclamaciones</h1>
            <!-- Formulario de reclamación -->
            <form action="${pageContext.request.contextPath}/RegistrarReclamacionServlet" method="post" enctype="multipart/form-data">
                <!-- Identificación del consumidor reclamante -->
                <h2>Identificación del consumidor reclamante</h2>
                <div class="input-group">
                    <label for="primer_nombre">Primer Nombre:</label>
                    <input type="text" id="primer_nombre" name="primer_nombre" required>
                </div>

                <div class="input-group">
                    <label for="segundo_nombre">Segundo Nombre:</label>
                    <input type="text" id="segundo_nombre" name="segundo_nombre">
                </div>

                <div class="input-group">
                    <label for="apellido_paterno">Apellido Paterno:</label>
                    <input type="text" id="apellido_paterno" name="apellido_paterno" required>
                </div>

                <div class="input-group">
                    <label for="apellido_materno">Apellido Materno:</label>
                    <input type="text" id="apellido_materno" name="apellido_materno" required>
                </div>

                <div class="input-group">
                    <label for="domicilio">Domicilio:</label>
                    <input type="text" id="domicilio" name="domicilio" required>
                </div>

                <div class="input-group">
                    <label for="departamento">Departamento:</label>
                    <input type="text" id="departamento" name="departamento" required>
                </div>

                <div class="input-group">
                    <label for="provincia">Provincia:</label>
                    <input type="text" id="provincia" name="provincia" required>
                </div>

                <div class="input-group">
                    <label for="distrito">Distrito:</label>
                    <input type="text" id="distrito" name="distrito" required>
                </div>

                <div class="input-group">
                    <label for="dni">DNI:</label>
                    <input type="number" id="dni" name="dni" required>
                </div>

                <div class="input-group">
                    <label for="telefono">Teléfono:</label>
                    <input type="tel" id="telefono" name="telefono" required>
                </div>

                <div class="input-group">
                    <label for="correo">Correo Electrónico:</label>
                    <input type="email" id="correo" name="correo" required>
                </div>

                <div class="input-group">
                    <input type="checkbox" id="menor" name="menor">
                    <label for="menor">Soy menor de edad</label>
                </div>

                <!-- Identificación del bien contratado -->
                <h2>Identificación del bien contratado</h2>
                <div class="input-group">
                    <label for="tipo_bien_contratado">Tipo de bien contratado:</label>
                    <select id="tipo_bien_contratado" name="tipo_bien_contratado" required>
                        <option value="Producto">Producto</option>
                        <option value="Servicio">Servicio</option>
                    </select>
                </div>

                <div class="input-group">
                    <label for="monto_reclamo">Monto del reclamo:</label>
                    <input type="number" id="monto_reclamo" name="monto_reclamo" required>
                </div>

                <!-- Detalle de la reclamación -->
                <h2>Detalle de la reclamación</h2>
                <div class="input-group">
                    <label for="tipo_reclamo">Tipo de reclamo:</label>
                    <select id="tipo_reclamo" name="tipo_reclamo" required>
                        <option value="Reclamo">Reclamo</option>
                        <option value="Queja">Queja</option>
                    </select>
                </div>

                <div class="input-group">
                    <label for="descripcion">Descripción:</label>
                    <textarea id="descripcion" name="descripcion" rows="4" required></textarea>
                </div>

                <div class="input-group">
                    <label for="imagen_reclamante">Adjuntar una imagen (no mayor a 2MB):</label>
                    <input type="file" id="imagen_reclamante" name="imagen_reclamante" accept="image/*" onchange="mostrarVistaPrevia(this);">
                </div>

                <!-- Vista previa de la imagen -->
                <div class="input-group">
                    <label>Vista Previa de la Imagen:</label>
                    <img id="vista_previa" src="#" alt="Vista Previa" style="max-width: 300px; max-height: 300px;">
                </div>

                <div class="input-group">
                    <label for="pedido_consumidor">Pedido del consumidor:</label>
                    <textarea id="pedido_consumidor" name="pedido_consumidor" rows="4"></textarea>
                </div>

                <!-- Observaciones y acciones adoptadas por el proveedor -->
                <h2>Observaciones y acciones adoptadas por el proveedor</h2>
                <p>ComunicaTEC dará respuesta a su reclamo en un plazo no mayor de quince (15) días hábiles mediante correo electrónico o mediante una carta que se enviará a su domicilio.</p>

                <!-- Declaración -->
                <h2>Todos los campos son obligatorios.</h2>
                <h2>DECLARACIÓN</h2>
                <p class="declaracion">
                    En aplicación a lo dispuesto por la Ley 29733 – Ley de Protección de datos personales y su Reglamento aprobado por D.S. N° 003-2013-JUS, el suscrito titular de los datos personales, mediante el llenado del presente formulario, autorizo de forma expresa e inequívoca y por tiempo indefinido que mis datos personales, sean tratados, almacenados, sistematizados y utilizados por ComunicaTEC, para fines estadísticos y administrativos, con el propósito de poder brindarme adecuada y oportunamente el servicio que he contratado o que me interese contratar, siendo que los datos serán conservados en un banco de datos cuyo titular es ComunicaTEC. Igualmente declaro conocer que para ejercer mis derechos como acceso, rectificación, cancelación y oposición y otros derechos sobre mis datos, puedo dirigirme a las oficinas ubicadas en Av. Angamos Oeste 120, Miraflores y/o al e-mail comunicatec@gmail.com. Declaro conocer los alcances de la Ley 29733 y su Reglamento, para ejercer mis derechos conforme a Ley.
                </p>

                <div class="input-group">
                    <label for="respuesta_direccion">Deseo recibir la respuesta en mi dirección física:</label>
                    <input type="checkbox" id="respuesta_direccion" name="respuesta_direccion" value="Si">
                </div>

                <div class="input-group">
                    <input type="submit" value="Enviar Reclamación" name="accion">
                </div>
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>
                                function mostrarVistaPrevia(input) {
                                    if (input.files && input.files[0]) {
                                        const reader = new FileReader();
                                        reader.onload = function (e) {
                                            document.getElementById('vista_previa').src = e.target.result;
                                        }
                                        reader.readAsDataURL(input.files[0]);
                                    }
                                }

                                $(document).ready(function () {
                                    $('#reclamacionForm').on('submit', function (e) {
                                        e.preventDefault(); // Prevent form submission

                                        // Create a FormData object and append all form inputs
                                        const formData = new FormData(this);

                                        $.ajax({
                                            url: $(this).attr('action'), // Form action URL
                                            type: $(this).attr('method'), // Form method
                                            data: formData,
                                            processData: false,
                                            contentType: false,
                                            success: function (response) {
                                                alert('Reclamación enviada exitosamente.');
                                                console.log(response); // Debug server response
                                            },
                                            error: function (xhr, status, error) {
                                                alert('Hubo un error al enviar la reclamación: ' + error);
                                                console.log(xhr, status, error); // Debug AJAX error
                                            }
                                        });
                                    });
                                   });
        </script>
        <jsp:include page="footer.jsp" />
    </body>
</html>