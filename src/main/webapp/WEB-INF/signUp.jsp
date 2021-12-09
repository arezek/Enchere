<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription</title>
</head>
<body>
<h1>Inscription</h1>
<h2>Créer un compte</h2>
<form method="post" action="<%=request.getContextPath()%>/signUpServlet">
  <label for="pseudo">Pseudo:</label><br>
  <input type="text" id="pseudo" name="pseudo" value=""><br>
  
  <label for="nom">Nom:</label><br>
  <input type="text" id="nom" name="nom" value=""><br>
  
    <label for="prenom">Prénom:</label><br>
  <input type="text" id="prenom" name="prenom" value=""><br>
  
    <label for="email">Email:</label><br>
  <input type="email" id="email" name="email" value=""><br>
  
    <label for="telephone">Téléphone:</label><br>
  <input type="tel" id="telephone" name="telephone" value=""><br>
  
    <label for="rue">Rue:</label><br>
  <input type="text" id="rue" name="rue" value=""><br>
  
    <label for="cp">Code Postal:</label><br>
  <input type="text" id="cp" name="cp" value=""><br>
  
   <label for="ville">Ville:</label><br>
  <input type="text" id="ville" name="ville" value=""><br>
  
   <label for="mdp">Mot de passe:</label><br>
  <input type="password" id="mdp" name="mdp" value=""><br>
  
   <label for="mdpc">Confirmation:</label><br>
  <input type="password" id="mdpc" name="mdpc" value=""><br>
  
  
  
  
  <input type="submit" value="Créer">  
  <a href="<%=request.getContextPath()%>/accueilServlet"><button>Annuler</button></a>

</form> 

    
</body>
</html>