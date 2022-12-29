<jsp:useBean id="attempts" scope="application" type="java.lang.Long"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <style>
        .content {
            position: absolute;
            left: 50%;
            top: 50%;
            -webkit-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
    </style>
</head>

<body style="background: burlywood;">
<c:if test="${not empty param.send}">
    <c:if test="${not empty param.name}">
        <c:set var="name" value="${param.name}" scope="session"/>
    </c:if>
    <c:if test="${not empty param.surname}">
        <c:set var="surname" value="${param.surname}" scope="session"/>
    </c:if>
    <c:if test="${not empty param.email}">
        <c:set var="email" value="${param.email}" scope="session"/>
    </c:if>
</c:if>
<div class="content">
    <form>
        <div class="input-group mb-3">
            <span class="input-group-text">Name</span>
            <input type="text"
                   name="name"
                   class="form-control"
                   aria-label="Sizing example input"
                   aria-describedby="inputGroup-sizing-default">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Surname</span>
            <input type="text"
                   name="surname"
                   class="form-control"
                   aria-label="Sizing example input"
                   aria-describedby="inputGroup-sizing-default">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Email</span>
            <input type="email"
                   name="email"
                   class="form-control"
                   aria-label="Sizing example input"
                   aria-describedby="inputGroup-sizing-default">
        </div>
        <input class="btn btn-success"
               type="submit"
               name="send"
               value="Надіслати">
    </form>

    <c:if test="${not empty sessionScope.name}">
        <p class="h4">Name: ${sessionScope.name}</p>
    </c:if>
    <c:if test="${not empty sessionScope.surname}">
        <p class="h4">Surname: ${sessionScope.surname}</p>
    </c:if>
    <c:if test="${not empty sessionScope.email}">
        <p class="h4">Email: ${sessionScope.email}</p>
    </c:if>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>