package eni.fr.dal;

import eni.fr.bo.ArticleVendu;
/**
 * 
 * @author Zabaka fatima zahra
 *
 */
public interface ArticleVenduDAO {
	public ArticleVendu selectById(int noArticle) throws DALException;
	
	//Sélectionner tous les Articles Vendus 
	public ArticleVendu selectAll() throws DALException;
	
	//Modifier les attributs d'un Article Vendu 
	public void update(ArticleVendu articleVendu) throws DALException;
	
	//Insérer une nouvelle article Vendue
	public void insert(ArticleVendu articleVendu) throws DALException;
	
	//Supprimer un article Vendu
	public void delete(int noArticle) throws DALException;
	
}
