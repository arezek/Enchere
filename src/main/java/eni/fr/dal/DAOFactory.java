package eni.fr.dal;

public abstract class DAOFactory {
	
	public static ArticleVenduDAO getArticleVenduDAO()
	{
		return new ArticleVenduDAOJdbcImpl();
	}
	
	public static CategorieDAO getCategorieDAO()
	{
		return new CategorieDAOJdbcImpl();
	}
	
	public static EnchereDAO getEnchereDAO()
	{
		return new EnchereDAOJdbcImpl();
	}
	
	public static RetraitDAO getRetraitDAO()
	{
		return new RetraitDAOJdbcImpl();
	}
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAOJdbcImpl();
	}

}
