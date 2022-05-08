<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <title>Workout Planner</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet"/>
    <link href="/resources/css/styles.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
<jsp:include page="/WEB-INF/themes/header.jsp"/>
<div id="layoutSidenav">
    <jsp:include page="/WEB-INF/themes/sidenav.jsp"/>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid">
                <div class="row justify-content-center my-4">
                    <div class="col">
                        <div class="card">
                            <div class="card-header">
                                <div class="row">
                                    <div class="col">
                                        <h3 class="text-center my-4 text-uppercase">All workout plans</h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center my-4">
                    <div class="col">
                        <div class="card">
                            <c:choose>
                                <c:when test="${not empty allPlans}">
                                    <div class="row row-cols-3 d-flex justify-content-start">
                                        <c:forEach items="${allPlans}" var="plan">
                                            <div class="col px-3">
                                                <div class="card my-2">
                                                    <div class="card-body">
                                                        <div class="row d-flex align-items-center">
                                                            <div class="col-4 my-1">
                                                                <c:if test="${not plan.active}">
                                                                    <a class="btn btn-dark text-decoration-none text-white"
                                                                       href="/plan/active/${plan.id}" role="button">
                                                                        Make Active <span class="sb-nav-link-icon"><i
                                                                            class="bi bi-check-lg"></i></span>
                                                                    </a>
                                                                </c:if>
                                                            </div>
                                                            <div class="col-4 text-center my-1">
                                                                <h3 class="card-title">${plan.name}</h3>
                                                            </div>
                                                            <div class="col-4 my-1 d-flex justify-content-end align-content-end">
                                                                <c:choose>
                                                                    <c:when test="${plan.active}">
                                                                        <div class="alert alert-success my-0 p-2" role="alert">
                                                                            Active <span class="sb-nav-link-icon">
                                                                        <i class="bi bi-check-lg">
                                                                        </i>
                                                                    </span>
                                                                        </div>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <a class="text-decoration-none align-self-end"
                                                                           href="/plan/delete/${plan.id}" role="button">
                                                                            <span class="sb-nav-link-icon fs-2" style="color: darkred"><i
                                                                                class="bi bi-x-circle-fill"></i></span>
                                                                        </a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <ul class="list-group list-group-flush">
                                                        <li class="list-group-item text-center"><b>TRAINING DAYS</b></li>
                                                        <c:forEach items="${plan.trainingDays}" var="tday">
                                                            <li class="list-group-item text-center">
                                                                <div class="row">
                                                                    <div class="col-6 text-center">
                                                                        ${tday.name}
                                                                    </div>
                                                                    <div class="col-6">
                                                                        <span class="align-self-end">Exercises: ${tday.exercises.size()}</span>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="row mx-2 d-flex justify-content-center">
                                        <div class="col">
                                            <div class="row my-2">
                                                <span class="h6 my-2 text-center">No plans created yet. Add new one by choosing correct option
                                    from the list in the sidebar.
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="/WEB-INF/themes/footer.jsp"/>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="/resources/js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="/resources/assets/demo/chart-area-demo.js"></script>
<script src="/resources/assets/demo/chart-bar-demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="/resources/js/datatables-simple-demo.js"></script>

</body>
</html>
