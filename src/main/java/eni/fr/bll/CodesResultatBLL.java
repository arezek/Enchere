package eni.fr.bll;

public abstract class CodesResultatBLL {
	
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

	
	
	
	
}
