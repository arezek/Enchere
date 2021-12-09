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
    <title>Page de profil</title>
</head>
<body>

    <h1>Profil Vendeur</h1>
    <h1>Mon profil</h1>
    
    <p>Pseudo: </p>
    <p>Nom: </p>
    <p>Prénom: </p>
    <p>Email: </p>
    <p>Téléphone: </p>
    <p>Rue: </p>
    <p>Code postal: </p>
    <p>Ville : </p>
    
<form method="post" action="<%=request.getContextPath()%>/profilServlet">
  
   <input type="submit" value="Modifier">
   
</form> 
    
</body>
</html>