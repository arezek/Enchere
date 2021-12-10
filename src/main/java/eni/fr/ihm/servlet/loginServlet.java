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

/**
 * Servlet implementation class loginServlet
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
		
		
		// récupérer les identifiatns et les stocker dans la variable de session
		String pseudo = request.getParameter("identifiant");
		String motDePasse = request.getParameter("mdp");
		
		HttpSession session = request.getSession(true);
		
		ServletContext context = getServletContext();
		Utilisateur utilisateurEnSession = (Utilisateur)context.getAttribute(pseudo);
		
		// utilisateur n'existe pas ou mauvais mdp
		if(utilisateurEnSession == null || !motDePasse.equals(utilisateurEnSession.getMotDePasse())) {
			
			session.setAttribute("hasErrors", true);
			session.setAttribute("isConnected", false);
			
			// redirect to login page
			
			response.sendRedirect("login.jsp");
			
		} else if (motDePasse.equals(utilisateurEnSession.getMotDePasse())) {
			
			session.setAttribute("isConnected", true);
			//int hc = utilisateurEnSession.getIdSession().hashCode();
			session.setAttribute(pseudo, "identifiant");
			
			// redirect l'utilisateur vers la page d'accueil
			response.sendRedirect("accueil.jsp");
			
		}
		
		
		session.setAttribute("identifiant", pseudo);
		
		// utilisation et redirection des identifiants dans accueil.jsp
		RequestDispatcher rd2=request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd2.forward(request, response);

	}
	
}
