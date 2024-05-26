
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal de sugerencias</title>
        <link href="../css/headerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="../css/footerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="../css/portalSugerenciasCSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="icon" href="../img/favicon_2.png" />
    </head>
    <jsp:include page="header.jsp" />
    <body>   


        <div class="containerPS">
            <form action="./SVPortalSugerencias" method="post" enctype="multipart/form-data">

                <fieldset>
                    <legend>Portal de Sugerencias</legend>
                    <select name="Documentos">
                        <option value="d" selected>DNI</option>
                        <option value="c">Carnet de Identidad</option>
                       
                        <input 
                            type="text" 
                            name="NroDoc" 
                            placeholder="Primer Nombre*" 
                            required title="Primer Nombre *" 
                            pattern="{0-9}+" 
                            maxlength="8"
                            />
                        <input 
                            type="text" 
                            name="NroDoc" 
                            placeholder="Segundo Nombre *" 
                            required title="Segundo Nombre *" 
                            pattern="{0-9}+" 
                            maxlength="8" 
                            />
                        <input 
                            type="text" 
                            name="NroDoc" 
                            placeholder="Primer Apellido *" 
                            required title="Primer Apellido *" 
                            pattern="{0-9}+" 
                            maxlength="8" 
                            />
                        <input 
                            type="text" 
                            name="NroDoc" 
                            placeholder="Segundo Apellido *" 
                            required title="Segundo Apellido *" 
                            pattern="{0-9}+" 
                            maxlength="8" 
                            />
                        <input 
                            type="text" 
                            name="Celular" 
                            placeholder="Celular *" 
                            required title="Celular *" 
                            pattern="{0-9}+" 
                            maxlength="8" 
                            />
                        <input 
                            type="text" 
                            name="Correo" 
                            placeholder="Correo *" 
                            required title="Correo *"
                            pattern="{0-9}+" 
                            maxlength="8" />
                        <label>Observaciones</label>
                        <textarea name="Obs" rows="4" cols="20">
                        </textarea>
                        <div class="input-group">
                            <label for="imagen_reclamante">Adjuntar una imagen:NO debe ser mayor a 2MB</label>
                            <input type="file" id="imagen_reclamante"  accept="image/*">
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

    </body>
    <jsp:include page="footer.jsp" />
</html>
