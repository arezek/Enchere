<%@page import="eni.fr.bo.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eni.fr.bo.ArticleVendu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set scope="session" var="utilisateurLogged" value="${sessionScope['utilisateurLogged'] }"/>

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
                <% Utilisateur utilisateurLogged = (Utilisateur)session.getAttribute("utilisateurLogged"); 
                	/* boolean isConnected = (boolean)session.getAttribute("isConnected");
                	if (isConnected == true){ */
                	%>
       			
                <c:if test="${not empty utilisateurLogged  }"> 
                	<a href="" class="headerlinks">Enchères</a>
                	<a href="" class="headerlinks">Vendre un article</a>
                	<a href="<%=request.getContextPath()%>/profilServlet?noUtilisateur=<%=utilisateurLogged.getNoUtilisateur() %>" class="headerlinks">Mon Profil</a>
                	<a href="" class="headerlinks">Déconnexion</a>
                	<%-- <% } else { %> --%> 	
               </c:if> 
                
                
               <c:if test="${empty utilisateurLogged  }"> 
                <a href="login" class="headerlinks">Connexion<img src="img/connexion.png" id="cnxIcon"/></a>
                <a href="signUp" class="headerlinks">S'inscrire<img src="img/inscription.png" id="signInIcon"/></a>
			   </c:if> 
			<%-- 	<%} %> --%>

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
        
        	<c:if test="${isConnected = true }">
        	
        		<div>
        			
        			<input type="radio" id="achat" name="achat" value="achat" checked>
        			<label for ="achat">Achat</label>
        			
        			<div>
        			
        				<input type="checkbox" id="enchereOuverte" name="enchereOuverte" value="enchereOuverte" checked>
        				<label for ="enchereOuverte">enchères ouvertes</label>
        				<input type="checkbox" id="enchereEnCours" name="enchereEnCours" value="enchereEnCours">
        				<label for ="enchereEnCours">mes enchères en cours</label>
        				<input type="checkbox" id="enchereRemportee" name="enchereRemportee" value="enchereRemportee">
        				<label for ="enchereRemportee">mes enchères remportées</label>
        			
        			</div>
        			
        		</div>
        		<div>
        			
        			<input type="radio" id="ventes" name="ventes" value="ventes">
        			<label for ="ventes">Mes ventes</label>
        			
        			<div>
        			
        				<input type="checkbox" id="venteEnCours" name="venteEnCours" value="venteEnCours" checked>
        				<label for ="venteEnCours">mes ventes en cours</label>
        				<input type="checkbox" id="venteNonDebutee" name="venteNonDebutee" value="venteNonDebutee">
        				<label for ="venteNonDebutee">ventes non débutées</label>
        				<input type="checkbox" id="venteTerminee" name="venteTerminee" value="venteTerminee">
        				<label for ="venteTerminee">ventes terminées</label>
        			
        			</div>
        			
        		</div>
        	
        	</c:if>
        
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