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
import eni.fr.bll.BLLException;
import eni.fr.bll.UtilisateurManager;
import eni.fr.bo.Utilisateur;

import eni.fr.dal.DALException;
import eni.fr.dal.UtilisateurDAO;
import eni.fr.dal.UtilisateurDAOJdbcImpl;

/**
 * Servlet implementation class signupServlet
 */
@WebServlet("/signUpServlet")
public class signUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/signUp.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pseudo;
		String nom;
		String prenom;
		String email;
		String telephone;
		String rue;
		String codePostal;
		String ville;
		String motDePasse;
		String motDePasseConfirme;
		String motDePasseActuel;
		int credit;
		boolean administrateur = false;
			
			try {
				pseudo = request.getParameter("pseudo");
				nom= request.getParameter("nom");
				prenom= request.getParameter("prenom");
				email= request.getParameter("email");
				telephone= request.getParameter("telephone");
				rue= request.getParameter("rue");
				codePostal= request.getParameter("cp");
				ville= request.getParameter("ville");
				motDePasseActuel = request.getParameter("mdpa");
				motDePasse = request.getParameter("mdp");
				motDePasseConfirme = request.getParameter("mdpc");
				

				
					
					int creditDeDepart = 100;
					UtilisateurManager utilisateurD=new UtilisateurManager();
					
					if(pseudo != null && nom != null && prenom != null && email != null && 
							telephone != null && rue != null && codePostal != null && ville != null
							&& motDePasse != null && motDePasseConfirme != null && motDePasse.equals(motDePasseConfirme))
					
					{
					
						Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue,
							 codePostal, ville, motDePasse, creditDeDepart, administrateur);
						
						HttpSession sessionACreer = request.getSession();
						sessionACreer.setAttribute("utilisateur", utilisateur);
						
						try {
							utilisateurD.ajouter(utilisateur);
							RequestDispatcher rd=request.getRequestDispatcher("/ServletRecherche");
							rd.forward(request, response);
						} catch (NumberFormatException e) {

							List<Integer> listeCodesErreur = new ArrayList<>();
							listeCodesErreur.add(CodesResultatServlets.UTILISATEUR_AJOUTER_ERREUR);
							request.setAttribute("listeCodesErreur", listeCodesErreur);
							RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/signUp.jsp");
							rd.forward(request, response);
						

						} catch (BusinessException | DALException e) {

							request.setAttribute("listeCodesErreur", ((BusinessException) e).getListeCodesErreur());
							RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/signUp.jsp");
							rd.forward(request, response);

						}						
						
					}
			
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
		
	}

}
