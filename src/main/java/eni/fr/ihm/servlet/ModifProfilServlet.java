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
import eni.fr.bll.UtilisateurManager;
import eni.fr.bo.Utilisateur;
import eni.fr.dal.DALException;


/**
 * Servlet implementation class ModifProfilServlet
 */
@WebServlet("/ModifProfilServlet")
public class ModifProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/modifier.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		HttpSession session = request.getSession();
		
		session=request.getSession();
		Utilisateur utilisateurRecup = (Utilisateur) session.getAttribute("utilisateurLogged");
		
		System.out.println("une session est en cours, on essaie de faire un update");
		
		UtilisateurManager utilisateurD=new UtilisateurManager();
		
		credit = utilisateurRecup.getCredit();
		utilisateurRecup.getNoUtilisateur();
		String champs;
		String valeur = null;

		if (!pseudo.equals("")) {
				
			champs = "pseudo";
			valeur = request.getParameter("pseudo");

			try {
				//utilisateurD.update(champs, valeur, utilisateurRecup);
				utilisateurD.modifier(champs, valeur, utilisateurRecup);
			} catch (NumberFormatException e) {

				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.UTILISATEUR_UPDATE_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);

			} catch (BusinessException | DALException e) {

				request.setAttribute("listeCodesErreur", ((BusinessException) e).getListeCodesErreur());
			}	
			
		}
			
		if (!nom.equals("")) {
				
			champs = "nom";
			valeur = request.getParameter("nom");

			try {
				//utilisateurD.update(champs, valeur, utilisateurRecup);
				utilisateurD.modifier(champs, valeur, utilisateurRecup);
			} catch (NumberFormatException e) {

				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.UTILISATEUR_UPDATE_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);

			} catch (BusinessException | DALException e) {

				request.setAttribute("listeCodesErreur", ((BusinessException) e).getListeCodesErreur());
			}	
			
		}
		
		if (!prenom.equals("")) {
			
			champs = "prenom";
			valeur = request.getParameter("prenom");

			try {
				//utilisateurD.update(champs, valeur, utilisateurRecup);
				utilisateurD.modifier(champs, valeur, utilisateurRecup);
			} catch (NumberFormatException e) {

				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.UTILISATEUR_UPDATE_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);

			} catch (BusinessException | DALException e) {

				request.setAttribute("listeCodesErreur", ((BusinessException) e).getListeCodesErreur());
			}	
			
		}
		
		if (!email.equals("")) {
			
			champs = "email";
			valeur = request.getParameter("email");

			try {
				//utilisateurD.update(champs, valeur, utilisateurRecup);
				utilisateurD.modifier(champs, valeur, utilisateurRecup);
			} catch (NumberFormatException e) {

				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.UTILISATEUR_UPDATE_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);

			} catch (BusinessException | DALException e) {

				request.setAttribute("listeCodesErreur", ((BusinessException) e).getListeCodesErreur());
			}	
			
		}
		
		if (!telephone.equals("")) {
			
			champs = "telephone";
			valeur = request.getParameter("telephone");

			try {
				//utilisateurD.update(champs, valeur, utilisateurRecup);
				utilisateurD.modifier(champs, valeur, utilisateurRecup);
			} catch (NumberFormatException e) {

				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.UTILISATEUR_UPDATE_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);

			} catch (BusinessException | DALException e) {

				request.setAttribute("listeCodesErreur", ((BusinessException) e).getListeCodesErreur());
			}	
			
		}
		
		if (!rue.equals("")) {
			
			champs = "rue";
			valeur = rue;
			System.out.println(valeur);
			System.out.println(utilisateurRecup.getNoUtilisateur());
			try {
				//utilisateurD.update(champs, valeur, utilisateurRecup);
				utilisateurD.modifier(champs, valeur, utilisateurRecup);
			} catch (NumberFormatException e) {

				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.UTILISATEUR_UPDATE_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);

			} catch (BusinessException | DALException e) {

				request.setAttribute("listeCodesErreur", ((BusinessException) e).getListeCodesErreur());
			}	
			
		}
		
		if (!codePostal.equals("")) {
			
			champs = "codePostal";
			valeur = request.getParameter("cp");

			try {
				//utilisateurD.update(champs, valeur, utilisateurRecup);
				utilisateurD.modifier(champs, valeur, utilisateurRecup);
			} catch (NumberFormatException e) {

				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.UTILISATEUR_UPDATE_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);

			} catch (BusinessException | DALException e) {

				request.setAttribute("listeCodesErreur", ((BusinessException) e).getListeCodesErreur());
			}	
			
		}
		
		if (!ville.equals("")) {
			
			champs = "ville";
			valeur = request.getParameter("ville");

			try {
				//utilisateurD.update(champs, valeur, utilisateurRecup);
				utilisateurD.modifier(champs, valeur, utilisateurRecup);
			} catch (NumberFormatException e) {

				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.UTILISATEUR_UPDATE_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);

			} catch (BusinessException | DALException e) {

				request.setAttribute("listeCodesErreur", ((BusinessException) e).getListeCodesErreur());
			}	
			
		}
		
		if (!motDePasseActuel.equals("") && !motDePasse.equals("") && !motDePasseConfirme.equals("") && motDePasse.equals(motDePasseConfirme)
				&& motDePasseActuel.equals(utilisateurRecup.getMotDePasse())) {
			
			champs = "mot_de_passe";
			valeur = request.getParameter("mdp");

			try {
				//utilisateurD.update(champs, valeur, utilisateurRecup);
				utilisateurD.modifier(champs, valeur, utilisateurRecup);
			} catch (NumberFormatException e) {

				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.UTILISATEUR_UPDATE_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);

			} catch (BusinessException | DALException e) {

				request.setAttribute("listeCodesErreur", ((BusinessException) e).getListeCodesErreur());
			}	
			
		}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
			RequestDispatcher rd=request.getRequestDispatcher("/ServletRecherche");
			rd.forward(request, response);
			
	}
	
}
