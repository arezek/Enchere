package eni.fr.bo;

/**
 * @author ALLIOUCHE 
 */

public class Retrait {
	public int idRetrait;
	public String rue;
	public String code_postal;
	public String ville;
	public ArticleVendu noArticle;
	
	public Retrait() {
		
	}

	public Retrait(String rue, String code_postal, String ville, ArticleVendu noArticle) {
		super();
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.noArticle = noArticle;
	}

	public Retrait(int idRetrait, String rue, String code_postal, String ville, ArticleVendu noArticle) {
		super();
		this.idRetrait = idRetrait;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.noArticle = noArticle;
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

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
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
		return "Retrait [idRetrait=" + idRetrait + ", rue=" + rue + ", code_postal=" + code_postal + ", ville=" + ville
				+ ", noArticle=" + noArticle + "]";
	}
	
}
