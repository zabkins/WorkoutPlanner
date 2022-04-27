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
                <h3 class="text-center my-4 text-uppercase">Add new exercise</h3>
              </div>
              <div class="card-body">
                <form:form modelAttribute="baseExercise" action="/exercise/base/add" method="post">
                  <div class="row">
                    <div class="col">
                      <div class="row">
                        <div class="form-label">
                          <h5 class="my-1 text-center">Exercise name</h5>
                        </div>
                      </div>
                      <div class="row">
                        <div class="form-label">
                          <form:input path="name" cssClass="form-control justify-content-center"/>
                          <form:errors path="name" cssClass="alert-danger"/>
                        </div>
                      </div>
                    </div>
                    <div class="col">
                      <div class="row">
                        <div class="form-label">
                          <h5 class="my-1 text-center">Muscle group</h5>
                        </div>
                        <div class="row">
                          <div class="form-label">
                            <form:select path="muscleGroup" items="${muscleGroups}" itemValue="id" itemLabel="name" cssClass="form-select justify-content-center"/>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col mt-4 m-lg-2">
                      <div class="row">
                        <input type="submit" class="btn btn-dark text-white" value="Add"/>
                      </div>
                    </div>
                    <div class="col mt-4 m-lg-2">
                      <div class="row">
                        <a class="btn btn-dark" href="/home" role="button">Cancel</a>
                      </div>
                    </div>
                  </div>
                </form:form>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card">
              <div class="card-header">
                <h3 class="text-center my-4 text-uppercase">List of exercises</h3>
              </div>
              <div class="card-body">

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
