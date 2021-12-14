package eni.fr.bll;

public abstract class CodesResultatBLL {
	
	// ARTICLES VENDUS INSERTION
	
	/**
	 * Echec quand le nom de l'article n'est pas rentré 
	 */
	public static final int ARTICLE_VENDU_NOM_ERREUR=20000;
	/**
	 * Echec quand la description de l'article n'est pas rentrée
	 */
	public static final int ARTICLE_VENDU_DESCRIPTION_ERREUR=20001;
	/**
	 * Echec quand la date de début d'enchères est nulle ou inférieure à la date du jour
	 */
	public static final int ARTICLE_VENDU_DATE_DEBUT_ENCHERES_ERREUR=20002;
	/**
	 * Echec quand la date de fin d'enchères est nulle ou inférieure à la date du jour/début d'enchères
	 */
	public static final int ARTICLE_VENDU_DATE_FIN_ENCHERES_ERREUR=20003;
	/**
	 * Echec quand la mise à prix est égale à 0 point
	 */
	public static final int ARTICLE_VENDU_MISE_A_PRIX_ERREUR=20004;
	/**
	 * Echec quand on essaie d'ajouter un article dont la vente est terminé (en tant qu'admin ?)
	 */
	public static final int ARTICLE_VENDU_ETAT_VENTE_ERREUR=20005;
	/**
	 * Echec quand on essaie d'ajouter un article sans être connecté (sécurité ?)
	 */
	public static final int ARTICLE_VENDU_NO_UTILISATEUR_ERREUR=20006;
	/**
	 * Echec quand on essaie d'ajouter un article dont la catégorie n'existe pas (admin/sécurité ?)
	 */
	public static final int ARTICLE_VENDU_NO_CATEGORIE_ERREUR=20007;
	
	// ARTICLES VENDUS MODIFICATION

	
	// UTILISATEUR INSERTION
	
	/**
	 * Echec quand le pseudo de l'utilisateur n'est pas rentré 
	 */
	public static final int UTILISATEUR_PSEUDO_ERREUR=20008;
	/**
	 * Echec quand le nom de l'utilisateur n'est pas rentré
	 */
	public static final int UTILISATEUR_NOM_ERREUR=20009;
	/**
	 * Echec quand le prénom de l'utilisateur n'est pas rentré
	 */
	public static final int UTILISATEUR_PRENOM_ERREUR=20010;
	/**
	 * Echec quand l'email de l'utilisateur n'est pas rentré
	 */
	public static final int UTILISATEUR_EMAIL_ERREUR=20011;
	/**
	 * Echec quand le téléphone de l'utilisateur n'est pas rentré
	 */
	public static final int UTILISATEUR_TELEPHONE_ERREUR=20012;
	/**
	 * Echec quand la rue de l'utilisateur n'est pas rentrée
	 */
	public static final int UTILISATEUR_RUE_ERREUR=20013;
	/**
	 * Echec quand le code postal de l'utilisateur n'est pas rentré
	 */
	public static final int UTILISATEUR_CODE_POSTAL_ERREUR=20014;
	/**
	 * Echec quand la ville de l'utilisateur n'est pas rentrée
	 */
	public static final int UTILISATEUR_VILLE_ERREUR=20015;
	/**
	 * Echec quand le mot de passe de l'utilisateur n'est pas rentré
	 */
	public static final int UTILISATEUR_MOT_DE_PASSE_ERREUR=20016;
	/**
	 * Echec quand le crédit de l'utilisateur est à 0 (lors de l'insertion, cela ne devrait pas être possible vu qu'on a toujours 100 pts de départ)
	 */
	public static final int UTILISATEUR_CREDIT_ERREUR=20017;
	/**
	 * Echec quand l'utilisateur est noté admin par de manières douteuses (sécurité ?)
	 */
	public static final int UTILISATEUR_ADMINISTRATEUR_ERREUR=20018;
	
	// UTILISATEUR MODIFICATION


	
	
	
	

}
