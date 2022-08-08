<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center bg-success py-2">This is home page</h1>
<div class="ms-5">
    <%--this 2 line use for controller: show username and pass------------------------------------%>
    <h4 class="text-success">Hi ${username}</h4>
    <%--<h5>your role is: ${roles}</h5>--%>

    <%--this two line use for security taglib: show username and pass-----------------------------%>
    <h6>User Name = <security:authentication  property="principal.username"/></h6>
    Roles: <security:authentication property="principal.authorities"/>

    <a href="/user/create" class="btn btn-primary my-2">Create user</a>

        <div class="border border-danger text-center p-5">
            <a href="${pageContext.request.contextPath}/dashboard/admin" class="btn btn-info">Go Admin Dashboard</a>
            <a href="${pageContext.request.contextPath}/dashboard/teacher" class="btn btn-info">Go Teacher Dashboard</a>
            <a href="${pageContext.request.contextPath}/dashboard/student" class="btn btn-info">Go Student Dashboard</a>
        </div>

    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout" class="btn btn-primary my-2"/>
    </form:form>
</div>
</body>
</html>
