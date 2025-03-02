<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 25/12/2024
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Categories</title>
</head>
<body>
<h3>List Categories</h3>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Catalog Id</th>
        <th>Catalog Name</th>
        <th>Description</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCategories}" var="catalog" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${catalog.catalogId}</td>
            <td>${catalog.catalogName}</td>
            <td>${catalog.description}</td>
            <td>${catalog.status}</td>
            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/categoriesController/initCreate">Create new categories</a>
</body>
</html>
