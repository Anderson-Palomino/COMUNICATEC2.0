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
    <title>COMUNICATEC&reg; - iPhone 15 Pro Max</title>
    <link rel="icon" href="../img/favicon_2.png" /> <!-- Icono del sitio web -->

</head>

<body>

    <?php
    session_start();
    
    require_once '../conectarDB.php';
    $cn = getConexion();

    $sql = "select id, nombre, tipo, precio, stock, cantVendidos, img, urlPHP from producto where tipo like 'ios' and nombre like 'iPhone 15 Pro Max';";
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
                <li class="animate__animated animate__fadeIn">Pantalla: Super Retina XDR OLED de 6,1 pulgadas</li>
                <li class="animate__animated animate__fadeIn">Procesador: A17 Pro</li>
                <li class="animate__animated animate__fadeIn">Almacenamiento: 128, 256, 512 GB y 1 TB</li>
                <li class="animate__animated animate__fadeIn">Cámara: Triple cámara, Cámara principal de 48 megapíxeles, Cámara teleobjetivo de 12 megapíxeles con zoom óptico 3x, Cámara ultra gran angular de 12 megapíxeles</li>
                <li class="animate__animated animate__fadeIn">Batería: 29 horas de reproducción de vídeo</li>
                <li class="animate__animated animate__fadeIn">Sistema Operativo: iOS 17</li>
                <li class="animate__animated animate__fadeIn">Conectividad: 5G, Wi-Fi 6, Bluetooth 5.2</li>
                <li class="animate__animated animate__fadeIn">Seguridad: Face ID para desbloqueo facial</li>
                <li class="animate__animated animate__fadeIn">Colores: Titanio negro, titanio blanco, titanio azul y titanio natural</li>
            </ul>
        </section>

        <section class="especificaciones">
            <h2 class="animate__animated animate__fadeInUp">Información Adicional</h2>
            <hr>
            <iframe src="https://www.youtube.com/embed/jBIUeiNsQks?si=UQFJNvcX7f2CSjK4" frameborder="0" allowfullscreen class="animate__animated animate__fadeInUp"></iframe>
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