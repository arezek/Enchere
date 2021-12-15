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
import eni.fr.bo.Utilisateur;
import eni.fr.dal.CategorieDAO;

/**
* @author Eugénie FUCHS
*/


public class CategorieDAOJdbcImpl implements CategorieDAO {

	private static final String INSERT = "INSERT INTO CATEGORIES(libelle) VALUES (?)";
	private static final String SELECTBYID = "SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres, prix_initial,etat_vente,a.no_categorie, libelle FROM CATEGORIES INNER JOIN ARTICLES_VENDUS a on CATEGORIES.no_categorie=a.no_categorie WHERE a.no_categorie = ?";
	private static final String SELECTALL = "SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres, prix_initial,etat_vente,u.no_utilisateur, a.no_categorie, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur, libelle FROM CATEGORIES INNER JOIN ARTICLES_VENDUS a on CATEGORIES.no_categorie=a.no_categorie INNER JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur";
	private static final String DELETE = "DELETE FROM CATEGORIES WHERE no_categorie=?";
	private static final String UPDATE = "UPDATE CATEGORIES SET libelle = ? WHERE no_categorie = ?";
	int i;

@Override
public Categorie selectById(int noCategorie) throws DALException, BusinessException {

ResultSet rs = null;
		Categorie cat = new Categorie();
		try (Connection con = ConnectionProvider.getConnection(); 
			 PreparedStatement rqt = con.prepareStatement(SELECTBYID);)

		{
			
			rqt.setInt(1, noCategorie);
			rs = rqt.executeQuery();
			rs.next();
				
			ArticleVendu art = new ArticleVendu(rs.getInt("no_article"), 
					rs.getString("nom_article"),
					rs.getString("description"),
					rs.getDate("date_debut_encheres").toLocalDate(),
					rs.getDate("date_fin_encheres").toLocalDate(), 
					rs.getInt("prix_initial"), 
					rs.getString("etat_vente"));

			cat = new Categorie(rs.getInt("no_categorie"), 
					rs.getString("libelle"));
				
			art.setNoCategorie(cat);

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERE_BY_ID_UTILISATEUR_ECHEC);
			throw businessException;
		}

		return cat;

}

@Override
public List<Categorie> selectAll() throws DALException, BusinessException {

List<Categorie> categories= new ArrayList<Categorie>();
		try (Connection con = ConnectionProvider.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(SELECTALL);) {
			Categorie cat= null;
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

				cat = new Categorie(rs.getString("libelle"));
				
				article.setNoCategorie(cat);
				article.setNoUtilisateur(utilisateur);

				categories.add(cat);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_TOUS_CATEGORIES_ECHEC);
			throw businessException;
		}
		return categories;

}

@Override
public void update(Categorie categorie) throws DALException, BusinessException {

 try(Connection con = ConnectionProvider.getConnection();
	        PreparedStatement Pstmt = con.prepareStatement(UPDATE,PreparedStatement.RETURN_GENERATED_KEYS);
	                ) 
	        {
	        
	        	Pstmt.setString(i++, categorie.getLibelle());
	          
	            Pstmt.executeUpdate();
	            
	        } catch (Exception e) {
	        	
	        	e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.UPDATE_CATEGORIE_ECHEC);
				throw businessException;
	            
	        }

}

@Override
public void insert(Categorie categorie) throws DALException, BusinessException {

		if(categorie==null)
			{
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
				throw businessException;
			}

		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);) {

			pstmt.setString(i++, categorie.getLibelle());

			pstmt.executeUpdate(); 
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				categorie.setNoCategorie(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
				BusinessException businessException = new BusinessException();
				if(e.getMessage().contains("CK_ArticleVendu_note"))
				{
					businessException.ajouterErreur(CodesResultatDAL.INSERT_CATEGORIE_TOUS_LES_CHAMPS_ECHEC);
				}
				else
				{
					businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
				}
				throw businessException;
		}

}

@Override
public void delete(int noCategorie) throws DALException, BusinessException {

try (Connection con = ConnectionProvider.getConnection();
                PreparedStatement Pstmt = con.prepareStatement(DELETE)){
                Pstmt.setInt(1, noCategorie);
                Pstmt.executeUpdate();
        }catch (Exception e) {
        	e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_CATEGORIE_ECHEC);
			throw businessException;
    }

	}
}
