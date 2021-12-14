<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
	<%-- 	<form action="<%=request.getContextPath()%>/UplaodImagetest" method="post">
	<div class="buyForm">
						<c:if test="${ !empty photo }"><p><c:out value="L'image ${ photo }  a été uploadé !" /></p></c:if>
						<label for="photo">Photo de l'article  </label>
						<input type="file" name="photo" id="imgLink" />
						<input type="submit" value="Charger" />
												
		</div>
	</form> --%>
    
    
   <%--      <c:if test="${ !empty fichier }"><p><c:out value="Le fichier ${ fichier } (${ description }) a été uploadé !" /></p></c:if>
    <form method="post" action="UplaodImagetest" enctype="multipart/form-data">
        <p>
            <label for="description">Description du fichier : </label>
            <input type="text" name="description" id="description" />
        </p>
        <p>
            <label for="fichier">Fichier à envoyer : </label>
            <input type="file" name="fichier" id="fichier" />
        </p>
        
        <input type="submit" /> 
          </form> --%>
   <form method="post" action="UplaodImagetest" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="submit" value="Upload" />
  </form>
  
</body>
</html>