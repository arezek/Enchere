package eni.fr.ihm.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eni.fr.bo.ArticleVendu;
import eni.fr.bo.Utilisateur;
import eni.fr.dal.ArticleVenduDAO;
import eni.fr.dal.ArticleVenduDAOJdbcImpl;
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
		int credit = 100;
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
				motDePasse = request.getParameter("mdp");
				motDePasseConfirme = request.getParameter("mdpc");
				UtilisateurDAO utilisateurD=new UtilisateurDAOJdbcImpl();
				
				if(pseudo != null && nom != null && prenom != null && email != null && 
						telephone != null && rue != null && codePostal != null && ville != null
						&& motDePasse != null && motDePasseConfirme != null && motDePasse.equals(motDePasseConfirme))
				
				{
					
					Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue,
						 codePostal, ville, motDePasse, credit, administrateur);
					
					HttpSession session = request.getSession();
					session.setAttribute("utilisateur", utilisateur);
					
					try {
						utilisateurD.insert(utilisateur);
					} catch (DALException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					
				
					System.out.println(utilisateur.getNom()+" "+utilisateur.getRue()+" "+utilisateur.getPrenom()+" "+utilisateur.getEmail()+" "+utilisateur.getTelephone()+" ");
					
				}
				
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
	}

}
