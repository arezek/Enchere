<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<header id="headerbloc">
    	<div id="brand" >
        	<a href="<%=request.getContextPath()%>/ServletRecherche"><img src="img/eni_enchere_logo.png" id="logo"/></a>
       		<%-- <c:if test="${not empty sessionScope.utilisateurLogged}"> 
       		<p class ="bonjour"> Bonjour ${sessionScope.utilisateurLogged.getPseudo()} </p>
        	</c:if> --%>
        </div> 
           
        <%-- ${sessionScope.utilisateurLogged} --%>
        <%-- <% 
        Utilisateur utilisateurLogged = (Utilisateur)session.getAttribute("utilisateurLogged"); 
                	/* boolean isConnected = (boolean)session.getAttribute("isConnected");
                	if (isConnected == true){ */ %> --%>
         
          <c:if test="${not empty sessionScope.utilisateurLogged  }"> 
        
          <div class="connected">
        	
        	<a href="" class="headerlinks">Enchères</a>
          	<a href="<%=request.getContextPath()%>/ServletVente?noUtilisateur=${sessionScope.utilisateurLogged.getNoUtilisateur()}" class="headerlinks">Vendre un article</a>
          	<a href="<%=request.getContextPath()%>/profilServlet?noUtilisateur=${sessionScope.utilisateurLogged.getNoUtilisateur()}" class="headerlinks">Mon Profil</a>
          	<a href="<%=request.getContextPath()%>/Deconnexion?noUtilisateur=${sessionScope.utilisateurLogged.getNoUtilisateur()}" class="headerlinks">Déconnexion</a>
                	<%-- <% } else { %> --%> 
           </div>  	
       	 </c:if>      
          
			<c:if test="${empty sessionScope.utilisateurLogged  }"> 
			<div class="notConnected">
				<a href="login" class="headerlinks">Connexion<img src="img/connexion.png" id="cnxIcon"/></a>
				<a href="signUp" class="headerlinks">S'inscrire<img src="img/inscription.png" id="signInIcon"/></a>
			</div> 
			</c:if> 
		            
			<%-- 	<%} %> --%>
 
            
	</header>