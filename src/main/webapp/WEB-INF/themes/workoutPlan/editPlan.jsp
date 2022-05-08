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
                                    <div class="col-2">
                                        <a class="btn btn-dark text-decoration-none text-white my-4"
                                           href="/plan/edit/name/${workoutPlanToEdit.id}"
                                           role="button">
                                            Edit Plan's Name
                                            <span class="sb-nav-link-icon"><i class="bi bi-pen"></i>
                                            </span>
                                        </a>
                                    </div>
                                    <div class="col">
                                        <h3 class="text-center my-4 text-uppercase">${workoutPlanToEdit.name}</h3>
                                    </div>
                                    <div class="col-2">

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center my-4">
                    <div class="col">
                        <div class="card">
                            <div class="card-header">
                                <div class="row d-flex justify-content-center">
                                    <div class="col-2">

                                    </div>
                                    <div class="col">
                                        <h5 class="text-center my-2 text-uppercase">Training days</h5>
                                    </div>
                                    <div class="col-2 d-flex justify-content-center align-items-end">
                                        <a class="btn btn-dark text-decoration-none text-white text-capitalize my-2"
                                           href="/tday/add/${workoutPlanToEdit.id}" role="button">
                                            add training day <span class="sb-nav-link-icon"><i
                                                class="bi bi-plus-square"></i>
                                            </span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <c:choose>
                                <c:when test="${not empty workoutPlanToEdit.trainingDays}">
                                    <div class="row row-cols-3 d-flex justify-content-start">
                                        <c:forEach items="${workoutPlanToEdit.trainingDays}" var="tday"
                                                   varStatus="loop">
                                            <div class="col px-3">
                                                <div class="card my-2">
                                                    <div class="card-body">
                                                        <div class="row d-flex align-items-center">
                                                            <div class="col-3">
                                                                <a class="btn btn-dark text-decoration-none text-white"
                                                                   href="/tday/edit/${tday.id}" role="button">
                                                                    Edit <span class="sb-nav-link-icon"><i
                                                                        class="bi bi-pen"></i></span>
                                                                </a>
                                                            </div>
                                                            <div class="col-6 text-center">
                                                                <h3 class="card-title">${tday.name}</h3>
                                                            </div>
                                                            <div class="col-3 d-flex justify-content-end">
                                                                <a class="text-decoration-none align-self-end"
                                                                   href="/tday/delete/${tday.id}" role="button">
                                                                            <span class="sb-nav-link-icon fs-3" style="color: darkred"><i
                                                                                    class="bi bi-x-circle-fill"></i></span>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <ul class="list-group list-group-flush">
                                                        <li class="list-group-item text-center"><b>EXERCISES</b></li>
                                                        <c:forEach items="${tday.exercises}" var="exercise">
                                                            <li class="list-group-item text-center">
                                                                <div class="row">
                                                                    <div class="col-3">

                                                                    </div>
                                                                    <div class="col-6 text-center">
                                                                        ${exercise.name}
                                                                    </div>
                                                                    <div class="col-3">
                                                                        <span class="align-self-end text-secondary">(${exercise.muscleGroup.name})</span>
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
                                                <span class="h6 my-2 text-center">You haven't added any training days in this
                                                plan yet. Add new one by clicking on the button below.
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row my-4 mx-2 d-flex justify-content-center">
                                        <div class="col">
                                            <div class="col d-flex justify-content-center">
                                                <button type="button" class="btn btn-dark">
                                                    <a href="/tday/add/${workoutPlanToEdit.id}" class="text-white">Add
                                                        Training Day</a>
                                                </button>
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
