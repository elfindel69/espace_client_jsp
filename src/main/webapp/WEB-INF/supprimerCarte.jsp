<%--
  Created by IntelliJ IDEA.
  User: elfindel69
  Date: 11/08/2021
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Espace Client G19</title>
</head>
<body>
    <h1> supprimer carte numéro ${numero}</h1>
    <c:choose>
        <c:when test="${erreur ne null}">
            <p>${erreur}</p>
            <a href="tableauDeBord">retour</a>
        </c:when>
        <c:otherwise>
            <p>Êtes-vous sur(e) de vouloir effacer la carte bancaire numéro
                ${numero} ?</p>
            <button value="Oui"><a href="confirmerSuppressionCarte?idCarte=${idCarte}">Oui</a></button>
            <button value="Non"> <a href="tableauDeBord">Non</a></button>
        </c:otherwise>
    </c:choose>
</body>
</html>
