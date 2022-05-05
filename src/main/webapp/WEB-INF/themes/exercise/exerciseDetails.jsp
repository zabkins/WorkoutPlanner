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
                    <h3 class="text-center my-4 text-uppercase">Exercise description</h3>
                  </div>
                  <div class="col align-items-end">
                      <a class="btn btn-dark my-4" href="/exercise/list" role="button">Back to list</a>
                  </div>
                </div>
              </div>
              <div class="card-body">
                <div class="row mt-3">
                  <div class="col">
                    <div class="row my-2">
                        <div class="col card-title">
                          <h6 class="text-center text-uppercase">Name</h6>
                        </div>
                        <div class="col">
                          <p>${exerciseToDetail.name}</p>
                        </div>
                    </div>
                    <div class="row my-2">
                      <div class="col card-title">
                        <h6 class="text-center text-uppercase">Muscle group</h6>
                      </div>
                      <div class="col">
                        <p>${exerciseToDetail.muscleGroup.name}</p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="row mt-2">
                      <div class="card-title justify-content-start">
                        <h6 class="text-uppercase">Description</h6>
                      </div>
                    </div>
                    <div class="row">
                      <p class="text-break">${exerciseToDetail.description}</p>
                    </div>
                  </div>
                </div>
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
