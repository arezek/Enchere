<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header id="headerbloc">
    	<div >
        	<a href="<%=request.getContextPath()%>/ServletRecherche"><img src="img/eni_enchere_logo.png" id="logo"/></a>
        </div>    
        <%-- ${sessionScope.utilisateurLogged} --%>
        <%-- <% 
        Utilisateur utilisateurLogged = (Utilisateur)session.getAttribute("utilisateurLogged"); 
                	/* boolean isConnected = (boolean)session.getAttribute("isConnected");
                	if (isConnected == true){ */ %> --%>
         <div class="connected">
          <c:if test="${not empty sessionScope.utilisateurLogged  }"> 
        	<p> Bonjour ${sessionScope.utilisateurLogged.getPseudo()} </p>
        	<a href="" class="headerlinks">Enchères</a>
          	<a href="<%=request.getContextPath()%>/ServletVente?noUtilisateur=${sessionScope.utilisateurLogged.getNoUtilisateur()}" class="headerlinks">Vendre un article</a>
          	<a href="<%=request.getContextPath()%>/profilServlet?noUtilisateur=${sessionScope.utilisateurLogged.getNoUtilisateur()}" class="headerlinks">Mon Profil</a>
          	<a href="<%=request.getContextPath()%>/Deconnexion?noUtilisateur=${sessionScope.utilisateurLogged.getNoUtilisateur()}" class="headerlinks">Déconnexion</a>
                	<%-- <% } else { %> --%> 	
       	 </c:if>        
         
         </div>       	
       
                
        <div class="notConnected">  
			<c:if test="${empty sessionScope.utilisateurLogged  }"> 
			<a href="login" class="headerlinks">Connexion<img src="img/connexion.png" id="cnxIcon"/></a>
			<a href="signUp" class="headerlinks">S'inscrire<img src="img/inscription.png" id="signInIcon"/></a>
			</c:if> 
		</div>             
			<%-- 	<%} %> --%>
 
            
	</header>