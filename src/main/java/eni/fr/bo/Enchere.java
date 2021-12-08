package eni.fr.bo;

import java.time.LocalDate;

/**
 * @author EUGENIE FUCHS 
 */

public class Enchere {
	
	public Utilisateur noUtilisateur;
	public Categorie noCategorie;
	public LocalDate dateEnchere;
	public int montantEnchere;
	
	public Enchere() {
	
	}

	public Enchere(Utilisateur noUtilisateur, Categorie noCategorie, LocalDate dateEnchere, int montantEnchere) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public Enchere(Categorie noCategorie, LocalDate dateEnchere, int montantEnchere) {
		super();
		this.noCategorie = noCategorie;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public Utilisateur getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Utilisateur noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public Categorie getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(Categorie noCategorie) {
		this.noCategorie = noCategorie;
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
		return "Enchere [noUtilisateur=" + noUtilisateur + ", noCategorie=" + noCategorie + ", dateEnchere="
				+ dateEnchere + ", montantEnchere=" + montantEnchere + "]";
	}
	
}
