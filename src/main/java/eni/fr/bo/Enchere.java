package eni.fr.bo;

import java.time.LocalDate;

public class Enchere {
	

	LocalDate dateEnchere;
	int montantEnchere;
	
	public Enchere() {
	}

	public Enchere(LocalDate dateEnchere, int montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
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
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + "]";
	}
	
	

}
