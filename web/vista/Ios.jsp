<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Celulares IOS</title>
    <link href="<%=request.getContextPath()%>/css/headerCSS.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/css/footerCSS.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="icon" href="<%=request.getContextPath()%>/img/favicon_2.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" type="text/css"/>
</head>

<jsp:include page="header.jsp" />

<body>       
    <div class="card-body producto">
        <c:forEach var="p" items="${ios}">
            <div class="card">
                <img src="${pageContext.request.contextPath}/img/${p.getImagen()}" class="card-img-top" alt="ios">
                <div class="card-body">
                    <h5 class="card-title">${p.getNombre()}</h5>
                    <p class="card-text">S/.${p.getPrecio()}</p>
                    <a href="#" class="btn btn-primary">AÑADIR</a>
                </div>
            </div>
        </c:forEach>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
<jsp:include page="footer.jsp" />
</html>
