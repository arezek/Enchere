package eni.fr.ihm.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eni.fr.bo.ArticleVendu;
import eni.fr.bo.Enchere;
import eni.fr.bo.Utilisateur;

/**
 * Servlet implementation class EncheresServlet
 */
@WebServlet("/EncheresServlet")
public class EncheresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EncheresServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String montant = request.getParameter("encherir");
		Enchere enchere = new Enchere();
		enchere.setDateEnchere(LocalDate.now());
		HttpSession session = request.getSession();
		Utilisateur utilisateurLogged = (Utilisateur)session.getAttribute("utilisateurLogged");
		enchere.setNoUtilisateur(utilisateurLogged);
		String noArticle = (String) request.getAttribute("numArticle");
		System.out.println(noArticle);
		ArticleVendu article = new ArticleVendu();
		
		}

}
