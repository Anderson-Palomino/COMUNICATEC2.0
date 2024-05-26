<header class="containerHeader">
    <a href="../index.php" class="logoMenu">
        <img src="../img/logo.png" alt="Logo." /> <!-- Logotipo -->
    </a>

    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
        <i class='fa fa-bars'></i>
    </label>

    <a href="../CarroCompra.php" class="carrito"><i class="fa-solid fa-cart-shopping" id=carritologo></i><span id="cuenta-carrito">0</span></a>

    <?php
    // Verificar si la sesión está iniciada
    if (isset($_SESSION['usuario'])) {
        echo '<ul class="usuario">
                <li><a href="#">Hola, ' . $_SESSION['usuario'] . '</a>';
        echo '      <ul class="menuUsuario">
                        <li><a href="#">Mis compras</a>
                        <li><a href="../cerrarSesion.php">Cerrar sesión</a>
                    </ul>
                </li>
            </ul>';
    } else {
        echo '<div class="login">
                <a href="../Ingresar.php"><button>Ingresar</button>
                </a>';
        echo '  <a href="../Registrarse.php"><button>Registrarse</button>
                </a>
            </div>';
    }
    ?>

    <nav class="navegador"> <!-- Barra de navegación -->
        <ul class="menu">
            <li><a href="../index.php">Inicio</a></li>
            <li>
                <a href="#" id="submenubtn">Celulares <i class="fa-solid fa-chevron-down"></i></a>
                <ul class="submenu">
                    <li><a href="../VentanaIOS.php">IOS</a></li>
                    <li><a href="../VentanaAndroid.php">Android</a></li>
                </ul>
            </li>
            <li><a href="../Contactanos.php">Contactanos</a></li>
            <li><a href="../Nosotros.php">Nosotros</a></li>
        </ul>
    </nav> <!-- Fin de la barra de navegación -->
    <script src="../js/menu.js"></script>

</header>