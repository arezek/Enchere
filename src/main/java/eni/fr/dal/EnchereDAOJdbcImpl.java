package eni.fr.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eni.fr.BusinessException;
import eni.fr.bo.ArticleVendu;
import eni.fr.bo.Categorie;
import eni.fr.bo.Enchere;
import eni.fr.bo.Retrait;
import eni.fr.bo.Utilisateur;

/**
* @author Eugénie FUCHS
*/

public class EnchereDAOJdbcImpl implements EnchereDAO {

	private static final String INSERT = "INSERT INTO ENCHERES(rue, code_postal, ville, no_article) VALUES (?, ?, ?, ?)";
	private static final String SELECTBYID = "SELECT a.no_article, nom_article,description,date_debut_encheres,date_fin_encheres, prix_initial,etat_vente, u.no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur,date_enchere, montant_enchere FROM ENCHERES e INNER JOIN UTILISATEURS u ON u.no_utilisateur=e.no_utilisateur INNER JOIN ARTICLES_VENDUS a on a.no_article=e.no_article WHERE a.no_article = ?";
	private static final String SELECTALL = "SELECT e.no_article, nom_article,description,date_debut_encheres,date_fin_encheres, prix_initial,etat_vente, a.no_utilisateur, a.no_categorie, pseudo, nom, prenom, email, telephone, u.rue, u.code_postal, u.ville, mot_de_passe, credit, administrateur, libelle, date_enchere, montant_enchere FROM ENCHERES e INNER JOIN ARTICLES_VENDUS a on e.no_article=a.no_article INNER JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur INNER JOIN CATEGORIES c ON a.no_categorie=c.no_categorie";
	private static final String UPDATE = "UPDATE ENCHERES SET date_enchere =?, montant_enchere= ? WHERE no_article = ? AND no_utilisateur = ?";
	private static final String DELETE = "DELETE from ENCHERES where no_article=? and no_utilisateur =?";
	int i;

public Enchere selectById(int noUtilisateur, int noArticle) throws DALException,BusinessException {

ResultSet rs = null;
		Enchere enchere = new Enchere();
		try (Connection con = ConnectionProvider.getConnection(); 
			 PreparedStatement rqt = con.prepareStatement(SELECTBYID);)

		{
			
			rqt.setInt(1, noArticle);
			rqt.setInt(1, noUtilisateur);
			rs = rqt.executeQuery();
			rs.next();
				
			ArticleVendu art = new ArticleVendu(rs.getInt("no_article"), 
					rs.getString("nom_article"),
					rs.getString("description"),
					rs.getDate("date_debut_encheres").toLocalDate(),
					rs.getDate("date_fin_encheres").toLocalDate(), 
					rs.getInt("prix_initial"), 
					rs.getString("etat_vente"));

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

			enchere = new Enchere(rs.getDate("date_enchere").toLocalDate(),
					rs.getInt("montant_enchere"));
				
			enchere.setNoUtilisateur(utilisateur);
			enchere.setNoArticle(art);

		} catch (Exception e) {
			
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERE_BY_ID_UTILISATEUR_ARTICLE_ECHEC);
			throw businessException;
            
		}

		return enchere;

}

public List<Enchere> selectAll() throws DALException, BusinessException {

List<Enchere> encheres = new ArrayList<Enchere>();
		try (Connection con = ConnectionProvider.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(SELECTALL);) {
			Enchere enchere = null;
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
				
				ArticleVendu article = new ArticleVendu(rs.getInt("no_article"),
						rs.getString("nom_article"),
						rs.getDate("date_fin_encheres").toLocalDate(),
						rs.getInt("prix_initial"),
						rs.getString("etat_vente"));

				Categorie cat = new Categorie(rs.getString("libelle"));

				enchere = new Enchere(rs.getDate("date_enchere").toLocalDate(),
					rs.getInt("montant_enchere"));

				article.setNoUtilisateur(utilisateur);
				enchere.setNoArticle(article);
				article.setNoCategorie(cat);
				
				encheres.add(enchere);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_TOUS_ENCHERES_ECHEC);
			throw businessException;
		}
		return encheres;

}

public void update(Enchere enchere) throws DALException, BusinessException {

 try(Connection con = ConnectionProvider.getConnection();
	        PreparedStatement Pstmt = con.prepareStatement(UPDATE,PreparedStatement.RETURN_GENERATED_KEYS);
	                ) 
	        {
	        
	        	Pstmt.setDate(i++, java.sql.Date.valueOf(enchere.getDateEnchere()));
			Pstmt.setInt(i++, enchere.getMontantEnchere());
	          
	            Pstmt.executeUpdate();
	            
	        } catch (Exception e) {
	        	
	        	e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.UPDATE_ENCHERE_ECHEC);
				throw businessException;
	            
	        }

}

public void insert(Enchere enchere) throws DALException, BusinessException {

		if(enchere==null)
			{
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
				throw businessException;
			}

		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);) {

			pstmt.setDate(i++, java.sql.Date.valueOf(enchere.getDateEnchere()));
			pstmt.setInt(i++, enchere.getMontantEnchere());
			pstmt.setInt(i++, enchere.getNoUtilisateur().getNoUtilisateur());
			pstmt.setInt(i++, enchere.getNoArticle().getNoArticle());

			pstmt.executeUpdate(); 
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				//enchere.setNoArticle(rs.getInt(1));
				//enchere.setNoUtilisateur(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
				BusinessException businessException = new BusinessException();
				if(e.getMessage().contains("CK_ArticleVendu_note"))
				{
					businessException.ajouterErreur(CodesResultatDAL.INSERT_ENCHERE_TOUS_LES_CHAMPS_ECHEC);
				}
				else
				{
					businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
				}
				throw businessException;
		}

}

public void delete(int noArticle, int noUtilisateur) throws DALException, BusinessException {

try (Connection con = ConnectionProvider.getConnection();
                PreparedStatement Pstmt = con.prepareStatement(DELETE)){
                Pstmt.setInt(1, noArticle);
		Pstmt.setInt(1, noUtilisateur);
                Pstmt.executeUpdate();
        }catch (Exception e) {
        	e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_ENCHERE_ECHEC);
			throw businessException;
    }

}
}





