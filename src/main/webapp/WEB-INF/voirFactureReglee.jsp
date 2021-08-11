<%--
  Created by IntelliJ IDEA.
  User: elfindel69
  Date: 11/08/2021
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Espace Client G19</title>
</head>
<body>
    <p>Client connecté : ${client.prenom } ${client.nom } <a href="deconnexion">Deconnexion</a></p>
    <h2>Facture numéro ${facture.id }</h2>
    <p>Montant : ${facture.montantEnEuros } €</p>
    <p>Date de création : <fmt:formatDate pattern="dd/MM/yyyy" value="${facture.dateCreation }" /> </p>
    <p>Date d'échéance : <fmt:formatDate pattern="dd/MM/yyyy" value="${facture.dateEcheance }" /> </p>

    <h3>Paiements reçus</h3>
    <table>
        <tr>
            <td>Montant</td>
            <td>Date effective</td>
            <td>Carte</td>
        </tr>
        <c:forEach items="${facture.paiements }" var="paiement">
            <tr>
                <td>${paiement.montantEnEuros } €</td>
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${paiement.dateEffective }" /></td>
                <td>${paiement.carteBancaire.numero }</td>
            </tr>
        </c:forEach>
    </table>
    <a href="tableauDeBord">Retour au tableau de bord</a>
</body>
</html>
