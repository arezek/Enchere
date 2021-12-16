 <%@page import="eni.fr.messages.LecteurMessage" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
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
<body class="profil">
<%@ include file="/includes/header.jsp" %>
<% Utilisateur utilisateur= (Utilisateur)request.getAttribute("utilisateur");
    if(utilisateur!=null)
    {System.out.println(utilisateur.toString());
%>
     <% 
   List<Integer> listeCodesErreur = (List<Integer>)request.getAttribute("listeCodesErreur");
	%>
	
		<c:if test="${listeCodesErreur!= null }">
			<p>Une erreur est survenue :</p>
			<% for(int codeErreur:listeCodesErreur) { %>
					<p><%=LecteurMessage.getMessageErreur(codeErreur) %></p>
			<% }%>
		</c:if>
     
    <div id="separator"></div>
   
   
    <h3 class="titleMyprofil">Profil</h3>


    <p>Pseudo: <%=utilisateur.getPseudo() %></p>
    <p>Nom: <%=utilisateur.getNom() %></p>
    <p>Prénom: <%=utilisateur.getPrenom() %></p>
    <p>Email: <%=utilisateur.getEmail() %></p>
    <p>Téléphone: <%=utilisateur.getTelephone() %></p>
    <p>Rue: <%=utilisateur.getRue() %></p>
    <p>Code postal: <%=utilisateur.getCodePostal() %></p>
    <p>Ville : <%=utilisateur.getVille() %></p>
    <%} %>
    
    <c:if test="${not empty sessionScope.utilisateurLogged  }">
    <form method="get" action="<%=request.getContextPath()%>/ModifProfilServlet">
        
	 <input type="submit" id="edtiProfilButton" value="Modifier">
  	
	</form> 
 	</c:if>
    
</body>
</html>