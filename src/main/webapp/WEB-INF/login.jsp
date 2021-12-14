<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--@author Fabien M. Gavoille & Eugénie FUCHS  -->
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/query.css">
    <title>Connexion</title>
</head>
<body>
<h1 class="titleLogin">Connexion</h1>

<div id="separator"></div>


  <form method="post" action="<%=request.getContextPath()%>/loginServlet">
  <div class="formLogin">  
    <div class="form">
      <label for="pseudo">Identifiant  </label><br>
    </div>

    <div class="form">
      <input type="text" id="identifiant" name="identifiant" <%-- value="${identifiant} "--%>><br>
    </div>

    <div class="form">
      <label for="nom">Mot de passe </label><br>
    </div>
    <div class="form">
        <input type="password" id="mdp" name="mdp" <%-- value="${mdp}" --%>><br>
    </div>      
   
    <div class="form">
      <input type="submit" class="loginButton"  value="Connexion">      
    </div> 
    <div class="form">
      <input type="checkbox" id="souvenirDeMoi" name ="souvenirDeMoi" value="ok" >
      <label for="souvenirDeMoi" class="passLogin">Se souvenir de moi</label>
    </div>
    <div class="form">
      <a href="" class="passLogin">Mot de passe oublié</a>
    </div>
  </div> 
  </form>         
   
  <form method="post" action="<%=request.getContextPath()%>/signUpServlet">
    
    <input type="submit" class ="loginButton"  value="Créer un compte">
     
  </form>
 
  
</body>
</html>