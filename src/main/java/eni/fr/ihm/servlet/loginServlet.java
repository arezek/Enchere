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
		RequestDispatcher rd = null;

		boolean cookiePresent = false;

		// On vérifie la présence du cookie de connexion
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("connexion") && cookie.getValue().equals("ok")) {
					cookiePresent = true;
				}
			}
		}

		// On redirige en fonction de la présence du cookie
		if (cookiePresent) {
			rd = request.getRequestDispatcher("WEB-INF/accueil.jsp");
		} else {
			rd = request.getRequestDispatcher("WEB-INF/login.jsp");
		}
		rd.forward(request, response);	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;

		// récupérer les identifiants et les stocker dans la variable de session
		String pseudo = request.getParameter("identifiant");
		String motDePasse = request.getParameter("mdp");
		
		
		if (pseudo.equals("identifiant") && motDePasse.equals("mdp")) {
			if (request.getParameter("souvenirDeMoi") != null) {
				if (request.getParameter("souvenirDeMoi").equals("ok")) {
					Cookie cookie = new Cookie("connexion", "ok");
					cookie.setMaxAge(7 * 24 * 60 * 60);
					response.addCookie(cookie);
				}
			}

			rd = request.getRequestDispatcher("WEB-INF/accueil.jsp");
		} else {

			rd = request.getRequestDispatcher("WEB-INF/login.jsp");
		}

		
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
				rd=request.getRequestDispatcher("ServletRecherche");
				rd.forward(request, response);
			
			} else {
				
				session = request.getSession();
				
				session.setAttribute("hasErrors", true);
				session.setAttribute("isConnected", false);
				rd=request.getRequestDispatcher("/WEB-INF/login.jsp");
				rd.forward(request, response);
				
			}
			
		} catch (DALException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
