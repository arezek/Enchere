package eni.fr.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import eni.fr.bo.ArticleVendu;
import eni.fr.bo.Categorie;
import eni.fr.bo.Utilisateur;
//yeah

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS(nom_article,description , date_debut_encheres, date_fin_encheres, prix_initial, etat_vente,no_utilisateur,no_categorie ) VALUES(?,?,?,?,?,?,?,?)";
	private static final String SEARCH = "SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres, prix_initial,etat_vente, ARTICLES_VENDUS.no_utilisateur,ARTICLES_VENDUS.no_categorie, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur, libelle FROM ARTICLES_VENDUS  INNER JOIN UTILISATEURS ON UTILISATEURS.no_utilisateur = ARTICLES_VENDUS.no_utilisateur inner join CATEGORIES on CATEGORIES.no_categorie=ARTICLES_VENDUS.no_categorie WHERE nom_article like ? AND ARTICLES_VENDUS.no_categorie =?";
	private static final String SEARCHNOCATEGORIE = "SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres, prix_initial,etat_vente, ARTICLES_VENDUS.no_utilisateur,ARTICLES_VENDUS.no_categorie, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur, libelle FROM ARTICLES_VENDUS  INNER JOIN UTILISATEURS ON UTILISATEURS.no_utilisateur = ARTICLES_VENDUS.no_utilisateur inner join CATEGORIES on CATEGORIES.no_categorie=ARTICLES_VENDUS.no_categorie WHERE nom_article like ?";
	private static final String SELECTBYID = "SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres, prix_initial,etat_vente, ARTICLES_VENDUS.no_utilisateur,ARTICLES_VENDUS.no_categorie, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur, libelle FROM ARTICLES_VENDUS  INNER JOIN UTILISATEURS ON UTILISATEURS.no_utilisateur = ARTICLES_VENDUS.no_utilisateur inner join CATEGORIES on CATEGORIES.no_categorie=ARTICLES_VENDUS.no_categorie WHERE ARTICLES_VENDUS.no_article =?";
	private static final String SELECTALL = "SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres, prix_initial,etat_vente, ARTICLES_VENDUS.no_utilisateur,ARTICLES_VENDUS.no_categorie, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur, libelle FROM ARTICLES_VENDUS  INNER JOIN UTILISATEURS ON UTILISATEURS.no_utilisateur = ARTICLES_VENDUS.no_utilisateur inner join CATEGORIES on CATEGORIES.no_categorie=ARTICLES_VENDUS.no_categorie ORDER BY date_fin_encheres DESC";
	private static final String DELETE = "delete from ARTICLES_VENDUS where no_article=?";
	private static final String UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article = 'article', description = 'nv article', date_debut_encheres = '2008-10-11', date_fin_encheres = '2008-10-11', prix_initial = 10, no_categorie = 2 FROM ARTICLES_VENDUS as a INNER JOIN CATEGORIES as c ON c.no_categorie = a.no_categorie WHERE no_article = 4";
	int i = 1;

	@Override
	public int insert(ArticleVendu articleVendu) throws DALException {

//		if(ArticleVendu==null)
//			{
//				BusinessException businessException = new BusinessException();
//				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
//				throw businessException;
//			}
			int returnNumArticle=0;
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);) {

			pstmt.setString(i++, articleVendu.getNomArticle());
			pstmt.setString(i++, articleVendu.getDescription());
			pstmt.setDate(i++, java.sql.Date.valueOf(articleVendu.getDateDebutEncheres()));
			pstmt.setDate(i++, java.sql.Date.valueOf(articleVendu.getDateFinEncheres()));
			pstmt.setInt(i++, articleVendu.getMiseAPrix());
			pstmt.setString(i++, articleVendu.getEtatVente());
			
			pstmt.setInt(i++, articleVendu.getNoUtilisateur().getNoUtilisateur());
			pstmt.setInt(i++, articleVendu.getNoCategorie().getNoCategorie());

			pstmt.executeUpdate(); 
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				
				 articleVendu.setNoArticle(rs.getInt(1));
				 returnNumArticle =articleVendu.getNoArticle();
			}
		} catch (Exception e) {
			e.printStackTrace();
//				BusinessException businessException = new BusinessException();
//				if(e.getMessage().contains("CK_ArticleVendu_note"))
//				{
//					businessException.ajouterErreur(CodesResultatDAL.INSERT_ArticleVendu_NOTE_ECHEC);
//				}
//				else
//				{
//					businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
//				}
//				throw businessException;
		}
		return returnNumArticle;

	}

	@Override
	public ArticleVendu selectById(int noArticle) throws DALException {
		ResultSet rs = null;
		ArticleVendu art = new ArticleVendu();
		try (Connection con = ConnectionProvider.getConnection(); 
			 PreparedStatement rqt = con.prepareStatement(SELECTBYID);)

		{
			
			rqt.setInt(1, noArticle);
			rs = rqt.executeQuery();
			rs.next();

			Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), 
					rs.getString("pseudo"), 
					rs.getString("nom"), 
					rs.getString("prenom"), 
					rs.getString("email"), 
					rs.getString("telephone"),
					rs.getString("rue"), 
					rs.getString("code_postal"), 
					rs.getString("ville"), 
					rs.getString("mot_de_passe"), 
					rs.getInt("credit"), 
					rs.getBoolean("administrateur"));
				
			Categorie categorie = new Categorie(rs.getInt("no_categorie"), 
					rs.getString("libelle"));
				
			art = new ArticleVendu(rs.getInt("no_article"), 
					rs.getString("nom_article"),
					rs.getString("description"),
					rs.getDate("date_debut_encheres").toLocalDate(),
					rs.getDate("date_fin_encheres").toLocalDate(), 
					rs.getInt("prix_initial"), 
					rs.getString("etat_vente"));
				
			art.setNoUtilisateur(utilisateur);
			art.setNoCategorie(categorie);
			System.out.println(art.getDescription());

		} catch (SQLException e) {
			
			throw new DALException("erreur de requete de recherche d'articles", e);
		}

		return art;
	}
	

	@Override
	public void update(ArticleVendu articleVendu) throws DALException {
	        try(Connection con = ConnectionProvider.getConnection();
	        PreparedStatement Pstmt = con.prepareStatement(UPDATE,PreparedStatement.RETURN_GENERATED_KEYS);
	                ) 
	        {
	        
	        	Pstmt.setString(i++, articleVendu.getNomArticle());
				Pstmt.setString(i++, articleVendu.getDescription());
				Pstmt.setDate(i++, java.sql.Date.valueOf(articleVendu.getDateDebutEncheres()));
				Pstmt.setDate(i++, java.sql.Date.valueOf(articleVendu.getDateFinEncheres()));
				Pstmt.setInt(i++, articleVendu.getMiseAPrix());
				Pstmt.setString(i++, articleVendu.getEtatVente());
	          
	            Pstmt.executeUpdate();
	            
	        } catch (SQLException e) {
	        	
	            throw new DALException("erreur de requete update",e);
	            
	        }
	}
	
	@Override
	public void delete(int noArticle) throws DALException {
		try (Connection con = ConnectionProvider.getConnection();
                PreparedStatement Pstmt = con.prepareStatement(DELETE)){
                Pstmt.setInt(1, noArticle);
                Pstmt.executeUpdate();
        }catch (SQLException e) {
        throw new DALException("erreur de requete Delete",e);
    }
	}

	@Override
	public List<ArticleVendu> selectAll() throws DALException {
		List<ArticleVendu> articlesVendus = new ArrayList<ArticleVendu>();
		try (Connection con = ConnectionProvider.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(SELECTALL);) {
			ArticleVendu article = null;
			while (rs.next()) {

				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"),
						rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						rs.getString("mot_de_passe"),
						rs.getInt("credit"),
						rs.getBoolean("administrateur"));
				
				article = new ArticleVendu(rs.getInt("no_article"),
						rs.getString("nom_article"),
						rs.getDate("date_fin_encheres").toLocalDate(),
						rs.getInt("prix_initial"),
						rs.getString("etat_vente"));
				
				article.setNoUtilisateur(utilisateur);

				articlesVendus.add(article);
				
			}

		} catch (SQLException e) {
			throw new DALException("erreur de requete select ALL", e);
		}
		return articlesVendus;

	}

	@Override
	public List<ArticleVendu> search(String nomArticle, int noCategorie) throws DALException {

		ResultSet rs = null;
		List<ArticleVendu> liste = new ArrayList<ArticleVendu>();
		if (noCategorie == 5) {
			try (Connection con = ConnectionProvider.getConnection(); 
					 PreparedStatement rqt = con.prepareStatement(SEARCHNOCATEGORIE);)

				{
					ArticleVendu art = new ArticleVendu();
					rqt.setString(1, "%"+nomArticle+"%");
					
					rs = rqt.executeQuery();
//					rs.next();

					

					while (rs.next()) {
						Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),
								rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
						
						Categorie categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
						
						art = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),rs.getString("description"),rs.getDate("date_debut_encheres").toLocalDate(),
								rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"), rs.getString("etat_vente"));
						
						art.setNoUtilisateur(utilisateur);
						art.setNoCategorie(categorie);
						
						liste.add(art);
						
					}

						

				} catch (SQLException e) {
					
					throw new DALException("erreur de requete de recherche d'articles", e);
				}
		}else {
		try (Connection con = ConnectionProvider.getConnection(); 
			 PreparedStatement rqt = con.prepareStatement(SEARCH);)

		{
			ArticleVendu art = new ArticleVendu();
			rqt.setString(1, "%"+nomArticle+"%");
			rqt.setInt(2, noCategorie);
			rs = rqt.executeQuery();
//			rs.next();

			

			while (rs.next()) {
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),
						rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
				
				Categorie categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
				
				art = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),rs.getString("description"),rs.getDate("date_debut_encheres").toLocalDate(),
						rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"), rs.getString("etat_vente"));
				
				art.setNoUtilisateur(utilisateur);
				art.setNoCategorie(categorie);
				
				liste.add(art);
				
			}

				

		} catch (SQLException e) {
			
			throw new DALException("erreur de requete de recherche d'articles", e);
		}
		}

		return liste;
	}
}
