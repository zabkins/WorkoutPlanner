<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Workout Planner</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="/resources/css/styles.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="header.jsp"/>
        <div id="layoutSidenav">
            <jsp:include page="sidenav.jsp"/>
            <div id="layoutSidenav_content">
                <main>
                <div class="container-fluid">
                    <div class="row">
                        <div class="d-flex justify-content-center">
                            <h1 class="text-uppercase">Current workout plan's name</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="d-flex justify-content-center">
                            <h5 class="text-secondary">Current Workout Plan</h5>
                        </div>
                    </div>
                    <div class="row align-items-center">
                        <%-- TU PETLA W ZALEZNOSCI OD ILOSCI DNI TRENINGOWYCH --%>
                        <c:forEach begin="1" end="5" varStatus="loop">
                            <div class="col">
                                <div class="card">
                                    <div class="card-body">
                                        <h3 class="card-title">Training day ${loop.index}</h3>
                                    </div>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Exercise 1</li>
                                        <li class="list-group-item">Exercise 2</li>
                                        <li class="list-group-item">Exercise 3</li>
                                        <li class="list-group-item">Exercise 4</li>
                                        <li class="list-group-item">Exercise 5</li>
                                        <li class="list-group-item">Exercise 6</li>
                                        <li class="list-group-item">Exercise 7</li>
                                    </ul>
                                    <div class="card-body">
                                        <button type="button" class="btn btn-dark">
                                            <a href="#" class="text-white">Save results</a>
                                        </button>
                                        <button type="button" class="btn btn-dark">
                                            <a href="#" class="text-white">Modify Exercises</a>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                </main>
                <jsp:include page="footer.jsp"/>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="/resources/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="/resources/assets/demo/chart-area-demo.js"></script>
        <script src="/resources/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="/resources/js/datatables-simple-demo.js"></script>
    </body>
</html>
