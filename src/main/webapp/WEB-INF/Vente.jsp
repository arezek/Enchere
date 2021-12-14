
<!--@author ZABAKA fatima zahra  -->
<%@page import="eni.fr.bo.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
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
<h1>Nouvelle Vente</h1>
	<div id="separator"></div>
	<div class="bid">
		<section class="leftBid">		
			<a href="" id="imgLink"><img src="/img/pic.jpg" id="imgArticleVente" alt="Photo Article"></a>  
			     
		</section>
		
		<section class="rightBid">		
			
			<form action="<%=request.getContextPath()%>/ServletVente" method="post">
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
						<label for="categorie">Categorie</label>
					</div>

					<div class="buyForm">
						<select name="no_categorie" id="categories">     
							<option value="1">Informatique</option>
							<option value="2">Ameublement</option>
							<option value="3">Vetement</option>
							<option value="4">Sport Loisirs</option>
						</select>	
					</div>

				<div class="buyForm">
					<c:if test="${ !empty photo }"><p><c:out value="L'image ${ photo }  a été uploadé !" /></p></c:if>
						<form method="post" action="Servletvente" enctype="multipart/form-data">        
 							<p>
								<label for="photo">Photo de l'article  </label>
								<input type="file" name="photo" id="imgLink" />
							</p>
							<input type="submit" value="Charger" />
						</form>						
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
					<input type="submit" class="signUpButton" value="Enregistrer">
					<input type="reset" id="signUpButton" value="Annuler">
				</div>	   
							   
							   
			</form>
				   
		</section>

	</div>
</body>
</html>