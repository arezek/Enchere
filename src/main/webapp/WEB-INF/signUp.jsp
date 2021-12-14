<%@page import="eni.fr.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<!--@author GAVOILLE Fabien FUCHS Eugénie ALLIOUCHE KERBOUA Abdelrezak ZABAKA Fatima-Zahra  -->

<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/query.css">
    <title>Inscription</title>
</head>
<body class="signUp">

<c:if test="${empty sessionScope.utilisateurLogged }">
<h1>Inscription</h1>
<div id="separator"></div>
<h2>Créer un compte</h2>
</c:if>

<c:if test="${not empty sessionScope.utilisateurLogged }">
<h1>Modification</h1>
<div id="separator"></div>
<h2>Modifier mon compte</h2>
</c:if>

<form method="post" action="<%=request.getContextPath()%>/signUpServlet">
<div class="signUpForm">
  <div class="signUpForm">
    <label for="pseudo">Pseudo</label><br>
  </div>
  <div class="signUp">
    <input type="text" id="pseudo" name="pseudo" value=""><br>
  </div>
  <div class="signUp">
    <label for="nom">Nom</label><br>
  </div>
  <div class="signUp">
    <input type="text" id="nom" name="nom" value=""><br>
  </div>
  <div class="signUp">
    <label for="prenom">Prénom</label><br>
  </div>
  <div class="signUp">
    <input type="text" id="prenom" name="prenom" value=""><br>
  </div>
  <div class="signUp">
    <label for="email">Email</label><br>
  </div>
  <div class="signUp">
    <input type="email" id="email" name="email" value=""><br>
  </div>
  <div class="signUp">
    <label for="telephone">Téléphone</label><br>
  </div>
  <div class="signUp">
    <input type="tel" id="telephone" name="telephone" value=""><br>
  </div><div class="signUp">
    <label for="rue">Rue</label><br>
  </div>
  <div class="signUp">
    <input type="text" id="rue" name="rue" value=""><br>
  </div>
  <div class="signUp">
    
  </div>
  <div class="signUp">
    <label for="cp">Code Postal</label><br>
  </div>
  <div class="signUp">
    <input type="text" id="cp" name="cp" value=""><br>
  </div>
  <div class="signUp">
    <label for="ville">Ville</label><br>
  </div>
  <div class="signUp">
    <input type="text" id="ville" name="ville" value=""><br>
  </div>
  
  <c:if test="${not empty sessionScope.utilisateurLogged }">
  <div class="signUp">
    <label for="mdpa">Mot de passe actuel</label><br>
  </div>
  <div class="signUp">
    <input type="password" id="mdp" name="mdpa" value=""><br>
  </div>
   <div class="signUp">
    <label for="mdp">Nouveau mot de passe</label><br>
  </div>
  <div class="signUp">
    <input type="password" id="mdp" name="mdp" value=""><br>
  </div>
  <div class="signUp">
    <label for="mdpc">Confirmation</label><br>
  </div>
  <div class="signUp">
    <input type="password" id="mdpc" name="mdpc" value=""><br>
  </div>
  
  <% Utilisateur utilisateur= (Utilisateur)request.getAttribute("utilisateur");
    if(utilisateur!=null)
    {System.out.println(utilisateur.toString());
%>
  <p>Crédit <%=utilisateur.getCredit() %></p>
  <%} %>
  <div class="signUp">
    <input type="submit" class="updateButton" value="Enregistrer">
  </div>
  <div class="signUp">
    <input type="submit" class="deleteButton" value="Supprimer mon compte">
  </div>
  </c:if>
  
  <c:if test="${empty sessionScope.utilisateurLogged }">
  <div class="signUp">
    <label for="mdp">Mot de passe</label><br>
  </div>
  <div class="signUp">
    <input type="password" id="mdp" name="mdp" value=""><br>
  </div>
  <div class="signUp">
    <label for="mdpc">Confirmation</label><br>
  </div>
  <div class="signUp">
    <input type="password" id="mdpc" name="mdpc" value=""><br>
  </div>
  <div class="signUp">
    <input type="submit" class="signUpButton" value="Créer">
  </div>
  <div class="signUp">
    <a href="<%=request.getContextPath()%>/accueilServlet"  ><button id="signUpButton">Annuler</button></a>
  </div>
  </c:if>

</form> 
    
</body>
</html>