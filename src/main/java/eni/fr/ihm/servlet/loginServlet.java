package eni.fr.ihm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		UtilisateurDAO utilisateurValidation = new UtilisateurDAOJdbcImpl();
		HttpSession session;
		
		try {
			Utilisateur utilisateur = (Utilisateur) utilisateurValidation.selectByPseudo(pseudo);
			
			if(motDePasse.equals(utilisateur.getMotDePasse())) {
				
				session = request.getSession();
				System.out.println("wééééé sa marche");
				//ServletContext context = this.getServletContext();
				//Utilisateur utilisateurEnSession = (Utilisateur) request.getAttribute(pseudo);
				
//				session.setAttribute("isConnected", true);
				
				//int hc = utilisateurEnSession.getIdSession().hashCode();
//				session.setAttribute("utilisateur", utilisateur);
				
				//session.setAttribute("identifiant", pseudo);
				
				// redirect l'utilisateur vers la page d'accueil
				response.sendRedirect("/WEB-INF/accueil.jsp");
//				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/accueil.jsp");
//				rd.forward(request, response);
			
			} else {
				
				
				System.out.println("gnéééééé sa marchepo");
//				session.setAttribute("hasErrors", true);
//				session.setAttribute("isConnected", false);
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/login.jsp");
				rd.forward(request, response);
				
			}
			
		} catch (DALException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
