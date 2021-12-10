
<!--@author ZABAKA fatima zahra  -->
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
    <title>Nouvelle Vente</title>
</head>
<body>

	<section>
		<p>ENI-Enchères</p>
		<p>photo</p>
	</section>
	
	<section>
	<h3>Nouvelle Vente</h3>
		<form action="<%=request.getContextPath()%>/ServletVente" method="post">
		<fieldset>
			<label for="article">Article:</label><br>
  			<input type="text" id="article" name="article" value=""><br>
  			<label for="description">Description:</label><br>
  			<textarea name="description" id="description" rows="3" cols="20"></textarea><br>
  			<label for="categorie">Categorie:</label><br>
  			 <select name="rechercherCategories" id="categories">     
                    <option value="5" selected="selected" disabled="disabled">Toutes</option>
                    <option value="1">Informatique</option>
                    <option value="2">Ameublement</option>
                    <option value="3">Vetement</option>
                    <option value="4">Sport Loisirs</option>
                    
                </select><br>
            <label for="photo">photo de l'article:</label><br>
            <label for="miseaprix">Mise à prix:</label><br>
            <input type="number" id="miseaprix" name="miseaprix"
       			min="100"  step="10" placeholder="100"><br>
       		<label for="debutenchere">Début de l'enchère:</label><br>
  			<input type="date" id="debutenchere" name="debutenchere" value=""><br>
       		<label for="finenchere">Fin de l'enchère:</label><br>
  			<input type="date" id="finenchere" name="finenchere" value=""><br>
  		</fieldset>
  		<fieldset>
  			<legend>Retrait</legend>
  			<label for="rue">Rue:</label><br>
  			<input type="text" id="rue" name="rue" value=""><br>
  			 <label for="codepostal">Code Postal:</label><br>
  			<input type="text" id="codepostal" name="codepostal" value=""><br>
  			<label for="ville">Ville:</label><br>
  			<input type="text" id="ville" name="ville" value=""><br>
  			
  		</fieldset>
       			
       			<input type="submit" value="Enregistrer">
       			<input type="reset" value="Annuler">
       			
        	</form>
               
</section>
</body>
</html>