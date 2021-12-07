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
		
		
		ArticleVenduDAOJdbcImpl  article = new ArticleVenduDAOJdbcImpl ();
		
		
		
		
		
		article.insert(new ArticleVendu("nom_article" , "description",LocalDate.of(2020,01,15),  LocalDate.of(2008,10,13), 20, "encours"));
		
		
		
		
		          
		
		
		
		
		
		
		
		
		
		
	}

}
