package eni.fr.bo;

/**
 * @author ALLIOUCHE 
 */

public class Retrait {
	public int idRetrait;
	public String rue;
	public String code_postal;
	public String ville;
	
	public Retrait(String rue, String code_postal, String ville) {
		super();
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
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

	@Override
	public String toString() {
		return "RetraitDAO [rue=" + rue + ", code_postal=" + code_postal + ", ville=" + ville + "]";
	}
	
	
}
