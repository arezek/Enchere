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
<h1>Connexion</h1>

<form method="post" action="<%=request.getContextPath()%>/loginServlet">
  <label for="pseudo">Identifiant :</label><br>
  <input type="text" id="identifiant" name="identifiant" value=""><br>
  
  <label for="nom">Mot de passe :</label><br>
  <input type="text" id="mdp" name="mdp" value=""><br>
  
  <label for="prenom">Prénom:</label><br>
  <input type="text" id="prenom" name="prenom" value=""><br>
  
  <input type="submit" value="Connexion">
   
  <input type="checkbox" id="souvenirDeMoi" name ="souvenirDeMoi">
  <label for="souvenirDeMoi">Se souvenir de moi</label>
  
  <a href="">Mot de passe oublié</a>
   
 </form>  
 
 <form method="post" action="<%=request.getContextPath()%>/signUpServlet">
  
   <input type="submit" value="Créer un compte">
   
 </form> 
  
</body>
</html>