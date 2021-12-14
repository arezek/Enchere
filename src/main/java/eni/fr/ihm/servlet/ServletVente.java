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
import eni.fr.bo.Retrait;
import eni.fr.bo.Utilisateur;
import eni.fr.dal.ArticleVenduDAO;
import eni.fr.dal.ArticleVenduDAOJdbcImpl;
import eni.fr.dal.DALException;
import eni.fr.dal.RetraitDAO;
import eni.fr.dal.RetraitDAOJdbcImpl;
import eni.fr.dal.UtilisateurDAO;
import eni.fr.dal.UtilisateurDAOJdbcImpl;

/**
 * @author ZABAKA FATIMA ZAHRA
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
		HttpSession session=request.getSession();
		Utilisateur utilisateurLogged = (Utilisateur) session.getAttribute("utilisateurLogged");
		
		//commentaire
		String nomArticle;
		String description;
	//	Utilisateur noutilisateur=null;
		Categorie noCategorie = new Categorie();
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
			dateDebutEncheres= LocalDate.parse(request.getParameter("debutenchere"));
			dateFinEncheres=LocalDate.parse(request.getParameter("finenchere"));
			miseAPrix= Integer.parseInt(request.getParameter("miseaprix"));
			
			int no_categorie = Integer.parseInt(request.getParameter("no_categorie"));
			noCategorie.setNoCategorie(no_categorie);
			//int no_utilisateur = Integer.parseInt(request.getParameter("no_utilisateur"));
			String rue= request.getParameter("rue");
			String codePostal= request.getParameter("codePostal");
			String ville= request.getParameter("ville");
			ArticleVenduDAO articleVenduManager = new ArticleVenduDAOJdbcImpl();
			RetraitDAO retraitManager=new RetraitDAOJdbcImpl();
			
			if(nomArticle != null && description != null && miseAPrix != 0 && dateDebutEncheres != null && 
					dateFinEncheres != null && noCategorie != null && utilisateurLogged != null && rue != null && codePostal != null && ville != null )
			
			{
//				Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue,
//						 codePostal, ville, motDePasse, credit, administrateur);
//				
				ArticleVendu art =new ArticleVendu(nomArticle,description,dateDebutEncheres,dateFinEncheres,miseAPrix,noCategorie);
				art.setNoUtilisateur(utilisateurLogged);
				
				
				try {
					ArticleVendu Narticle =articleVenduManager.insert(art);
					Retrait retraitArticle=new Retrait(rue,codePostal,ville,Narticle);
					System.out.println(Narticle);
					//retraitArticle.getNoArticle().setNoArticle(Narticle);
				//	System.out.println(retraitArticle.getNoArticle().getNoArticle());
					retraitManager.insert(retraitArticle);
				} catch (DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(art.getNomArticle()+" "+art.getDescription()+" "+art.getDateDebutEncheres()+" "+art.getDateFinEncheres()+" "+art.miseAPrix+" ");
				
			}else if (nomArticle != null && description != null && miseAPrix != 0 && dateDebutEncheres != null && 
					dateFinEncheres != null && noCategorie != null && utilisateurLogged != null && rue==null && codePostal==null && ville==null) {
				ArticleVendu art =new ArticleVendu(nomArticle,description,dateDebutEncheres,dateFinEncheres,miseAPrix,noCategorie);
				art.setNoUtilisateur(utilisateurLogged);
				rue=utilisateurLogged.getRue();
				codePostal=utilisateurLogged.getCodePostal();
				ville=utilisateurLogged.getVille();
				
				Retrait retraitArticle=new Retrait(rue,codePostal,ville);
				try {
					articleVenduManager.insert(art);
					retraitManager.insert(retraitArticle);
				} catch (DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(art.getNomArticle()+" "+art.getDescription()+" "+art.getDateDebutEncheres()+" "+art.getDateFinEncheres()+" "+art.miseAPrix+" ");
				
				
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		
		
		doGet(request, response);
	}

}
