<%@page import="eni.fr.bo.Utilisateur"%>
<%@page import="eni.fr.messages.LecteurMessage" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page d'erreur</title>
</head>
<body>
<%List<Integer> listeCodesErreur = (List<Integer>)request.getAttribute("listeCodesErreur");
%>
<c:if test="${listeCodesErreur!= null }">

<% for(int codeErreur:listeCodesErreur) { %>
<p style="color:darkred"><%=LecteurMessage.getMessageErreur(codeErreur) %></p>
<% }%>
</c:if>
</body>
</html>