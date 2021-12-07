package eni.fr.dal;

public class DALException extends Exception {
	
	/**
	 * @author ALLIOUCHE 
	 */
	private static final long serialVersionUID = 1L;

	public DALException() {
		super();
	}
	
	public DALException(String message) {
		super(message);
	}
	
	public DALException(String message, Throwable exception) {
		super(message, exception);
	}

	@Override
	public String toString() {
		return "DALException [getMessage()=" + getMessage() + "]";
	}
	
	

}
