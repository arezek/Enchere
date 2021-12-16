package eni.fr.ihm.servlet;

import java.io.IOException;

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
 * Servlet implementation class Suppression
 */
@WebServlet("/Suppression")
public class Suppression extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("deleteButton");
		HttpSession session = request.getSession();
		
		session=request.getSession();
		Utilisateur utilisateurRecup = (Utilisateur) session.getAttribute("utilisateurLogged");
		UtilisateurManager utilisateurD=new UtilisateurManager();
		
		int noUtilisateurASupprimer = utilisateurRecup.getNoUtilisateur();
		try {
			utilisateurD.supprimer(noUtilisateurASupprimer);
		} catch (BusinessException | DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.invalidate();
		
		RequestDispatcher rd=request.getRequestDispatcher("/ServletRecherche");
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
