package eni.fr.ihm.servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eni.fr.bo.Utilisateur;
import eni.fr.dal.DALException;
import eni.fr.dal.UtilisateurDAO;
import eni.fr.dal.UtilisateurDAOJdbcImpl;

/**
 * Servlet implementation class profilServlet
 * @author Fabien M. Gavoille et Eugénie Fuchs
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Cookie[] cookies=request.getCookies();
//		if (cookies!=null) {
//			for (Cookie cookie:cookies) {
//				if (cookie.getName().equals("identifiant") ) {
//					request.setAttribute("identifiant", cookie.getValue());
//					request.setAttribute("mdp", cookie.getValue());
//					System.out.println(cookie.getValue());
//				}
//			}
//	
//		}
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/login.jsp");
		rd.forward(request, response);		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// récupérer les identifiants et les stocker dans la variable de session
		String pseudo = request.getParameter("identifiant");
		String motDePasse = request.getParameter("mdp");
		//String souvenirDeMoi=request.getParameter("souvenirDeMoi");
//		Cookie cookie2 = new Cookie("identifiant",pseudo);
//		Cookie cookie1 = new Cookie("mdp",motDePasse);
//		
//		cookie1.setMaxAge(60*60*10); 
//		cookie2.setMaxAge(60*60*10); 
//
//
//		response.addCookie( cookie1 );
//		response.addCookie( cookie2 );
		
		
		UtilisateurDAO utilisateurValidation = new UtilisateurDAOJdbcImpl();
	
		HttpSession session;
		
		try {
			Utilisateur utilisateurLogged = (Utilisateur) utilisateurValidation.selectByPseudo(pseudo);
			
			if(motDePasse.equals(utilisateurLogged.getMotDePasse())) {
				
				session = request.getSession();
				
				//ServletContext context = this.getServletContext();
				//Utilisateur utilisateurEnSession = (Utilisateur) request.getAttribute(pseudo);
				
				session.setAttribute("isConnected", true);
				
				//int hc = utilisateurEnSession.getIdSession().hashCode();
				session.setAttribute("utilisateurLogged", utilisateurLogged);
				
				//session.setAttribute("identifiant", pseudo);
				
				// redirect l'utilisateur vers la page d'accueil
				RequestDispatcher rd=request.getRequestDispatcher("ServletRecherche");
				rd.forward(request, response);
			
			} else {
				
				session = request.getSession();
				
				session.setAttribute("hasErrors", true);
				session.setAttribute("isConnected", false);
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/login.jsp");
				rd.forward(request, response);
				
			}
			
		} catch (DALException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
