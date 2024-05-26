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
    <title>COMUNICATEC&reg; - Xiaomi 13T</title>
    <link rel="icon" href="../img/favicon_2.png" /> <!-- Icono del sitio web -->

</head>

<body>

    <?php
    session_start();
    
    require_once '../conectarDB.php';
    $cn = getConexion();

    $sql = "select id, nombre, tipo, precio, stock, cantVendidos, img, urlPHP from producto where tipo like 'android' and nombre like 'Xiaomi 13T';";
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
                <li class="animate__animated animate__fadeIn">Pantalla: 6.7" Pulgadas Amoled Resolución FullHD+ (2.712 x 1.220 píxeles)</li>
                <li class="animate__animated animate__fadeIn">Procesador: MediaTek Dimensity 8200-Ultra</li>
                <li class="animate__animated animate__fadeIn">Almacenamiento: 256GB</li>
                <li class="animate__animated animate__fadeIn">Cámara: Cámara principal de 50MP+ 12MP y Cámara frontal de 20MP</li>
                <li class="animate__animated animate__fadeIn">Batería: 5000mAh</li>
                <li class="animate__animated animate__fadeIn">Sistema Operativo: </li>
                <li class="animate__animated animate__fadeIn">Conectividad: </li>
                <li class="animate__animated animate__fadeIn">RAM: 12GB</li>
                <li class="animate__animated animate__fadeIn">Color: Celeste</li>
            </ul>
        </section>

        <section class="especificaciones">
            <h2 class="animate__animated animate__fadeInUp">Información Adicional</h2>
            <hr>
            <iframe class="animate__animated animate__fadeInUp" src="https://www.youtube.com/embed/MDZx2esb-JU?si=kZN33bfrX7nHC_YR" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
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