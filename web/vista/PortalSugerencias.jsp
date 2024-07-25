<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Sugerencias</title>
        <link href="${pageContext.request.contextPath}/css/headerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/css/footerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/css/portalSugerenciasCSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="icon" href="${pageContext.request.contextPath}/img/favicon_2.png" />
    </head>
    <jsp:include page="header.jsp" />
    <body>
        <div class="containerPS">
            <c:if test="${not empty mensaje}">
                <p style="color: green">${mensaje}</p>
            </c:if>
            <c:if test="${not empty error}">
                <p style="color: red">${error}</p>
            </c:if>
            <div class="containerPS">
                <form id="sugerenciasForm" action="<%= request.getContextPath()%>/SVPortalSugerencias" method="post" enctype="multipart/form-data">
                    <fieldset>
                        <legend>Portal de Sugerencias</legend>
                        <select name="Documentos">
                            <option value="d" selected>DNI</option>
                            <option value="c">Carnet de Identidad</option>
                        </select>

                        <input type="text" name="NroDoc" placeholder="Número de Documento *" required title="Número de Documento *" pattern="[0-9]+" maxlength="8" />

                        <input type="text" name="PrimerNombre" placeholder="Primer Nombre *" required title="Primer Nombre *" />

                        <input type="text" name="SegundoNombre" placeholder="Segundo Nombre *" required title="Segundo Nombre *" />

                        <input type="text" name="PrimerApellido" placeholder="Primer Apellido *" required title="Primer Apellido *" />

                        <input type="text" name="SegundoApellido" placeholder="Segundo Apellido *" required title="Segundo Apellido *" />

                        <input type="text" name="Celular" placeholder="Celular *" required title="Celular *" pattern="[0-9]+" maxlength="8" />

                        <input type="email" name="Correo" placeholder="Correo *" required title="Correo *" />

                        <label>Observaciones</label>
                        <textarea name="Obs" rows="4" cols="20"></textarea>

                        <div class="input-group">
                            <label for="imagen_reclamante">Adjuntar una imagen: NO debe ser mayor a 2MB</label>
                            <input type="file" id="imagen_reclamante" name="imagen_reclamante" accept="image/*" onchange="mostrarVistaPrevia(this)">
                        </div>

                        <!-- Vista previa de la imagen -->
                        <div class="input-group">
                            <label>Vista Previa de la Imagen:</label><br>
                            <img id="vista_previa" src="#" alt="Vista Previa" style="max-width: 300px; max-height: 300px;">
                        </div>

                        <div class="input-group">
                            <label for="pedido_consumidor">Pedido del consumidor:</label>
                            <textarea id="pedido_consumidor" name="pedido_consumidor" rows="4"></textarea>
                        </div>

                        <input type="submit" value="Enviar" name="accion" />
                    </fieldset>
                </form>
            </div>
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
                                    $('#sugerenciasForm').on('submit', function (e) {
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
    </body>
    <jsp:include page="footer.jsp" />
</html>

