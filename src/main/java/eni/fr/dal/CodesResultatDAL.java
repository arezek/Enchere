package eni.fr.dal;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_OBJET_NULL=10000;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_OBJET_ECHEC=10001;
	
	/**
	 * Echec de la lecture de tous les  Utilisateurs
	 */
	public static final int LECTURE_TOUS_Utilisateurs_ECHEC=10002;
	
	/**
	 * Echec de l'insertion d'un utilisateur à cause d'un champ null il faut remplir tous les cases.
	 */
	public static final int INSERT_TOUS_LES_CHAMPS_ECHEC=10003;
	
	/**
	 * Echec de la modification d'un utilisateur.
	 */
	public static final int UPDATE_UTILISATEUR_ECHEC=10004;
	
	/**
	 * Echec de la supression d'un utilisateur.
	 */
	public static final int DELETE_UTILISATEUR_ECHEC=10005;
	
	/**
	 * Echec de la lecture d'un Utilisateur par le Pseudo.
	 */
	public static final int LECTURE_Utilisateur_BY_PSEUDO_ECHEC=10006;
	
	
	/**
	 * Echec de la lecture d'un Utilisateur par son Numéro.
	 */
	public static final int LECTURE_Utilisateur_BY_ID_ECHEC=10007;
}
