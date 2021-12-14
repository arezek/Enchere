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
				
				HttpSession session=request.getSession();
				session.getAttribute("utilisateurLogged");
				
				if (session == null) {
					
					System.out.println("une session a été créée");
					
					int creditDeDepart = 100;
					UtilisateurDAO utilisateurD=new UtilisateurDAOJdbcImpl();
					
					if(pseudo != null && nom != null && prenom != null && email != null && 
							telephone != null && rue != null && codePostal != null && ville != null
							&& motDePasse != null && motDePasseConfirme != null && motDePasse.equals(motDePasseConfirme))
					
					{
						
						Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue,
							 codePostal, ville, motDePasse, creditDeDepart, administrateur);
						
						HttpSession sessionACreer = request.getSession();
						session.setAttribute("utilisateur", utilisateur);
						
						try {
							utilisateurD.insert(utilisateur);
						} catch (DALException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						System.out.println(utilisateur.getNom()+" "+utilisateur.getRue()+" "+utilisateur.getPrenom()+" "+utilisateur.getEmail()+" "+utilisateur.getTelephone()+" ");
						
					}
				} else {
					
					System.out.println("une session est en cours, on essaie de faire un update");
					
					UtilisateurDAO utilisateurD=new UtilisateurDAOJdbcImpl();
					Utilisateur utilisateur = new Utilisateur();
					credit = utilisateur.getCredit();
					
//					if (motDePasseConfirme != null && motDePasseActuel.equals(utilisateur.getMotDePasse()) &&
//							motDePasse.equals(motDePasseConfirme))
		
					if (pseudo == null || nom == null || prenom == null || email == null || telephone == null
							|| rue == null || codePostal == null || ville == null || motDePasseActuel == null ||
							motDePasseActuel != null && motDePasse.equals(motDePasseConfirme))
						
						
						
						utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue,
							 codePostal, ville, motDePasse, credit, administrateur);
					
						
						try {
							utilisateurD.update(utilisateur);
						} catch (DALException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						System.out.println(utilisateur.getNom()+" "+utilisateur.getRue()+" "+utilisateur.getPrenom()+" "+utilisateur.getEmail()+" "+utilisateur.getTelephone()+" ");
					
				}
				
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
			RequestDispatcher rd=request.getRequestDispatcher("/ServletRecherche");
			rd.forward(request, response);
	}

}
