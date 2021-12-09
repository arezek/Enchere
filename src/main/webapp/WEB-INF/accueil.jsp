<%@page import="java.util.ArrayList"%>
<%@page import="eni.fr.bo.ArticleVendu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Document</title>
</head>
<body>
	    <header>
            <div id="headerbloc">
                <img src="img/eni_enchere_logo.png" id="logo"/>
                <a href="login" class="headerlinks">Connexion<img src="img/connexion.png" id="cnxIcon"/></a>
                <a href="signUp" class="headerlinks">S'inscrire<img src="img/inscription.png" id="signInIcon"/></a>
            </div>
        </header>
        <div id="separator"></div>
        <section id="searchBar">
            <form action="<%=request.getContextPath()%>/ServletRecherche" method="get">
                <label name="rechercherNom"><img src="img/search.png" id="searchIcon"/></label>
                <input type="text" placeholder="rechercher" name="rechercherNom" >
                <label for="rechercherCategories">Catégorie</label>
                <select name="rechercherCategories" id="categories">
                    
                    <option value="5">Toutes</option>
                    <option value="1">Informatique</option>
                    <option value="2">Ameublement</option>
                    <option value="3">Vetement</option>
                    <option value="4">Sport Loisirs</option>
                    
                </select>
                <input type="submit" value="rechercher" >
            </form>
        </section>
        <section>
            /*boucle*/
            <%
            ArrayList<ArticleVendu> articlesVendus = (ArrayList<ArticleVendu>)request.getAttribute("articlesVendus");
	if(articlesVendus!=null)
		{
	for(ArticleVendu art: articlesVendus){ 
	%>
			<a href="<%=request.getContextPath()%>/ServletFicheProduit?noArticle=<%=art.getNoArticle() %>">
				<div class="articleIndex">
	                <img src="" class="imgArticleIndex"/>
	                <h3 class="titreArticleIndex"><%=art.getNomArticle() %></h3>
	                <p class="prix"><%=art.getMiseAPrix() %></p>
	                <p class="vendeur">par 
	                    <a href="" class="vendeurLine">
	                        <%=art.getNoUtilisateur().getNom() %>
	                    </a>
	                </p>
	                <p class="adresse">
	                    <%=art.getNoUtilisateur().getCodePostal() %>
	                    <%=art.getNoUtilisateur().getVille() %>
	                </p>
	            </div>
            </a> 
	<%		}
		} 
	%>

            
        </section>
    
</body>
</html>