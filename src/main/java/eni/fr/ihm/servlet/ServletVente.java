package eni.fr.ihm.servlet;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import eni.fr.BusinessException;
import eni.fr.bll.ArticleVenduManager;
import eni.fr.bll.RetraitManager;
import eni.fr.bo.ArticleVendu;
import eni.fr.bo.Categorie;
import eni.fr.bo.Utilisateur;

/**
 * @author ZABAKA FATIMA ZAHRA GAVOILLE FABIEN ALLIOUCHE KERBOUA ABDELREZAK FUCHS EUGENIE
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100) // 100 MB
@WebServlet("/ServletVente")
public class ServletVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String IMAGES_FOLDER = "C://Users/vmware/Documents/JavaProject/ENI-Encheres/src/main/webapp/img/ArticlesPhotos/";
	// C://Users/eugen/git/Enchere/src/main/webapp/img/ArticlesPhotos/ Eugenie
	// C://Users/Pc/git/Enchere/src/main/webapp/img/ArticlesPhotos/ Fatima
	// C://Users/vmware/Documents/JavaProject/ENI-Encheres/src/main/webapp/img/ArticlesPhotos/
	// Abdel

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Vente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur utilisateurLogged = (Utilisateur) session.getAttribute("utilisateurLogged");

		// commentaire
		String nomArticle;
		String description;
		// Utilisateur noutilisateur=null;
		Categorie noCategorie = new Categorie();
		// photo
		int miseAPrix;
		LocalDate dateDebutEncheres;
		LocalDate dateFinEncheres;
		// rue
		// codepostal
		// ville
		Part filePart = request.getPart("photo");
		try {
			nomArticle = request.getParameter("article");
			description = request.getParameter("description");
			dateDebutEncheres = LocalDate.parse(request.getParameter("debutenchere"));
			dateFinEncheres = LocalDate.parse(request.getParameter("finenchere"));
			miseAPrix = Integer.parseInt(request.getParameter("miseaprix"));

			int no_categorie = Integer.parseInt(request.getParameter("no_categorie"));
			noCategorie.setNoCategorie(no_categorie);
			// int no_utilisateur =
			// Integer.parseInt(request.getParameter("no_utilisateur"));
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			ArticleVenduManager articleVenduManager = new ArticleVenduManager();
			RetraitManager retraitManager = new RetraitManager();

//			noArticle= request.getParameter("article");

			if (nomArticle != null && description != null && miseAPrix != 0 && dateDebutEncheres != null
					&& dateFinEncheres != null && noCategorie != null && utilisateurLogged != null && rue != null
					&& codePostal != null && ville != null /* && filePart != null */)

			{
//				Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue,
//						 codePostal, ville, motDePasse, credit, administrateur);
//				
				// ArticleVendu art =new
				// ArticleVendu(nomArticle,description,dateDebutEncheres,dateFinEncheres,miseAPrix,noCategorie);
				// art.setNoUtilisateur(utilisateurLogged);

				try {
					ArticleVendu Narticle = articleVenduManager.ajouter(nomArticle, description, dateDebutEncheres,
							dateFinEncheres, miseAPrix, utilisateurLogged, noCategorie);
					String fileName = Narticle.getNoArticle() + ".jpg";
					filePart.write(IMAGES_FOLDER + fileName);
					System.out.println(fileName);
					// retraitArticle.getNoArticle().setNoArticle(Narticle);
					// System.out.println(retraitArticle.getNoArticle().getNoArticle());

					retraitManager.ajouter(rue, codePostal, ville, Narticle);

				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println(art.getNomArticle()+" "+art.getDescription()+"
				// "+art.getDateDebutEncheres()+" "+art.getDateFinEncheres()+" "+art.miseAPrix+"
				// ");

			} else if (nomArticle != null && description != null && miseAPrix != 0 && dateDebutEncheres != null
					&& dateFinEncheres != null && noCategorie != null && utilisateurLogged != null && rue == null
					&& codePostal == null && ville == null /* && filePart != null */) {
				ArticleVendu art = new ArticleVendu(nomArticle, description, dateDebutEncheres, dateFinEncheres,
						miseAPrix, noCategorie);
				art.setNoUtilisateur(utilisateurLogged);
				rue = utilisateurLogged.getRue();
				codePostal = utilisateurLogged.getCodePostal();
				ville = utilisateurLogged.getVille();

				try {
					articleVenduManager.ajouter(nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix,
							utilisateurLogged, noCategorie);
					retraitManager.ajouter(rue, codePostal, ville, art);
//					filePart.write(IMAGES_FOLDER + fileName);

				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(art.getNomArticle() + " " + art.getDescription() + " " + art.getDateDebutEncheres()
						+ " " + art.getDateFinEncheres() + " " + art.miseAPrix + " ");

			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Vente.jsp");
		rd.forward(request, response);

	}

}
