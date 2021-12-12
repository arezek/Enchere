<%@page import="java.util.ArrayList"%>
<%@page import="eni.fr.bo.ArticleVendu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--@author Fabien M. Gavoille / @author ZABAKA fatima zahra  -->
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/query.css">
    <title>Fiche Produit</title>
</head>
<body>
	<header>
		<div id="headerbloc">               
			<a href="login" class="headerlinks">Connexion<img src="/img/connexion.png" id="cnxIcon"/></a>
			<a href="signUp" class="headerlinks">S'inscrire<img src="/img/inscription.png" id="signInIcon"/></a>			
		</div>
	</header>
	<% ArticleVendu art= (ArticleVendu)request.getAttribute("articleVendu");
        if(art!=null)
		{System.out.println(art.toString());
        %>
	<div id="separator"></div>

	<h2> <%=art.getNomArticle() %> </h2>
	<section class="product">
		
		<div class="photo">			
			<img src="img/pic.jpg" alt="">			
		</div>

		<div class="fiche">			
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
					<select name="rechercherCategories" id="catArticle">                    
                        <%=art.getNoCategorie().getLibelle() %>                   
                     </select>
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
					<p><%=art.getMiseAPrix() %></p>
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
					<p>retraits.Rue</p>
				</div>			
			</div>
			<div class="essai">
				<div class="firstColumn"></div>
				<div class="detail">
					<p>retraits.code_postal + " " + retraits.ville</p>
					</div>
			</div>
			<div class="essai">
				<div class="firstColumn">
					<h3> Vendeur</h3>
				</div>
				<div class="detail">
					<p> <a href="<%=request.getContextPath()%>/profilServlet?noUtilisateur=<%=art.getNoUtilisateur().getNoUtilisateur() %>"><%=art.getNoUtilisateur().getPseudo() %></a></p>
				</div>
				
			</div>			
			
			<div class="detail">
				<form action="" method="post">
					<label for="encherir">Ma proposition :</label>
					<input type="number" id="encherir" name="encherir"
						min="100"  step="10" placeholder="100">
						<input type="submit" id="signUpButton" value="Enchérir">
					</form>
			</div>
				
		</div>	

	</section>
    <%} %>  	    
      	
        	    	
        	
        	
       
        
</body>
</html>