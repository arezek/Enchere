package eni.fr.bo;

import java.time.LocalDate;

/**
 * @author EUGENIE FUCHS 
 */

public class Enchere {
	
	public Utilisateur noUtilisateur;
	public ArticleVendu noArticle;
	public LocalDate dateEnchere;
	public int montantEnchere;
	
	public Enchere() {
	
	}

	public Enchere(Utilisateur noUtilisateur, ArticleVendu noArticle, LocalDate dateEnchere, int montantEnchere) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public Enchere(ArticleVendu noArticle, LocalDate dateEnchere, int montantEnchere) {
		super();
		this.noArticle = noArticle;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	
	

	public Enchere(LocalDate dateEnchere, int montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public Utilisateur getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Utilisateur noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public ArticleVendu getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(ArticleVendu noArticle) {
		this.noArticle = noArticle;
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	@Override
	public String toString() {
		return "Enchere [noUtilisateur=" + noUtilisateur + ", noArticle=" + noArticle + ", dateEnchere="
				+ dateEnchere + ", montantEnchere=" + montantEnchere + "]";
	}
	
}
