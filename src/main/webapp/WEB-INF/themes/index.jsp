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
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.html">Workout Planner</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar-->
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Actions</div>
                            <a class="nav-link" href="/home">
                                <div class="sb-nav-link-icon"><i class="bi bi-chevron-double-right"></i></div>
                                Homepage
                            </a>
                            <div class="sb-sidenav-menu-heading">Workout Plans</div>
                            <a class="nav-link" href="/home">
                                <div class="sb-nav-link-icon"><i class="bi bi-chevron-double-right"></i></div>
                                Current Workout Plan
                            </a>
                            <a class="nav-link" href="/home">
                                <div class="sb-nav-link-icon"><i class="bi bi-chevron-double-right"></i></div>
                                All Workout Plans
                            </a>
                            <a class="nav-link" href="/home">
                                <div class="sb-nav-link-icon"><i class="bi bi-chevron-double-right"></i></div>
                                Add Workout Plan
                            </a>
                            <a class="nav-link" href="/home">
                                <div class="sb-nav-link-icon"><i class="bi bi-chevron-double-right"></i></div>
                                Edit Workout Plan
                            </a>
                            <div class="sb-sidenav-menu-heading">Exercises</div>
                            <a class="nav-link" href="/home">
                                <div class="sb-nav-link-icon"><i class="bi bi-chevron-double-right"></i></div>
                                Add new exercise
                            </a>
                            <a class="nav-link" href="/home">
                                <div class="sb-nav-link-icon"><i class="bi bi-chevron-double-right"></i></div>
                                Show all exercises
                            </a>
                        </div>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>


                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-center small">
                            <div class="text-muted">Copyright &copy; Michał Żarczyński 2022 </div>
                        </div>
                    </div>
                </footer>
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
