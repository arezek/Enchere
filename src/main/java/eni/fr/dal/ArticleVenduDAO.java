package eni.fr.dal;

import java.util.List;

import eni.fr.BusinessException;
import eni.fr.bo.ArticleVendu;
/**
 * 
 * @author Zabaka fatima zahra
 *
 */
public interface ArticleVenduDAO {
	public ArticleVendu selectById(int noArticle) throws  BusinessException;
	
	//Sélectionner tous les Articles Vendus 
	public List<ArticleVendu> selectAll() throws BusinessException;
	
	//Modifier les attributs d'un Article Vendu 
	public void update(ArticleVendu articleVendu) throws BusinessException;
	
	//Insérer une nouvelle article Vendue
	public ArticleVendu insert(ArticleVendu articleVendu) throws BusinessException;
	
	//Supprimer un article Vendu
	public void delete(int noArticle) throws  BusinessException;
	
	//faire une recherche par nom d'article et catégorie
	 public List<ArticleVendu> search(String nomArticle,int noCategorie )throws BusinessException;
}
