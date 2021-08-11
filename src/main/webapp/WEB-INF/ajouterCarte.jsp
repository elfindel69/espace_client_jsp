<%--
  Created by IntelliJ IDEA.
  User: elfindel69
  Date: 11/08/2021
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Espace Client G19</title>
</head>
<body>
    <form action="ajouterCarte?id=${id}" method="post">
        <label for="numero">Numéro</label>
        <input type="text" name="numero">
        <br>
        <label for="expiration">Expiration</label>
        <select name="moisExpiration">
            <c:forEach var="mois" items="${moisList}">
                <option value="${mois}">${mois}</option>
            </c:forEach>
        </select>
        <select name="anneeExpiration">
            <c:forEach var="annee" items="${annees}">
                <option value="${annee}">${annee}</option>
            </c:forEach>
        </select>
        <br>
        <label for="cryptogramme">Cryptogramme</label>
        <input type ="text" name="cryptogramme">
        <br>
        <input type="submit" value="Ajouter">
    </form>

</body>
</html>
