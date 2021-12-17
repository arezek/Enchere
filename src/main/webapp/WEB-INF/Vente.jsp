
<!--@author ZABAKA fatima zahra eugénie fuchs ALLIOUCHE KERBOUA Abdelrezak gavoille fabien -->
<%@page import="eni.fr.bo.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eni.fr.messages.LecteurMessage" %>
<%@page import="java.util.List"%>
<%@page import="eni.fr.bo.ArticleVendu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="fr">
<head>
     <%@ include file="/includes/head.jsp" %>
    <title>Nouvelle Vente</title>
</head>
<body>
<%@ include file="/includes/header.jsp" %>

<% List<Integer> listeCodesErreur = (List<Integer>)request.getAttribute("listeCodesErreur"); %>
<c:if test="${listeCodesErreur!= null }">
			<p>Une erreur est survenue :</p>
			<% for(int codeErreur:listeCodesErreur) { %>
					<p><%=LecteurMessage.getMessageErreur(codeErreur) %></p>
			<% }%>
		</c:if>
		
<h1 id="buyTitle">Nouvelle Vente</h1>
	
	<div class="bid">
		<section class="leftBid">		
			<a href="" id="imgLink"><img src="/img/pic.jpg" id="imgArticleVente" alt="Photo Article"></a>  
			     
		</section>
		
		<section class="rightBid">		
			
			<form action="<%=request.getContextPath()%>/ServletVente" method="post" enctype="multipart/form-data">
				<div class="fieldset">
					<div class="buyForm">
						<label for="article">Article</label>
					</div>

					<div class="buyForm">
						<input type="text" id="article" name="article" value="">
					</div>

					<div class="buyForm">
						<label for="description">Description</label>
					</div>

					<div class="buyForm">
						<textarea name="description" id="description" rows="4" cols="40"></textarea>
					</div>

					<div class="buyForm">
						<label for="categorie">Catégorie</label>
					</div>

					<div class="buyForm">
						<select name="no_categorie" id="categories">     
							<option value="1">Informatique</option>
							<option value="2">Ameublement</option>
							<option value="3">Vêtements</option>
							<option value="4">Sport-Loisirs</option>
						</select>	
					</div>					
					<div class="buyForm">
					<%-- <c:if test="${ !empty photo }"><p><c:out value="L'image ${ photo }  a été uploadé !" /></p></c:if> --%>
						<label for="photo">Photo de l'article  </label>
						<input type="file" name="photo" id="imgLink" />
																	
					</div>

					<div class="buyForm">
						<label for="miseaprix">Mise à prix</label>
					</div>

					<div class="buyForm">
						<input type="number" id="miseaprix" name="miseaprix"
							min="100"  step="10" placeholder="100">
					</div>

					<div class="buyForm">
						<label for="debutenchere">Début de l'enchère</label>
					</div>

					<div class="buyForm">
						<input type="date" id="debutenchere" name="debutenchere" value="">
					</div>

					<div class="buyForm">
						<label for="finenchere">Fin de l'enchère</label>
					</div>

					<div class="buyForm">
						<input type="date" id="finenchere" name="finenchere" value="">
					</div>	
				</div>		
				<div class="fieldsetRetrait">		
					
					<div class="buyForm">
						<label id="legend">Retrait</label>
					</div>

					<div class="buyForm">
						<label for="rue">Rue</label>
					</div>

					<div class="buyForm">
						<input type="text" id="rue" name="rue" value="">
					</div>

					<div class="buyForm">
						<label for="codePostal">Code Postal</label>
					</div>

					<div class="buyForm">
						<input type="text" id="codePostal" name="codePostal" value="">
					</div>					

					<div class="buyForm">
						<label for="ville">Ville</label>
					</div>

					<div class="buyForm">
						<input type="text" id="ville" name="ville" value="">
					</div>														
				</div >
				<div class="buyButton">
					<input type="submit" class="newButton" value="Enregistrer">
					<input type="submit" class="newButton" value="Annuler">
					<!-- TODO bouton annuler ne marche pas -->
				</div>	   
							   
							   
			</form>
				   
		</section>

	</div>

</body>
	<%@ include file="/includes/footer.jsp" %>

</html>