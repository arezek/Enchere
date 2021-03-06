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

import eni.fr.BusinessException;
import eni.fr.bll.UtilisateurManager;
import eni.fr.bo.Utilisateur;
import eni.fr.dal.DALException;
import eni.fr.dal.UtilisateurDAO;
import eni.fr.dal.UtilisateurDAOJdbcImpl;

/**
 * Servlet implementation class profilServlet
 * @author Fabien M. Gavoille et Eugénie FUCHS
 */
@WebServlet("/profilServlet")
public class profilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String numUtilisateur;
		
			
			try { 
				numUtilisateur = request.getParameter("noUtilisateur") ;
				
				int numArticleInt =Integer.parseInt(numUtilisateur);
				UtilisateurManager utilisateurManager = new UtilisateurManager();
				Utilisateur utilisateur=(Utilisateur)utilisateurManager.selectById(numArticleInt);
			System.out.println(utilisateur.getPrenom());
				request.setAttribute("utilisateur", utilisateur);
				
			} catch (NumberFormatException e) {

				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.UTILISATEUR_SELECT_ID_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);

			} catch (BusinessException | DALException e) {

				request.setAttribute("listeCodesErreur", ((BusinessException) e).getListeCodesErreur());
			}
			
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/profil.jsp");
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
