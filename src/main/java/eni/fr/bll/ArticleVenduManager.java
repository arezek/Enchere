package eni.fr.bll;

import java.time.LocalDate;

import eni.fr.BusinessException;
import eni.fr.bo.ArticleVendu;
import eni.fr.bo.Categorie;
import eni.fr.bo.Utilisateur;
import eni.fr.dal.ArticleVenduDAO;
import eni.fr.dal.DALException;
import eni.fr.dal.DAOFactory;

public class ArticleVenduManager {
	
	private ArticleVenduDAO articleVenduDAO;
	
	public ArticleVenduManager() {
		
		this.articleVenduDAO = DAOFactory.getArticleVenduDAO();
		
	}
	
	public ArticleVendu ajouter(String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, String etatVente, Utilisateur noUtilisateur, Categorie noCategorie) throws BusinessException {
		
		BusinessException exception = new BusinessException();
		
		ArticleVendu articleVendu = new ArticleVendu(nomArticle, description, dateDebutEncheres,
				dateFinEncheres, miseAPrix, etatVente, noUtilisateur, noCategorie);
		
		this.validerNomArticle(articleVendu, exception);
		this.validerDescription(articleVendu, exception);
		this.validerDateDebutEncheres(articleVendu, exception);
		this.validerDateFinEncheres(articleVendu, exception);
		this.validerMiseAPrix(articleVendu, exception);
		this.validerEtatVente(articleVendu, exception);
		this.validerNoUtilisateur(articleVendu, exception);
		this.validerNoCategorie(articleVendu, exception);
		
		if(!exception.hasErreurs()) {
			
			try {
				
				this.articleVenduDAO.insert(articleVendu);
				
			} catch (DALException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		if (exception.hasErreurs()) {
			
			throw exception;
			
		}
		
		return articleVendu;
	}
	
	private void validerNomArticle (ArticleVendu articleVendu, BusinessException businessException) {
		
		if(articleVendu.getNomArticle() == null) {
			
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_VENDU_NOM_ERREUR);
			
		}
		
	}
	
	private void validerDescription (ArticleVendu articleVendu, BusinessException businessException) {
		
		if(articleVendu.getDescription() == null) {
			
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_VENDU_DESCRIPTION_ERREUR);
			
		}
		
	}
	
	private void validerDateDebutEncheres (ArticleVendu articleVendu, BusinessException businessException) {
		
		if(articleVendu.getDateDebutEncheres() == null || articleVendu.getDateDebutEncheres().isBefore(LocalDate.now())) {
			
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_VENDU_DATE_DEBUT_ENCHERES_ERREUR);
			
		}
		
	}
	
	private void validerDateFinEncheres (ArticleVendu articleVendu, BusinessException businessException) {
		
		if(articleVendu.getDateDebutEncheres() == null || articleVendu.getDateFinEncheres().isBefore(LocalDate.now())
				|| articleVendu.getDateFinEncheres().isBefore(articleVendu.getDateDebutEncheres())) {
			
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_VENDU_DATE_FIN_ENCHERES_ERREUR);
			
		}
		
	}
	
	private void validerMiseAPrix (ArticleVendu articleVendu, BusinessException businessException) {
		
		if(articleVendu.getMiseAPrix() == 0) {
			
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_VENDU_MISE_A_PRIX_ERREUR);
			
		}
		
	}
	
	private void validerEtatVente (ArticleVendu articleVendu, BusinessException businessException) {
		
		String etatVenteFinished = "termine";
		
		if(articleVendu.getEtatVente() == etatVenteFinished) {
			
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_VENDU_ETAT_VENTE_ERREUR);
			
		}
		
	}
	private void validerNoUtilisateur (ArticleVendu articleVendu, BusinessException businessException) {
	
	if(articleVendu.getNoUtilisateur() == null) {
		
		businessException.ajouterErreur(CodesResultatBLL.ARTICLE_VENDU_NO_UTILISATEUR_ERREUR);
		
	}
	
	}
	private void validerNoCategorie (ArticleVendu articleVendu, BusinessException businessException) {
	
	if(articleVendu.getNoCategorie() == null) {
		
		businessException.ajouterErreur(CodesResultatBLL.ARTICLE_VENDU_NO_CATEGORIE_ERREUR);
		
	}
	
	}

}
