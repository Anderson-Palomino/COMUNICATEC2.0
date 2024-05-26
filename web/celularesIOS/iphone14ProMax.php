<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/headerCSS.css" />
    <link rel="stylesheet" type="text/css" href="../css/caracteristicasCelulares.css">
    <link rel="stylesheet" type="text/css" href="../css/footerCSS.css">
    <script src="../js/ventanaCaracteristicas.js" defer></script>
    <script src="../js/carritoService.js" defer></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    <title>COMUNICATEC&reg; - iPhone 14 Pro Max</title>
    <link rel="icon" href="../img/favicon_2.png" /> <!-- Icono del sitio web -->

</head>

<body>

    <?php
    session_start();
    
    require_once '../conectarDB.php';
    $cn = getConexion();

    $sql = "select id, nombre, tipo, precio, stock, cantVendidos, img, urlPHP from producto where tipo like 'ios' and nombre like 'iPhone 14 Pro Max';";
    $registros = mysqli_query($cn, $sql);
    $resultado = null;

    if ($row = mysqli_fetch_assoc($registros)) {
        $resultado = $row;
    }
    ?>

    <?php require_once 'headerIOS.php'; ?>

    <div class="containerCarac">
        <section class="especificaciones">

            <div class="miniMenu">
                <a href="../VentanaIOS.php"><i class="fa-solid fa-arrow-left"></i></a>
                <a href="../index.php">Inicio</a> >
                <a href="../VentanaIOS.php">IOS</a>
            </div>

            <div id="container-producto">
                
            </div>

            <h2 class="animate__animated animate__fadeInDown">Especificaciones Técnicas</h2>
            <hr>
            <ul class="animate__animated animate__fadeInRight">
                <li class="animate__animated animate__fadeIn">Pantalla: 6.7" pulgadas OLED 2796 x 1290 pixeles</li>
                <li class="animate__animated animate__fadeIn">Procesador: Chip A16 Bionic</li>
                <li class="animate__animated animate__fadeIn">Almacenamiento: 256GB</li>
                <li class="animate__animated animate__fadeIn">Cámara: Cámara Principal de 48+12+12MP y Cámara Frontal de 12MP</li>
                <li class="animate__animated animate__fadeIn">Batería: 4323 mAh</li>
                <li class="animate__animated animate__fadeIn">Sistema Operativo: iOS 16</li>
                <li class="animate__animated animate__fadeIn">Conectividad: 2G, 3G, 4G LTE, 5G, NFC, GPS, WiFi, Hotspot/módem, EDGE, Bluetooth y Acceso a web</li>
                <li class="animate__animated animate__fadeIn">RAM: 6GB</li>
                <li class="animate__animated animate__fadeIn">Color: Dorado</li>
            </ul>
        </section>

        <section class="especificaciones">
            <h2 class="animate__animated animate__fadeInUp">Información Adicional</h2>
            <hr>
            <iframe class="animate__animated animate__fadeInUp" src="https://www.youtube.com/embed/wfBnX_lbBQM?si=-2hubD_etdp-ahiY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen ></iframe>
        </section>

    </div>

    <?php require_once 'footerIOS.php'; ?>

    <script>
        var celular = {
            id: '<?php echo $resultado['id']; ?>',
            nombre: '<?php echo $resultado['nombre']; ?>',
            tipo: '<?php echo $resultado['tipo']; ?>',
            precio: '<?php echo $resultado['precio']; ?>',
            stock: <?php echo $resultado['stock']; ?>,
            cantVendidos: '<?php echo $resultado['cantVendidos']; ?>',
            img: '<?php echo $resultado['img']; ?>',
            urlPHP: '<?php echo $resultado['urlPHP']; ?>',
        };
    </script>

</body>

</html>