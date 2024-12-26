<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 25/12/2024
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Categories</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/categoriesController/create" method="post">
    <label for="catalogName">Catalog Name</label>
    <input type="text" id="catalogName" name="catalogName"/><br>
    <label for="description">Description</label>
    <input type="text" id="description" name="description"/><br>
    <label for="active">Status</label>
    <input type="radio" id="active" name="status" value="true"/><label for="active">Active</label>
    <input type="radio" id="inActive" name="status" value="false"/><label for="Inactive">Inactive</label><br>
    <input type="submit" value="Create"/>
</form>
</body>
</html>
