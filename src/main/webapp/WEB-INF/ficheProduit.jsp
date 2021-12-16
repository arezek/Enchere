<%@page import="java.util.ArrayList"%>
<%@page import="eni.fr.bo.ArticleVendu"%>
<%-- <%@page import="eni.fr.bo.Retrait"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--@author Fabien M. Gavoille / @author ZABAKA fatima zahra  -->
<html lang="fr">
<head>
    <%@ include file="/includes/head.jsp" %>
    <title>Fiche Produit</title>
</head>
<body>

	<%@ include file="/includes/header.jsp" %>

	<% ArticleVendu art= (ArticleVendu)request.getAttribute("articleVendu");
        if(art!=null)
		{System.out.println(art.toString());
        %>
<%--    <% Retrait retrait= (Retrait)request.getAttribute("retraitAdress");
        if(retrait!=null)
		{System.out.println(retrait.toString());
        %>     
         --%>
        
	
	<div id="separator"></div>
	
	<section class="product">
		
		<div class="photo">	
			<div class="imgGroup">
				<img src="img/ArticlesPhotos/<%=art.getNoArticle() %>.jpg" class="imgArticleFirst"/>	        	
			</div>	
								
		</div>

		<div class="fiche">
			<div class="detail">
				<h2> <%=art.getNomArticle() %> </h2>
			</div> 
			<div class="essai">
				<div class="firstColumn">
					<h4>Description</h4>
				</div>
				<div class="detail">
					<p><%=art.getDescription() %></p>
				</div>
			</div>
			<div class="essai">
				<div class="firstColumn">
					<h4>Categorie</h4>
				</div>
				<div class="detail">
					<p><%=art.getNoCategorie().getLibelle() %></p>
				
				</div>
			</div>
			<div class="essai">
				<div class="firstColumn">
					<h4>Meilleur Offre</h4>
				</div>
				<div class="detail">
					<p>150 points</p>
				</div>
			</div>	
			<div class="essai">
				<div class="firstColumn">
					<h4>Mise à Prix</h4>
				</div>
				<div class="detail">
					<h3><%=art.getMiseAPrix() %></h3>
				</div>
			</div>
			<div class="essai">
				<div class="firstColumn">
					<h4>Fin de l'enchère</h4>
				</div>
				<div class="detail">
					<p><%=art.getDateFinEncheres() %></p>
				</div>
			</div>
			<div class="essai">
				<div class="firstColumn">
					<h4>Retrait:</h4>	
				</div>
				<div class="detail">
					<p><%-- <%=retrait.getRue() %> --%></p>
				</div>			
			</div>
			<div class="essai">
				<div class="firstColumn"></div>
				<div class="detail">
					<p> <%-- <%=retrait.getCodePostal() %> <%=retrait.getVille() %> --%></p>
				</div>
			</div>
			<div class="essai">
				<div class="firstColumn">
					<h3> Par</h3>
				</div>
				<div class="detail">
					<a href="<%=request.getContextPath()%>/profilServlet?noUtilisateur=<%=art.getNoUtilisateur().getNoUtilisateur() %>"><%=art.getNoUtilisateur().getPseudo() %></a>
				</div>
				
			</div>			
			<div class="essai">
				<div class="firstColumn">
					<label for="encherir">Ma proposition :</label>
				</div>
				<div class="detail">
					<!-- div à laisser vide !!  -->
				</div>
			
			</div>
			<div class="essai">
				<div class="firstColumn">
					<input type="number" id="encherir" name="encherir"
						min="100"  step="10" placeholder="100">
				</div>
				<div class="detail">
					<input type="submit" id="signUpButton" value="Enchérir">
				</div>
			
			</div>			
				
		</div>	

	</section>
	 <%} %> 
		
        	
       
        
</body>
</html>