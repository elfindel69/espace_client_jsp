<%--
  Created by IntelliJ IDEA.
  User: elfindel69
  Date: 11/08/2021
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Espace Client G19</title>
</head>
<body>
    <h1>Régler facture ${facture.id}</h1>
    <p>Montant de la facture ${facture.montantEnEuros} €</p>
    <form action="reglerFacture?id=${facture.id}" method="post">
        <label for="montant">Montant</label>
        <input type="number" name="montant" value="${facture.montantEnEuros}">
        <br>
        <label for="dateEffective">Date Effective</label>
        <input type="date" name="dateEffective" value="${facture.dateEcheance}">
        <br>
        <select name="idCarte">
            <c:forEach items="${cartes}" var="carte">
                <option value="${carte.id}">${carte.numero}</option>
            </c:forEach>
            <br>
            <input type="submit" value="Régler">
        </select>
    </form>
</body>
</html>
