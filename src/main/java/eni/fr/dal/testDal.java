package eni.fr.dal;



import java.time.LocalDate;




import eni.fr.bo.ArticleVendu;



public class testDal {

	public testDal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws DALException {
//		Utilisateur test1 = new Utilisateur("gege", "gérard", "bouchard", "gege@mail.com", "tel", "rue", "cp", "ville", "mdp fdp") ;
//		UtilisateurDAOJdbcImpl testinsert = new UtilisateurDAOJdbcImpl();
//		testinsert.insert(test1); 
		
		
//		UtilisateurDAOJdbcImpl  dao = new UtilisateurDAOJdbcImpl ();
//		
//		
//		
//		
//		
//		dao.insert(new Utilisateur("gege", "gérard", "bouchard", "gege@mail.com", "tel", "rue", "cp", "ville", "mdp fdp"));
		
		
		//ArticleVenduDAOJdbcImpl  article = new ArticleVenduDAOJdbcImpl ();
		
		
		
		
		//article.insert(new ArticleVendu("nom_article" , "description",LocalDate.of(2020,01,15),  LocalDate.of(2008,10,13), 20, "encours"));
		
		
		ArticleVenduDAOJdbcImpl article = new ArticleVenduDAOJdbcImpl();
		
		ArticleVendu art = new ArticleVendu();
		
//		article.search("nom_article", 1);
//		article.selectAll();
		//article.delete(4);
		
		article.update(art);
		
		System.out.println("Modification d'un article : " );
		System.out.println("Article avant modification : " + art.toString());
		art.setString("nom_article");
		pstmt.setString(i++, articleVendu.getDescription());
		pstmt.setDate(i++, java.sql.Date.valueOf(articleVendu.getDateDebutEncheres()));
		pstmt.setDate(i++, java.sql.Date.valueOf(articleVendu.getDateFinEncheres()));
		pstmt.setInt(i++, articleVendu.getMiseAPrix());
		pstmt.setString(i++, articleVendu.getEtatVente());
		
		
		
		articleDAO.update(a1);
		System.out.println("Article après modification : " + a1.toString() );

		
		
		
		
		
		
		
		
		
		
	}

}
