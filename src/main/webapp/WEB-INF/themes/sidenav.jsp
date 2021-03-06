<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 26.04.2022
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <a class="nav-link" href="/home/active">
                    <div class="sb-nav-link-icon"><i class="bi bi-chevron-double-right"></i></div>
                    View Active Plan
                </a>
                <a class="nav-link" href="/home/active/edit">
                    <div class="sb-nav-link-icon"><i class="bi bi-chevron-double-right"></i></div>
                    Edit Active Plan
                </a>
                <a class="nav-link" href="/plan/add">
                    <div class="sb-nav-link-icon"><i class="bi bi-chevron-double-right"></i></div>
                    Add New Plan
                </a>
                <a class="nav-link" href="/home/list">
                    <div class="sb-nav-link-icon"><i class="bi bi-chevron-double-right"></i></div>
                    All Workout Plans
                </a>
                <div class="sb-sidenav-menu-heading">Exercises</div>
                <a class="nav-link" href="/exercise/add">
                    <div class="sb-nav-link-icon"><i class="bi bi-chevron-double-right"></i></div>
                    Add Exercise
                </a>
                <a class="nav-link" href="/exercise/list">
                    <div class="sb-nav-link-icon"><i class="bi bi-chevron-double-right"></i></div>
                    All Exercises
                </a>
            </div>
        </div>
    </nav>
</div>
