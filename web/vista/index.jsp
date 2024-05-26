
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link href="../css/headerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="../css/footerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="../css/indexCSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="icon" href="../img/favicon_2.png" />
    </head>
    <jsp:include page="header.jsp" />
    <body>
        <main>

            <section class="bannerPrincipal"> <!-- Banner de bienvenida -->
                <h1 class="tituloPrincipal">BIENVENIDO A
                    <br> COMUNICATEC
                </h1>
                <img src="../img/fondo.png" alt="Fondo">
            </section>

            <h1 class="vendido-top">
                LOS CELULARES MÁS VENDIDOS
            </h1>


            <div class="Vendido">
                <div class="tab_header">
                    <label class="active"><button class="tab_btn">IOS</button></label>
                    <label><button class="tab_btn">Android</button></label>
                </div>

                <div class="celularesTOP">
                    <div class="contenidoProductos active">
                        <section id="productos-IOS"></section>
                    </div>
                    <div class="contenidoProductos">
                        <section id="productos-Android"></section>
                    </div>
                </div>
            </div>
        </main>
        <script>
            var celularesTopIOS = <?php echo json_encode($resultadoIOS); ?>;
            var celularesTopAndroid = <?php echo json_encode($resultadoAndroid); ?>;
        </script>
    </body>
    <jsp:include page="footer.jsp" />
</html>
