<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 6/23/2022
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="row mt-5">
           <div class="col-lg-6 col-md-6">
               <form:form action="${pageContext.request.contextPath}/user/store" method="post" modelAttribute="userDTO">
                   <div class="form-group">
                       <label class="font-weight-bolder" for="name">Name</label>
                       <form:input type="text" cssClass="form-control" id="name" placeholder="Name" path="name"/>
                   </div>
                   <div class="form-group">
                       <label class="font-weight-bolder" for="name">Email</label>
                       <form:input path="email" cssClass="form-control" type="text" placeholder="Email"/>
                   </div>
                   <div class="form-group">
                       <label class="font-weight-bolder" for="name">Password</label>
                       <form:input path="password" cssClass="form-control" type="text" placeholder="Password"/>
                   </div>
                   <div class="form-group">
                       <form:select path="role" >
                           <form:option value="Select Role" disabled="true" selected="true"/>
                           <form:options items="${roleList}"/>
                       </form:select>
                   </div>
                   <button type="submit" class="btn btn-danger m-3">Submit</button>
               </form:form>
           </div>
        </div>
    </div>
</body>
</html>
