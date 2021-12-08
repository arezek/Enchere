<%@page import="java.util.ArrayList"%>
<%@page import="eni.fr.bo.ArticleVendu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
	 <header>
            <img src="" id="logo"/>
            <a href="login">Connexion<img src="" id="cnxIcon"/></a>
            <a href="signUp">S'inscrire<img src="" id="signInIcon"/></a>
        </header>
        <section id="searchBar">
            <form action="<%=request.getContextPath()%>/ServletRecherche" method="get">
                <label name="rechercherNom"><img src="" id="searchIcon"/></label>
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
	<%		}
		} 
	%>

            
        </section>
    
</body>
</html>