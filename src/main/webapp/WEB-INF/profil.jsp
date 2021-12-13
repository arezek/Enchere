<%@page import="eni.fr.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--@author Fabien M. Gavoille & Eugénie FUCHS  -->
<html lang="fr">
<head>
     <%@ include file="/includes/head.jsp" %>
    <title>Page de profil</title>
</head>
<body>
<%@ include file="/includes/header.jsp" %>
<% Utilisateur utilisateur= (Utilisateur)request.getAttribute("utilisateur");
    if(utilisateur!=null)
    {System.out.println(utilisateur.toString());
%>


    <h1 class="titleProfil">Profil</h1>  
    <div id="separator"></div> 
    <h2 class="titleVendor" >Profil Vendeur</h2>
    <h3 class="titleMyprofil">Mon profil</h3>


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
    
     
   <input type="submit" id="edtiProfilButton" value="Modifier">
   
</form> 
    
</body>
</html>