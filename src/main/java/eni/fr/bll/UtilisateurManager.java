package eni.fr.bll;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eni.fr.BusinessException;
import eni.fr.bo.Utilisateur;
import eni.fr.dal.DALException;
import eni.fr.dal.DAOFactory;
import eni.fr.dal.UtilisateurDAO;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;

	public UtilisateurManager() {

		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();

	}

	// lors d'un insert
	public Utilisateur ajouter(Utilisateur utilisateur) throws BusinessException, DALException {

		BusinessException exception = new BusinessException();

//		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue,
//			 codePostal, ville, motDePasse, credit, administrateur);

		this.validerPseudo(utilisateur, exception);
		this.validerNom(utilisateur, exception);
		this.validerPrenom(utilisateur, exception);
		this.validerEmail(utilisateur, exception);
		this.validerTelephone(utilisateur, exception);
		this.validerRue(utilisateur, exception);
		this.validerCodePostal(utilisateur, exception);
		this.validerVille(utilisateur, exception);
		this.validerMotDePasse(utilisateur, exception);
		this.validerCredit(utilisateur, exception);
		// this.validerAdministrateur(utilisateur, exception);

		if (!exception.hasErreurs()) {

			try {

				this.utilisateurDAO.insert(utilisateur);

			} catch (DALException e) {

				e.printStackTrace();

			}

		}

		if (exception.hasErreurs()) {

			throw exception;

		}

		return utilisateur;
	}

	// lors d'un update

	public Utilisateur modifier(String champs, String valeur, Utilisateur utilisateurRecup)
			throws BusinessException, DALException {

		BusinessException exception = new BusinessException();

		if (champs.equals("pseudo")) {
			int taillePseudo = valeur.length();

			int compteur = this.utilisateurDAO.selectCountByPseudo(valeur);

			if (valeur == null || taillePseudo > 30 || compteur > 0) {
				exception.ajouterErreur(CodesResultatBLL.UTILISATEUR_PSEUDO_ERREUR);

			} else {
				this.utilisateurDAO.update(champs, valeur, utilisateurRecup);
			}
		} else if (champs.equals("nom")) {
			int tailleNom = valeur.length();

			if (valeur == null || tailleNom > 30) {

				exception.ajouterErreur(CodesResultatBLL.UTILISATEUR_NOM_ERREUR);

			} else {
				this.utilisateurDAO.update(champs, valeur, utilisateurRecup);
			}
		} else if (champs.equals("prenom")) {
			int taillePrenom = valeur.length();

			if (valeur == null || taillePrenom > 30) {

				exception.ajouterErreur(CodesResultatBLL.UTILISATEUR_PRENOM_ERREUR);
			} else {
				this.utilisateurDAO.update(champs, valeur, utilisateurRecup);
			}
		} else if (champs.equals("email")) {
			int tailleEmail = valeur.length();
			String regex = "^[a-z0-9+_.-]+@(.+)$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(valeur);

			if (valeur == null || !matcher.matches() || tailleEmail > 20) {

				exception.ajouterErreur(CodesResultatBLL.UTILISATEUR_EMAIL_ERREUR);

			} else {
				this.utilisateurDAO.update(champs, valeur, utilisateurRecup);
			}
		} else if (champs.equals("telephone")) {
			int tailleTelephone = valeur.length();
			String regex = "^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(valeur);

			if (valeur == null || !matcher.matches() || tailleTelephone > 15) {

				exception.ajouterErreur(CodesResultatBLL.UTILISATEUR_TELEPHONE_ERREUR);

			} else {
				this.utilisateurDAO.update(champs, valeur, utilisateurRecup);
			}
		} else if (champs.equals("rue")) {
			int tailleRue = valeur.length();

			if (valeur == null || tailleRue > 30) {

				exception.ajouterErreur(CodesResultatBLL.UTILISATEUR_RUE_ERREUR);

			} else {
				this.utilisateurDAO.update(champs, valeur, utilisateurRecup);
			}
		} else if (champs.equals("codePostal")) {
			int tailleCodePostal = valeur.length();

			if (valeur == null || tailleCodePostal > 10) {

				exception.ajouterErreur(CodesResultatBLL.UTILISATEUR_CODE_POSTAL_ERREUR);

			} else {
				this.utilisateurDAO.update(champs, valeur, utilisateurRecup);
			}
		} else if (champs.equals("ville")) {
			int tailleVille = valeur.length();

			if (valeur == null || tailleVille > 30) {

				exception.ajouterErreur(CodesResultatBLL.UTILISATEUR_VILLE_ERREUR);

			} else {
				this.utilisateurDAO.update(champs, valeur, utilisateurRecup);
			}
		} else if (champs.equals("mot_de_passe")) {
			int tailleMotDePasse = valeur.length();

			if (valeur == null || tailleMotDePasse > 30) {

				exception.ajouterErreur(CodesResultatBLL.UTILISATEUR_MOT_DE_PASSE_ERREUR);

			} else {
				this.utilisateurDAO.update(champs, valeur, utilisateurRecup);
			}
		} else if (champs.equals("credit")) {
			if (Integer.parseInt(valeur) <= 0) {

				exception.ajouterErreur(CodesResultatBLL.UTILISATEUR_CREDIT_ERREUR);

			} else {
				this.utilisateurDAO.update(champs, valeur, utilisateurRecup);
			}
		}

		return utilisateurRecup;
	}

	// lors d'une suppression de compte
	public void supprimer(int noUtilisateur) throws BusinessException, DALException {

		BusinessException exception = new BusinessException();

		if (!exception.hasErreurs()) {

			try {

				this.utilisateurDAO.delete(noUtilisateur);

			} catch (DALException e) {

				e.printStackTrace();

			}

		}

		if (exception.hasErreurs()) {

			throw exception;

		}
	}

	// lorsqu'on affiche un profil
	public Utilisateur selectById(int id) throws DALException, BusinessException {
		Utilisateur utilisateur = new Utilisateur();
		BusinessException exception = new BusinessException();
		if (id < 1) {

			exception.ajouterErreur(CodesResultatBLL.UTILISATEUR_CREDIT_ERREUR);

		} else {
			utilisateur = this.utilisateurDAO.selectById(id);
		}
		return utilisateur;
	}

	// lors de la connexion
	public Utilisateur selectByPseudo(String pseudo) throws DALException, BusinessException {
		Utilisateur utilisateur = new Utilisateur();
		BusinessException exception = new BusinessException();
		int taillePseudo = pseudo.length();
		int compteur = this.utilisateurDAO.selectCountByPseudo(pseudo);
		if (pseudo == null || taillePseudo > 30 || compteur > 0) {

			exception.ajouterErreur(CodesResultatBLL.UTILISATEUR_PSEUDO_ERREUR);

		} else {
			utilisateur = this.utilisateurDAO.selectByPseudo(pseudo);
		}
		return utilisateur;
	}

	private void validerPseudo(Utilisateur utilisateur, BusinessException businessException)
			throws DALException, BusinessException {

		String pseudo = utilisateur.getPseudo();
		int taillePseudo = pseudo.length();

		int compteur = this.utilisateurDAO.selectCountByPseudo(pseudo);

		if (pseudo == null || taillePseudo > 30 || compteur > 0) {

			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_PSEUDO_ERREUR);

		}

	}

	private void validerNom(Utilisateur utilisateur, BusinessException businessException) {

		String nom = utilisateur.getNom();
		int tailleNom = nom.length();

		if (nom == null || tailleNom > 30) {

			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_NOM_ERREUR);

		}

	}

	private void validerPrenom(Utilisateur utilisateur, BusinessException businessException) {

		String prenom = utilisateur.getPrenom();
		int taillePrenom = prenom.length();

		if (prenom == null || taillePrenom > 30) {

			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_PRENOM_ERREUR);

		}

	}

	private void validerEmail(Utilisateur utilisateur, BusinessException businessException) {

		String email = utilisateur.getEmail();
		int tailleEmail = email.length();
		String regex = "^[a-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		if (email == null || !matcher.matches() || tailleEmail > 20) {

			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_EMAIL_ERREUR);

		}

	}

	private void validerTelephone(Utilisateur utilisateur, BusinessException businessException) {

		String telephone = utilisateur.getTelephone();
		int tailleTelephone = telephone.length();
		String regex = "^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(telephone);

		if (telephone == null || !matcher.matches() || tailleTelephone > 15) {

			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_TELEPHONE_ERREUR);

		}

	}

	private void validerRue(Utilisateur utilisateur, BusinessException businessException) {

		String rue = utilisateur.getRue();
		int tailleRue = rue.length();

		if (rue == null || tailleRue > 30) {

			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_RUE_ERREUR);

		}

	}

	private void validerCodePostal(Utilisateur utilisateur, BusinessException businessException) {

		String codePostal = utilisateur.getCodePostal();
		int tailleCodePostal = codePostal.length();

		if (codePostal == null || tailleCodePostal > 10) {

			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_CODE_POSTAL_ERREUR);

		}

	}

	private void validerVille(Utilisateur utilisateur, BusinessException businessException) {

		String ville = utilisateur.getVille();
		int tailleVille = ville.length();

		if (ville == null || tailleVille > 30) {

			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_VILLE_ERREUR);

		}

	}

	private void validerMotDePasse(Utilisateur utilisateur, BusinessException businessException) {

		String motDePasse = utilisateur.getMotDePasse();
		int tailleMotDePasse = motDePasse.length();

		if (utilisateur.getMotDePasse() == null || tailleMotDePasse > 30) {

			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_MOT_DE_PASSE_ERREUR);

		}

	}

	private void validerCredit(Utilisateur utilisateur, BusinessException businessException) {

		if (utilisateur.getCredit() <= 0) {

			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_CREDIT_ERREUR);

		}

	}
//	private void validerAdministrateur (Utilisateur utilisateur, BusinessException businessException) {
//		
//		if(utilisateur.getAdministrateur() == true) {
//			
//			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_ADMINISTRATEUR_ERREUR);
//			
//		}
//		
//		}

}
