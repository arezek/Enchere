package eni.fr.bll;

import java.time.LocalDate;

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
	
	public Utilisateur ajouter(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit, boolean administrateur) throws BusinessException {
		
		BusinessException exception = new BusinessException();
		
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue,
			 codePostal, ville, motDePasse, credit, administrateur);
		
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
		//this.validerAdministrateur(utilisateur, exception);
		
		if(!exception.hasErreurs()) {
			
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
	
	private void validerPseudo (Utilisateur utilisateur, BusinessException businessException) {
		
		if(utilisateur.getPseudo() == null) {
			
			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_PSEUDO_ERREUR);
			
		}
		
	}
	
	private void validerNom (Utilisateur utilisateur, BusinessException businessException) {
		
		if(utilisateur.getNom() == null) {
			
			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_NOM_ERREUR);
			
		}
		
	}
	
	private void validerPrenom (Utilisateur utilisateur, BusinessException businessException) {
		
		if(utilisateur.getPrenom() == null) {
			
			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_PRENOM_ERREUR);
			
		}
		
	}
	
	private void validerEmail (Utilisateur utilisateur, BusinessException businessException) {
		
		if(utilisateur.getEmail() == null) {
			
			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_EMAIL_ERREUR);
			
		}
		
	}
	
	private void validerTelephone (Utilisateur utilisateur, BusinessException businessException) {
		
		if(utilisateur.getTelephone() == null) {
			
			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_TELEPHONE_ERREUR);
			
		}
		
	}
	
	private void validerRue (Utilisateur utilisateur, BusinessException businessException) {
		
		if(utilisateur.getRue() == null) {
			
			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_RUE_ERREUR);
			
		}
		
	}
	private void validerCodePostal (Utilisateur utilisateur, BusinessException businessException) {
	
	if(utilisateur.getCodePostal() == null) {
		
		businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_CODE_POSTAL_ERREUR);
		
	}
	
	}
	private void validerVille (Utilisateur utilisateur, BusinessException businessException) {
	
	if(utilisateur.getVille() == null) {
		
		businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_VILLE_ERREUR);
		
	}
	
	}
	private void validerMotDePasse (Utilisateur utilisateur, BusinessException businessException) {
		
		if(utilisateur.getMotDePasse() == null) {
			
			businessException.ajouterErreur(CodesResultatBLL.UTILISATEUR_MOT_DE_PASSE_ERREUR);
			
		}
		
		}
	private void validerCredit (Utilisateur utilisateur, BusinessException businessException) {
		
		if(utilisateur.getCredit() == 0) {
			
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
