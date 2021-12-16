package eni.fr.ihm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eni.fr.BusinessException;
import eni.fr.bll.ArticleVenduManager;
import eni.fr.bo.ArticleVendu;
import eni.fr.dal.ArticleVenduDAO;
import eni.fr.dal.ArticleVenduDAOJdbcImpl;
import eni.fr.dal.DALException;

/**
 * Servlet implementation class ServletRecherche
 */
@WebServlet("/ServletRecherche")
public class ServletRecherche extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String rechercherNom;
		String rechercherCategories;

		HttpSession session = request.getSession();
		session.getAttribute("utilisateurLogged");

		rechercherNom = request.getParameter("rechercherNom");
		rechercherCategories = request.getParameter("rechercherCategories");
		ArticleVenduManager articleVenduManager = new ArticleVenduManager();
		List<ArticleVendu> listeArticles;

		try {
			if (rechercherNom == null && rechercherCategories == null) {

				listeArticles = (List<ArticleVendu>) articleVenduManager.selectAll();
				request.setAttribute("listeArticles", listeArticles);
			}

		} catch (NumberFormatException e) {

			List<Integer> listeCodesErreur = new ArrayList<>();
			listeCodesErreur.add(CodesResultatServlets.ARTICLE_SELECT_ALL_ERREUR);
			request.setAttribute("listeCodesErreur", listeCodesErreur);

		} catch (BusinessException e) {

			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
		}

		try {
			if (rechercherNom != null && rechercherCategories != null) {

				listeArticles = (List<ArticleVendu>) articleVenduManager.rechercher(rechercherNom,
						Integer.parseInt(rechercherCategories));
				request.setAttribute("listeArticles", listeArticles);
			}

		} catch (NumberFormatException e) {

			List<Integer> listeCodesErreur = new ArrayList<>();
			listeCodesErreur.add(CodesResultatServlets.ARTICLE_RECHERCHE_ERREUR);
			request.setAttribute("listeCodesErreur", listeCodesErreur);

		} catch (BusinessException e) {

			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
