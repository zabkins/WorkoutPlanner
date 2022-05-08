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

                  </div>
                  <div class="col">
                    <h3 class="text-center my-4 text-uppercase">${trainingDayToDelete.name}</h3>
                  </div>
                  <div class="col-2 d-flex justify-content-end">
                    <a class="btn btn-dark text-decoration-none text-white my-4"
                       href="/tday/redirect/${trainingDayToDelete.id}" role="button">
                      Back to plan
                      <span class="sb-nav-link-icon"><i class="bi bi-back"></i>
                                            </span>
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="row justify-content-center my-4">
          <div class="col-5">
            <div class="card">
              <div class="card-header">
                <h5 class="text-center my-2">Confirm Deletion</h5>
              </div>
              <div class="card-body">
                  <div class="row my-2">
                    <span class="text-center">
                        Are you sure you want to delete this training day from the plan?
                    </span>
                  </div>
                  <div class="row my-4">
                      <div class="col d-flex justify-content-center">
                          <a class="btn btn-dark text-decoration-none text-white mt-2"
                             href="/tday/delete/confirm/${trainingDayToDelete.id}" role="button">
                              Confirm
                              <span class="sb-nav-link-icon">
                                  <i class="bi bi-check-circle"></i>
                              </span>
                          </a>
                      </div>
                      <div class="col d-flex justify-content-center">
                          <a class="btn btn-dark text-decoration-none text-white mt-2"
                             href="/tday/redirect/${trainingDayToDelete.id}" role="button">
                              Cancel
                              <span class="sb-nav-link-icon">
                                  <i class="bi bi-backspace"></i>
                              </span>
                          </a>
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
