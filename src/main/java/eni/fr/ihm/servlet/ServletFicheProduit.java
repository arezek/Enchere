package eni.fr.ihm.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eni.fr.bo.ArticleVendu;
import eni.fr.dal.ArticleVenduDAO;
import eni.fr.dal.ArticleVenduDAOJdbcImpl;
import eni.fr.dal.DALException;

/**
 * Servlet implementation class ServletFicheProduit
 * @author Fabien M. Gavoille 
 * @author Zabaka fatima zahra 
 */
@WebServlet("/ServletFicheProduit")
public class ServletFicheProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String numArticle;
		
			
			try {
				numArticle = request.getParameter("noArticle") ;
				
				int numArticleInt =Integer.parseInt(numArticle);
				ArticleVenduDAO articleVenduManager = new ArticleVenduDAOJdbcImpl();
				ArticleVendu articleVendu=(ArticleVendu)articleVenduManager.selectById(numArticleInt);
			System.out.println(articleVendu.getEtatVente());
				request.setAttribute("articleVendu", articleVendu);
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
//		catch(NumberFormatException e)
//		{
//			List<Integer> listeCodesErreur=new ArrayList<>();
//			listeCodesErreur.add(CodesResultatServlets.FORMAT_AVIS_NOTE_ERREUR);
//			request.setAttribute("listeCodesErreur",listeCodesErreur);}
		
		
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/ficheProduit.jsp");
			rd.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
