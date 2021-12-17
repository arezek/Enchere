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
<body id="bodyProfil">
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
    <div class="globalForm">
    	<h3 id="titleMyprofil"><%=utilisateur.getPseudo() %></h3> 
    	<div class="essai">
			<div class="firstColumn">
				<p class="champ">Nom:</p> 
			</div>
			<div class="detail">
				<p> <%=utilisateur.getNom() %></p>
			</div>
		</div>
		<div class="essai">
			<div class="firstColumn">
				<p>Prénom:</p>
			</div>
			<div class="detail">
				<p> <%=utilisateur.getPrenom() %></p>
			</div>
		</div>
		<div class="essai">
			<div class="firstColumn">
				<p>Email:</p> 
			</div>
			<div class="detail">
				<p> <%=utilisateur.getEmail() %></p>
			</div>
		</div>
		<div class="essai">
			<div class="firstColumn">
				<p>Téléphone:</p> 
			</div>
			<div class="detail">
				<p> <%=utilisateur.getTelephone() %></p>
			</div>
		</div>	
		<div class="essai">
			<div class="firstColumn">
				<p>Téléphone:</p> 
			</div>
			<div class="detail">
				<p> <%=utilisateur.getTelephone() %></p>
			</div>
		</div>		
		<div class="essai">
			<div class="firstColumn">
				<p>Rue:</p> 
			</div>
			<div class="detail">
				<p> <%=utilisateur.getRue() %></p>
			</div>
		</div>		
		<div class="essai">
			<div class="firstColumn">
				<p>Code postal:</p>
			</div>
			<div class="detail">
				<p> <%=utilisateur.getCodePostal() %></p>
			</div>
		</div>		
		<div class="essai">
			<div class="firstColumn">
				<p>Ville :</p>
			</div>
			<div class="detail">
				<p> <%=utilisateur.getVille() %></p>
			</div>
		</div>	
			
		<%} %> 
		
		<c:if test="${not empty sessionScope.utilisateurLogged  }">
	    	<form method="get" action="<%=request.getContextPath()%>/ModifProfilServlet">	        
				<input type="submit" id="edtiProfilButton" value="Modifier">	  	
			</form> 
	 	</c:if>
	 	
	</div>		
   
</body>

<%@ include file="/includes/footer.jsp" %>
</html>