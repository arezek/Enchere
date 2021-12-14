<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>test upload</title>
</head>
<body>
   <%-- <c:if test="${ !empty photo}"><p><c:out value="Le fichier ${ photo } (${ description }) a été uploadé !" /></p></c:if> --%>
   <form method="post" action="UplaodImagetest" enctype="multipart/form-data">
    <label for="photo"></label>
    <input type="file" name="photo" />
    <input type="submit" value="Charger" />
  </form>
  
</body>
</html>