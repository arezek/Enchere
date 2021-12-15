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
	
	
	
	
	
	
	// Retrait INSERTION/MODIFICATION/SUPPRESSION
	
	/**
	 * Echec de l'insertion des Informations de la Table Retrait a cause d'un champ null il faut remplir tous les cases.
	 */
	public static final int INSERT_RETRAIT_TOUS_LES_CHAMPS_ECHEC=10014;
	
	/**
	 * Echec de la supression d'un Retrait.
	 */
	public static final int DELETE_RETRAIT_ECHEC=10015;
	
	/**
	 * Echec de la modification d'un RETRAIT.
	 */
	public static final int UPDATE_RETRAIT_ECHEC=10016;
	
	/**
	 * Echec de la lecture de tous les  Retraits.
	 */
	public static final int LECTURE_TOUS_RETRAIT_ECHEC=10017;
	
	/**
	 * Echec de la lecture d'un Retrait par le numero d'article.
	 */
	public static final int LECTURE_RETRAIT_BY_ID_ECHEC=10018;
	
	
	
	
	
	// ENCHERE   INSERTION/MODIFICATION/SUPPRESSION
	/**
	 * Echec de l'insertion des Informations de la Table Enchère a cause d'un champ null il faut remplir tous les cases.
	 */
	public static final int INSERT_ENCHERE_TOUS_LES_CHAMPS_ECHEC=10019;
	
	/**
	 * Echec de la supression d'un Enchère.
	 */
	public static final int DELETE_ENCHERE_ECHEC=10020;
	
	/**
	 * Echec de la modification d'un Enchère.
	 */
	public static final int UPDATE_ENCHERE_ECHEC=10021;
	
	/**
	 * Echec de la lecture de tous les  Enchères.
	 */
	public static final int LECTURE_TOUS_ENCHERES_ECHEC=10022;
	
	/**
	 * Echec de la lecture d'un Enchère par le numero d'utilisateur et le numéro d'article.
	 */
	public static final int LECTURE_ENCHERE_BY_ID_UTILISATEUR_ARTICLE_ECHEC=10023;
	
	
	
	
	
	// ENCHERE   INSERTION/MODIFICATION/SUPPRESSION
	
	/**
	 * Echec de l'insertion des Informations de la Table CATEGORIE a cause d'un champ null il faut remplir tous les cases.
	 */
	public static final int INSERT_CATEGORIE_TOUS_LES_CHAMPS_ECHEC=10024;
	
	/**
	 * Echec de la supression d'une CATEGORIE.
	 */
	public static final int DELETE_CATEGORIE_ECHEC=10025;
	
	/**
	 * Echec de la modification d'une CATEGORIE.
	 */
	public static final int UPDATE_CATEGORIE_ECHEC=10026;
	
	/**
	 * Echec de la lecture de tous les  CATEGORIES.
	 */
	public static final int LECTURE_TOUS_CATEGORIES_ECHEC=10027;
	
	/**
	 * Echec de la lecture d'une CATEGORIE par le numero d'utilisateur.
	 */
	public static final int LECTURE_ENCHERE_BY_ID_UTILISATEUR_ECHEC=10028;
	
}


