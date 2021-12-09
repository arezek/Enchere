package eni.fr.ihm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eni.fr.bo.Utilisateur;
import eni.fr.dal.UtilisateurDAOJdbcImpl;

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
		
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if (action == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			if (action.equalsIgnoreCase("logout")) {
				session.removeAttribute("identifiant");
				response.sendRedirect("account");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String identifiant = request.getParameter("identifiant").trim();
		String motDePasse = request.getParameter("mdp").trim();
		if (identifiant.equalsIgnoreCase("Iwyn") && motDePasse.equalsIgnoreCase("heartless")) {
			session.setAttribute("identifiant", identifiant);
			request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "Invalid Account");
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}
}
