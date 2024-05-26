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
    <title>COMUNICATEC&reg; - Samsung Galaxy S20 Ultra</title>
    <link rel="icon" href="../img/favicon_2.png" /> <!-- Icono del sitio web -->

</head>

<body>

    <?php
    session_start();
    
    require_once '../conectarDB.php';
    $cn = getConexion();

    $sql = "select id, nombre, tipo, precio, stock, cantVendidos, img, urlPHP from producto where tipo like 'android' and nombre like 'Samsung Galaxy S20 Ultra';";
    $registros = mysqli_query($cn, $sql);
    $resultado = null;

    if ($row = mysqli_fetch_assoc($registros)) {
        $resultado = $row;
    }
    ?>

    <?php require_once 'headerAndroid.php'; ?>

    <div class="containerCarac">
        <section class="especificaciones">

            <div class="miniMenu">
                <a href="../VentanaAndroid.php"><i class="fa-solid fa-arrow-left"></i></a>
                <a href="../index.php">Inicio</a> >
                <a href="../VentanaAndroid.php">Android</a>
            </div>

            <div id="container-producto">

            </div>

            <h2 class="animate__animated animate__fadeInDown">Especificaciones Técnicas</h2>
            <hr>
            <ul class="animate__animated animate__fadeInRight">
                <li class="animate__animated animate__fadeIn">Pantalla: 6,9" pulgadas Super AMOLED touchscreen 3200 x 1440 pixeles</li>
                <li class="animate__animated animate__fadeIn">Procesador: Qualcomm snapdragon</li>
                <li class="animate__animated animate__fadeIn">Almacenamiento: 128GB</li>
                <li class="animate__animated animate__fadeIn">Cámara: Cámara posterior de 108 MP y Cámara frontal de 12 MP</li>
                <li class="animate__animated animate__fadeIn">Batería: 5000 mAh (no extraíble) </li>
                <li class="animate__animated animate__fadeIn">Sistema Operativo: Android 10 oneui</li>
                <li class="animate__animated animate__fadeIn">Conectividad: Hasta 5G Sub-6 y mmWave, Wi-Fi 6 (2.4 y 5GHz) MU-MIMO, Bluetooth 5.0, NFC, GPS, Glonass, Beidou, Galileo</li>
                <li class="animate__animated animate__fadeIn">RAM: 16GB</li>
                <li class="animate__animated animate__fadeIn">Color: Gris</li>
            </ul>
        </section>

        <section class="especificaciones">
            <h2 class="animate__animated animate__fadeInUp">Información Adicional</h2>
            <hr>
            <iframe class="animate__animated animate__fadeInUp" src="https://www.youtube.com/embed/1FBSSr1RXmE?si=q_lKURCxBB9rAlP4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
        </section>

    </div>

    <?php require_once 'footerAndroid.php'; ?>

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