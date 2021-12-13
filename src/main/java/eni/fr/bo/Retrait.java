package eni.fr.bo;

/**
 * @author ALLIOUCHE 
 */

public class Retrait {
	public int idRetrait;
	public String rue;
	public String codePostal;
	public String ville;
	public ArticleVendu noArticle;
	
	public Retrait() {
		
	}

	public Retrait(String rue, String codePostal, String ville, ArticleVendu noArticle) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.noArticle = noArticle;
	}

	public Retrait(int idRetrait, String rue, String codePostal, String ville, ArticleVendu noArticle) {
		super();
		this.idRetrait = idRetrait;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.noArticle = noArticle;
	}

	public Retrait(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public int getIdRetrait() {
		return idRetrait;
	}

	public void setIdRetrait(int idRetrait) {
		this.idRetrait = idRetrait;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public ArticleVendu getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(ArticleVendu noArticle) {
		this.noArticle = noArticle;
	}

	@Override
	public String toString() {
		return "Retrait [idRetrait=" + idRetrait + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", noArticle=" + noArticle + "]";
	}
	
}
