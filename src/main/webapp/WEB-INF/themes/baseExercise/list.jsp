<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

                  </div>
                  <div class="col">
                    <h3 class="text-center my-4 text-uppercase">List of exercises</h3>
                  </div>
                  <div class="col">
                    <div class="dropdown my-4">
                      <button class="form-select" type="button" id="muscleGroupDropDown" data-bs-toggle="dropdown" aria-expanded="false">
                        Filter By Muscle Group
                      </button>
                      <ul class="dropdown-menu" aria-labelledby="muscleGroupDropDown">
                        <li><a class="dropdown-item" href="/exercise/base/list">All</a></li>
                        <c:forEach items="${muscleGroups}" var="muscleGroup">
                          <li><a class="dropdown-item" href="/exercise/base/list/${muscleGroup.id}">${muscleGroup.name}</a></li>
                        </c:forEach>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
              <div class="card-body">
                <div class="row my-1">
                  <div class="col">
                    <div class="card-title">
                      <h6 class="text-center text-uppercase">Name</h6>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card-title">
                      <h6 class="text-center text-uppercase">Muscle group</h6>
                    </div>
                  </div>
                </div>
                <c:forEach items="${baseExercisesToBeShown}" var="exercise">
                  <div class="row">
                    <div class="col">
                      <div class="row">
                        <div class="col">
                          <p class="text-center text-black">${exercise.name}</p>
                        </div>
                        <div class="col">
                          <div class="text-center">
                            <a href="/exercise/base/details/${exercise.id}" class="text-secondary">Show description</a>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col">
                      <p class="text-center text-black">${exercise.muscleGroup.name}</p>
                    </div>
                  </div>
                </c:forEach>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
    <jsp:include page="/WEB-INF/themes/footer.jsp"/>
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
