<%@page import="eni.fr.bo.Utilisateur"%>
<%@page import="eni.fr.messages.LecteurMessage" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
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
    <c:if test="${not empty sessionScope.utilisateurLogged }"><title>Modification</title></c:if>
</head>
<body class="edit">
	<div id ="header">
		<a href="<%=request.getContextPath()%>/ServletRecherche"><img src="img/eni_enchere_logo.png" id="logo2"/></a>
	</div>
	<div id="separator"></div>

	<c:if test="${not empty sessionScope.utilisateurLogged }">
	
	
	</c:if>
	<% List<Integer> listeCodesErreur = (List<Integer>)request.getAttribute("listeCodesErreur"); %>
	<c:if test="${listeCodesErreur!= null }">
		<p>Une erreur est survenue :</p>
		<% for(int codeErreur:listeCodesErreur) { %>
		<p><%=LecteurMessage.getMessageErreur(codeErreur) %></p>
		<% }%>
	</c:if>
	<div class="globalForm">
		<h1 id="buyTitle">Modifier mon compte</h1>	
	
	<form method="post" action="<%=request.getContextPath()%>/ModifProfilServlet">
		<div class="essai">
			<div class="firstColumn">
		  	  <label for="pseudo">Pseudo</label><br>
			 </div>
		  	<div class="detail">
		   	 <input type="text" id="pseudo" name="pseudo" value=""><br>
		 	</div>
		</div>
		<div class="essai">
			 <div class="firstColumn">
			    <label for="prenom">Prénom</label><br>
			 </div>
			 <div class="detail">
			 	<input type="text" id="prenom" name="prenom" value=""><br>
	 		 </div>
		</div>
		<div class="essai">
			<div class="firstColumn">
	   	 		<label for="email">Email</label><br>
		  	</div>
	 	 		<div class="detail">
	  	 	<input type="email" id="email" name="email" value=""><br>
	  		</div>
		</div>	
		<div class="essai">
			<div class="firstColumn">
	   			<label for="telephone">Téléphone</label><br>
	  		</div>
	  		<div class="detail">
	   			<input type="tel" id="telephone" name="telephone" value=""><br>
	  		</div>
		</div>	
		<div class="essai">
			<div class="firstColumn">
	    		<label for="rue">Rue</label><br>
	 		</div>
	 		<div class="detail">
	  			<input type="text" id="rue" name="rue" value=""><br>
	 		</div>
		</div>	
		<div class="essai">
			<div class="firstColumn">
	   			<label for="cp">Code Postal</label><br>
	  		</div>
	  			<div class="detail">
	   		<input type="text" id="cp" name="cp" value=""><br>
	  		</div>	
		</div>	
		<div class="essai">
			<div class="firstColumn">
	    		<label for="ville">Ville</label><br>
	 		</div>
	  		<div class="detail">
	   			<input type="text" id="ville" name="ville" value=""><br>
	  		</div>
		</div>	
		
		<c:if test="${not empty sessionScope.utilisateurLogged }">
			
		<div class="essai">
			<div class="firstColumn">
	  			<label for="mdpa">Mot de passe actuel</label><br>
	  		</div>
	 		<div class="detail">
	   			<input type="password" id="mdp" name="mdpa" value=""><br>
			</div>
		</div>	
		<div class="essai">
			<div class="firstColumn">
	   			<label for="mdp">Nouveau mot de passe</label><br>
	  		</div>
	 		<div class="detail">
	   			<input type="password" id="mdp" name="mdp" value=""><br>
			</div>
		</div>	
		<div class="essai">
			<div class="firstColumn">
	    		<label for="mdpc">Confirmation</label><br>
	 		</div>
	 		<div class="detail">
	    		<input type="password" id="mdpc" name="mdpc" value=""><br>
	  		</div>	
		</div>	
		
		<% Utilisateur utilisateur= (Utilisateur)request.getAttribute("utilisateur");
	    if(utilisateur!=null)
	    {System.out.println(utilisateur.toString());
		%>
		<p>Crédit <%=utilisateur.getCredit() %></p>
		<%} %>
		
			<div class="buttonEdit">
				<input type="submit" id="registerButton" value="Enregistrer">
	 		</div>
		</c:if>		
		</form>
			<div class="buttonEdit">
				<form method="get" action="<%=request.getContextPath()%>/Suppression">
			   	<input type="submit" name="deleteButton" id="deleteButton" value="Supprimer">
	  			</form>
	   		</div>
	  		
	 	</div>		
	  
	 
	  
	  
	  
	  
	 
	  
	  
	 
	  
	  
	  
	  
	  
	  
	   
	
	
    
</body>
</html>