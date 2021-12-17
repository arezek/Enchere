package eni.fr.bll;

import java.time.LocalDate;

import eni.fr.BusinessException;
import eni.fr.bo.ArticleVendu;
import eni.fr.bo.Enchere;
import eni.fr.bo.Retrait;
import eni.fr.dal.DALException;
import eni.fr.dal.DAOFactory;
import eni.fr.dal.EnchereDAO;
import eni.fr.dal.RetraitDAO;
import eni.fr.dal.UtilisateurDAO;

public class EnchereManager {
	private EnchereDAO enchereDAO;
	private UtilisateurDAO utilisateurDAO;
	
	public EnchereManager() {
			
			this.enchereDAO = DAOFactory.getEnchereDAO();
			this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
		
	public Enchere ajouter(Enchere enchere) throws BusinessException, DALException {
			
			BusinessException exception = new BusinessException();
			int bourseUtilisateur = this.utilisateurDAO.selectById(enchere.getNoUtilisateur().getNoUtilisateur()).getCredit();
			System.out.println(bourseUtilisateur);
			int montant = enchere.getMontantEnchere();
			
			this.validerDate(enchere, exception);
			this.validerMontant(enchere, exception);
	
			if(!exception.hasErreurs()) {
				
				try {
					Integer creditRestant = bourseUtilisateur - montant;
					System.out.println(creditRestant);
					this.enchereDAO.insert(enchere);
					this.utilisateurDAO.update("credit", creditRestant.toString(), enchere.getNoUtilisateur());
					
					
				} catch (DALException e) {
					
					e.printStackTrace();
					
				}
				
			}
			
			if (exception.hasErreurs()) {
				
				throw exception;
				
			}
			
			return enchere;
	}
	private void validerDate (Enchere enchere, BusinessException businessException) {
		
		LocalDate date = enchere.getDateEnchere();
		
		LocalDate dateFinEnchere = enchere.getNoArticle().getDateFinEncheres();
		
		if(date == null || date.isAfter(dateFinEnchere)) {
			
			businessException.ajouterErreur(CodesResultatBLL.ENCHERE_DEPASSE);
			
		}
		
	}
private void validerMontant (Enchere enchere, BusinessException businessException) {
		
		int montant = enchere.getMontantEnchere();
		int bourseUtilisateur = enchere.getNoUtilisateur().getCredit();
		int prixVente = enchere.getNoArticle().getPrixVente();
		
		if( montant < prixVente || bourseUtilisateur < montant) {
			
			businessException.ajouterErreur(CodesResultatBLL.ENCHERE_INVALIDE);
			
		}
		
	}
}
