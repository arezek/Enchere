package eni.fr.ihm.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eni.fr.BusinessException;
import eni.fr.bll.EnchereManager;
import eni.fr.bo.ArticleVendu;
import eni.fr.bo.Enchere;
import eni.fr.bo.Retrait;
import eni.fr.bo.Utilisateur;
import eni.fr.dal.ArticleVenduDAO;
import eni.fr.dal.ArticleVenduDAOJdbcImpl;
import eni.fr.dal.DALException;
import eni.fr.dal.EnchereDAO;
import eni.fr.dal.EnchereDAOJdbcImpl;
import eni.fr.dal.RetraitDAO;
import eni.fr.dal.RetraitDAOJdbcImpl;

/**
 * Servlet implementation class ServletFicheProduit
 * @author Fabien M. Gavoille Zabaka fatima zahra FUCHS Eugénie
 * 
 */
@WebServlet("/ServletFicheProduit")
public class ServletFicheProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleVendu articleVendu= new ArticleVendu();   
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String numArticle;
		ServletContext context = this.getServletContext();
			
			try {
				numArticle = request.getParameter("noArticle") ;
				
				int numArticleInt =Integer.parseInt(numArticle);
				ArticleVenduDAO articleVenduManager = new ArticleVenduDAOJdbcImpl();
//				RetraitDAO retraitManager = new RetraitDAOJdbcImpl();
				
				articleVendu=(ArticleVendu)articleVenduManager.selectById(numArticleInt);
//				Retrait retraitAdress = retraitManager.selectById(numArticleInt);
						
						
			System.out.println(articleVendu.getEtatVente());
				request.setAttribute("articleVendu", articleVendu);
//				request.setAttribute("retraitAdress ", retraitAdress );
				
			} catch (NumberFormatException e) {

				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.ARTICLE_SELECT_ID_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);

			} catch (BusinessException | DALException e) {

				request.setAttribute("listeCodesErreur", ((BusinessException) e).getListeCodesErreur());
			}
	
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/ficheProduit.jsp");
			rd.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enchere enchere = new Enchere();
		String montant = request.getParameter("encherir");
//		int montantInt = Integer.parseInt(montant);
		enchere.setMontantEnchere(Integer.parseInt(montant));
		enchere.setDateEnchere(LocalDate.now());
		HttpSession session = request.getSession();
		Utilisateur utilisateurLogged = (Utilisateur)session.getAttribute("utilisateurLogged");
		enchere.setNoUtilisateur(utilisateurLogged);
		System.out.println(enchere.getNoUtilisateur().getNoUtilisateur());
		enchere.setNoArticle(articleVendu);
		System.out.println(enchere.getNoArticle().getNoArticle());
		EnchereManager articleVenduManager = new EnchereManager();
		try {
			articleVenduManager.ajouter(enchere);
		} catch (BusinessException | DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
