package eni.fr.dal;
/**
 * @author Zabaka Fatima Zahra
 */


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
	
	
	
	
	// utilisateur INSERTION/MODIFICATION/SUPPRESSION
	
	
	
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
	
	
	
	// ArticleVendu INSERTION/MODIFICATION/SUPPRESSION
	
	/**
	 * Echec de l'insertion d'un Nouveau Article Vendu à cause d'un champ null il faut remplir tous les cases.
	 */
	public static final int INSERT_ARTICLE_TOUS_LES_CHAMPS_ECHEC=10008;
	
	/**
	 * Echec de la supression d'un Article Vendu.
	 */
	public static final int DELETE_ARTICLE_VENDU_ECHEC=10009;
	
	/**
	 * Echec de la modification d'un Article Vendu.
	 */
	public static final int UPDATE_ARTICLE_VENDU_ECHEC=10010;
	
	/**
	 * Echec de la lecture d'un Article Vendu par son Numéro.
	 */
	public static final int LECTURE_ARTICLE_VENDU_BY_ID_ECHEC=10011;

	/**
	 * Echec de la lecture de tous les  Articles Vendus
	 */
	public static final int LECTURE_TOUS_ARTICLE_VENDUS_ECHEC=10012;
	
	/**
	 * Echec de la lecture d'un Article Vendu par son Nom et le Numéro de Catégorie.
	 */
	public static final int LECTURE_ARTICLE_VENDU_BY_NOMARTICLE_NOCATEGORIE_ECHEC=10013;
	
	
	
}
