package eni.fr.ihm.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eni.fr.bo.ArticleVendu;
import eni.fr.bo.Categorie;
import eni.fr.bo.Utilisateur;
import eni.fr.dal.ArticleVenduDAO;
import eni.fr.dal.ArticleVenduDAOJdbcImpl;
import eni.fr.dal.DALException;
import eni.fr.dal.UtilisateurDAO;
import eni.fr.dal.UtilisateurDAOJdbcImpl;
import fr.eni.javaee.suividesrepas.BusinessException;
import fr.eni.javaee.suividesrepas.bll.RepasManager;

/**
 * Servlet implementation class ServletVente
 */
@WebServlet("/ServletVente")
public class ServletVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Vente.jsp");
		rd.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomArticle;
		String description;
		Categorie noCategorie;
		//photo
		int miseAPrix;
		LocalDate dateDebutEncheres;
		LocalDate dateFinEncheres;
		//rue
		//codepostal
		//ville
		
		try {
			nomArticle= request.getParameter("article");
			description= request.getParameter("description");
			miseAPrix= Integer.parseInt(request.getParameter("miseaprix"));
			dateDebutEncheres= LocalDate.parse(request.getParameter("debutenchere"));
			dateFinEncheres=LocalDate.parse(request.getParameter("finenchere"));
			Class<Categorie> categorie =Class.forName(request.getParameter("categories"));
//			String rue= request.getParameter("rue");
//			String codepostal= request.getParameter("codepostal");
//			String ville= request.getParameter("ville");
			ArticleVenduDAO articleVenduManager = new ArticleVenduDAOJdbcImpl();
			
			if(nomArticle != null && description != null && miseAPrix != 0 && dateDebutEncheres != null && 
					dateFinEncheres != null && noCategorie != null )
			
			{
//				Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue,
//						 codePostal, ville, motDePasse, credit, administrateur);
//				
				ArticleVendu art =new ArticleVendu(nomArticle,description,dateDebutEncheres,dateFinEncheres,miseAPrix,noCategorie);
						
	
			}
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		
		
		doGet(request, response);
	}

}
