<%--
  Created by IntelliJ IDEA.
  User: elfindel69
  Date: 11/08/2021
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Espace Client G19</title>
</head>
<body>
    <h1>Connexion</h1>

    <c:if test="${erreur ne null}">
        <p>${erreur}</p>
    </c:if>

<form action="connexion" method="post">
    <label for="email">email</label>
    <input type="email" name="email">
    <br>
    <label for="password">mot de passe</label>
    <input type="password" name="password">
    <br>
    <input type="submit" value="connexion">
</form>
</body>
</html>
