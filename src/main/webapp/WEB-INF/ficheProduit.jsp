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
        <% ArticleVendu art= (ArticleVendu)request.getAttribute("articleVendu");
        if(art!=null)
		{System.out.println(art.toString());
        %>
        <section>photos</section>
        <section>
        	<h2> <%=art.getNomArticle() %> </h2>
        	<h3><%=art.getMiseAPrix() %></h3>
        	<p>description:</p>
        	<p><%=art.getDescription() %></p>
        	<p>categorie:</p>
        	<p><%=art.getNoCategorie().getLibelle() %></p>
        	<p>fin de l'enchere:</p>
        	<p><%=art.getDateFinEncheres() %></p>
        	<p> par : <a href="<%=request.getContextPath()%>/profilServlet?noUtilisateur=<%=art.getNoUtilisateur().getNoUtilisateur() %>"><%=art.getNoUtilisateur().getPseudo() %></a></p>
        	<p>retrait:</p>
        	<p>retraits.Rue</p>
        	<p>retraits.code_postal + " " + retraits.ville</p>
        	<form action="">
        	<label for="encherir">Ma proposition :</label>
        	<input type="number" id="encherir" name="encherir"
       			min="100"  step="10" placeholder="100">
       			<input type="submit" value="echerir">
        	</form>
        </section>
		<%} %>
</body>
</html>