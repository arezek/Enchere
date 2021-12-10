<%@page import="eni.fr.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--@author Fabien M. Gavoille & Eugénie FUCHS  -->
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Page de profil</title>
</head>
<body>
<% Utilisateur utilisateur= (Utilisateur)request.getAttribute("utilisateur");
        if(utilisateur!=null)
		{System.out.println(utilisateur.toString());
%>
    <h1>Profil Vendeur</h1>
    <h1>Mon profil</h1>
    
    <p>Pseudo: <%=utilisateur.getPseudo() %></p>
    <p>Nom: <%=utilisateur.getNom() %></p>
    <p>Prénom: <%=utilisateur.getPrenom() %></p>
    <p>Email: <%=utilisateur.getEmail() %></p>
    <p>Téléphone: <%=utilisateur.getTelephone() %></p>
    <p>Rue: <%=utilisateur.getRue() %></p>
    <p>Code postal: <%=utilisateur.getCodePostal() %></p>
    <p>Ville : <%=utilisateur.getVille() %></p>
    <%} %>
<form method="post" action="<%=request.getContextPath()%>/profilServlet">
  
   <input type="submit" value="Modifier">
   
</form> 
    
</body>
</html>