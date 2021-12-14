package eni.fr.bll;

import java.time.LocalDate;

import eni.fr.BusinessException;
import eni.fr.bo.ArticleVendu;
import eni.fr.bo.Categorie;
import eni.fr.bo.Retrait;
import eni.fr.bo.Utilisateur;
import eni.fr.dal.DALException;
import eni.fr.dal.DAOFactory;
import eni.fr.dal.RetraitDAO;

public class RetraitManager {

	private RetraitDAO retraitDAO;
	
	public RetraitManager() {
		
		this.retraitDAO = DAOFactory.getRetraitDAO();
		
	}
	
	public Retrait ajouter(String rue, String codePostal, String ville, ArticleVendu noArticle) throws BusinessException {
		
		BusinessException exception = new BusinessException();
		
		Retrait retrait = new Retrait(rue, codePostal, ville, noArticle);
		
		this.validerRue(retrait, exception);
		this.validerCodePostal(retrait, exception);
		this.validerVille(retrait, exception);
		this.validerNoArticle(retrait, exception);

		if(!exception.hasErreurs()) {
			
			try {
				
				this.retraitDAO.insert(retrait);
				
			} catch (DALException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		if (exception.hasErreurs()) {
			
			throw exception;
			
		}
		
		return retrait;
	}
	
	private void validerRue (Retrait retrait, BusinessException businessException) {
		
		String rue = retrait.getRue();
		int tailleRue = rue.length();
		
		if(rue == null || tailleRue > 30) {
			
			businessException.ajouterErreur(CodesResultatBLL.RETRAIT_RUE_ERREUR);
			
		}
		
	}
	
	private void validerCodePostal (Retrait retrait, BusinessException businessException) {
	
		String codePostal = retrait.getCodePostal();
		int tailleCodePostal = codePostal.length();
		
		if(codePostal == null || tailleCodePostal > 10) {
		
			businessException.ajouterErreur(CodesResultatBLL.RETRAIT_CODE_POSTAL_ERREUR);
		
		}
	
	}
	
	private void validerVille (Retrait retrait, BusinessException businessException) {
	
		String ville = retrait.getVille();
		int tailleVille = ville.length();
		
		if(ville == null || tailleVille > 30) {
		
			businessException.ajouterErreur(CodesResultatBLL.RETRAIT_VILLE_ERREUR);
		
		}
	
	}
	
	private void validerNoArticle (Retrait retrait, BusinessException businessException) {
		
		if (retrait.getNoArticle() == null) {
			
			businessException.ajouterErreur(CodesResultatBLL.RETRAIT_NO_ARTICLE_ERREUR);
			
		}
		
	}
	
}
