<%@page import="eni.fr.bo.Utilisateur"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@page import="eni.fr.bo.ArticleVendu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--@author GAVOILLE Fabien FUCHS Eugénie ALLIOUCHE KERBOUA Abdelrezak ZABAKA Fatima-Zahra  -->


<%--  <c:set scope="session" var="utilisateurLogged" value="${sessionScope['utilisateurLogged'] }"/>
--%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <%@ include file="/includes/head.jsp" %>
    <title>Accueil</title>
</head>
<body>
	<%@ include file="/includes/header.jsp" %>
	
          
        <div id="separator"></div>
        
        <section id="searchBar">
            <form action="<%=request.getContextPath()%>/ServletRecherche" method="get">
            	<div class="searchContent">
                	<label for="rechercherNom"><img src="img/search.png" id="searchIcon"/></label>
                	<input type="text" placeholder="rechercher" name="rechercherNom" id="searchInput" >
		        </div>
                <div id="catList">
                    <label for="rechercherCategories" id="catLabel">Catégorie : </label>
                    <select name="rechercherCategories" id="categories">                    
                        <option value="5">Toutes</option>
                        <option value="1">Informatique</option>
                        <option value="2">Ameublement</option>
                        <option value="3">Vetement</option>
                        <option value="4">Sport Loisirs</option>                    
                     </select>
                </div>
                <div>
                    <input type="submit" value="Rechercher" id="searchButton" >
                </div>
                <c:if test="${not empty utilisateurLogged }">
        

        	
        	
        		<div id = "filtres">
        		
        			
        			
        			<div>
        				<input type="radio" id="achat" name="article" value="achat" checked>
        				<label for ="achat">Enchères</label><br>
        				<input type="checkbox"  id="enchereOuverte" name="achat" class="achat" value="enchereOuverte" checked>
        				<label for ="enchereOuverte">Ouvertes</label>
        				<input type="checkbox"  id="enchereEnCours" name="achat" class="achat" value="enchereEnCours">
        				<label for ="enchereEnCours">En cours</label>
        				<input type="checkbox"  id="enchereRemportee" name="achat" class="achat" value="enchereRemportee">
        				<label for ="enchereRemportee">Remportées</label>
        			
        			</div>
        			
        			
        					
        			<div>
        				<input type="radio" id="ventes" name="article" value="ventes">
        				<label for ="ventes">Mes ventes</label><br>
        				
        				<input type="checkbox"  id="venteEnCours" name="ventes" class="ventes" value="venteEnCours" checked>
        				<label for ="venteEnCours">En cours</label>
        				<input type="checkbox"  id="venteNonDebutee" name="ventes" class="ventes" value="venteNonDebutee">
        				<label for ="venteNonDebutee">Non débutées</label>
        				<input type="checkbox"  id="venteTerminee" name="ventes" class="ventes" value="venteTerminee">
        				<label for ="venteTerminee">Terminées</label>
        			
        			</div>       			
        		</div>           
        		
        </c:if>                 
            </form>
        
        
	</section>
            <!-- boucle -->
        <section class="section">
            <%
            ArrayList<ArticleVendu> articlesVendus = (ArrayList<ArticleVendu>)request.getAttribute("listeArticles");
	if(articlesVendus!=null)
		{
	for(ArticleVendu art: articlesVendus){ 
	%>
		 <a href="<%=request.getContextPath()%>/ServletFicheProduit?noArticle=<%=art.getNoArticle() %>">
				
	                
			
			<div class="articleIndex">
            	<div class="left">
          			<img src="img/ArticlesPhotos/<%=art.getNoArticle() %>/1.jpg" class="imgArticleIndex"/>
                </div>
                <div class="right">

	                <h3 class="titreArticleIndex"><%=art.getNomArticle() %></h3>
	                <p class="prix"><%=art.getMiseAPrix() %></p>
	                <p class="vendeur">Par   <%=art.getNoUtilisateur().getNom() %></p>
	                <p class="adresse"><%=art.getNoUtilisateur().getCodePostal() %>
	                    <%=art.getNoUtilisateur().getVille() %></p>          
                </div>
             </div>
             
            </a>
	<%		}
		} 
	%>
         
        </section>
       
</body>
<script type="text/javascript">
	var ventes = document.getElementById("ventes");
    var achat = document.getElementById("achat");
function checkboxDesactiver(){
        
        	if(achat.checked){
        		document.getElementById("venteEnCours").disabled = true;
        		document.getElementById("venteNonDebutee").disabled = true;
        		document.getElementById("venteTerminee").disabled = true; 
				}else{
					document.getElementById("venteEnCours").disabled = false;
	        		document.getElementById("venteNonDebutee").disabled = false;
	        		document.getElementById("venteTerminee").disabled = false;	
				}
        	if(ventes.checked){
        		document.getElementById("enchereOuverte").disabled = true;
        		document.getElementById("enchereEnCours").disabled = true;
        		document.getElementById("enchereRemportee").disabled = true; 
				}else{
					document.getElementById("enchereOuverte").disabled = false;
	        		document.getElementById("enchereEnCours").disabled = false;
	        		document.getElementById("enchereRemportee").disabled = false;	
				}
        		
				
        }	
window.onload = checkboxDesactiver;
ventes.onclick = checkboxDesactiver;
achat.onclick = checkboxDesactiver;
</script>
</html>