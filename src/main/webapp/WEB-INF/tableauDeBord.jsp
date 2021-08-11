<%--
  Created by IntelliJ IDEA.
  User: elfindel69
  Date: 11/08/2021
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Espace Client G19</title>
</head>
<body>
    <p> Client connecté: ${client.prenom} ${client.nom} <a href="deconnexion">Deconnexion </a> </p>

    <h1>Factures à régler</h1>
    <table>
        <tr>
            <th>Numéro</th>
            <th>Date d'écheance</th>
            <th>Montant</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${facturesARegler}" var="facture">
           <tr><td>${facture.id}</td>
               <td>${facture.dateEcheance}</td>
               <td>${facture.montantEnEuros} €</td>
               <td><a href="reglerFacture?id=${facture.id}">Régler</a> </td>
           </tr>


        </c:forEach>
    </table>

    <table>
        <tr>
            <th>Numéro</th>
            <th>Date d'écheance</th>
            <th>Montant</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${facturesReglees}" var="facture">
            <tr>
                <td>${facture.id}</td>
                <td>${facture.dateEcheance}</td>
                <td>${facture.montantEnEuros}</td>
                <td><a href="voirFactureReglee?id=${facture.id}">Voir</a> </td>
            </tr>
        </c:forEach>
    </table>
    <table>
        <tr>
            <th>Numéro</th>
            <th>Expiration</th>
            <th>Cryptogramme</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${cartesBancaires}" var="carte">
            <tr>
                <td>${carte.numero}</td>
                <td>${carte.moisExpiration}/${carte.anneeExpiration}</td>
                <td>${carte.cryptogramme}</td>
                <td><a href="supprimerCarte?idCarte=${carte.id}">Supprimer</a> </td>
            </tr>
        </c:forEach>
        <a href="ajouterCarte?id=${client.id}">Ajouter une carte</a>
    </table>
</body>
</html>
