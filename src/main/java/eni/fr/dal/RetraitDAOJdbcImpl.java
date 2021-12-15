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
import eni.fr.bo.Retrait;
import eni.fr.bo.Utilisateur;


/**
* @author Eugénie FUCHS
*/

public class RetraitDAOJdbcImpl implements RetraitDAO {

	private static final String INSERT = "INSERT INTO RETRAITS(rue, code_postal, ville, no_article) VALUES (?, ?, ?, ?)";
	private static final String SELECTBYID = "SELECT a.no_article, nom_article,description,date_debut_encheres,date_fin_encheres, prix_initial,etat_vente, rue, code_postal, ville FROM RETRAITS INNER JOIN ARTICLES_VENDUS a on RETRAITS.no_article=a.no_article WHERE a.no_article = ?";
	private static final String SELECTALL = "SELECT r.no_article, nom_article,description,date_debut_encheres,date_fin_encheres, prix_initial,etat_vente, r.rue, r.code_postal, r.ville, a.no_utilisateur, a.no_categorie, pseudo, nom, prenom, email, telephone, u.rue, u.code_postal, u.ville, mot_de_passe, credit, administrateur, libelle FROM RETRAITS r INNER JOIN ARTICLES_VENDUS a on r.no_article=a.no_article INNER JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur INNER JOIN CATEGORIES c ON a.no_categorie=c.no_categorie";
	private static final String DELETE = "DELETE FROM RETRAITS WHERE no_article = ?";
	private static final String UPDATE = "UPDATE RETRAITS SET rue= ?, code_postal = ?, ville = ? WHERE no_article = ?";
	int i=1;

public Retrait selectById(int noArticle) throws BusinessException {

ResultSet rs = null;
		Retrait retrait = new Retrait();
		try (Connection con = ConnectionProvider.getConnection(); 
			 PreparedStatement rqt = con.prepareStatement(SELECTBYID);)

		{
			
			rqt.setInt(1, noArticle);
			rs = rqt.executeQuery();
			rs.next();
				
			ArticleVendu art = new ArticleVendu(rs.getInt("no_article"), 
					rs.getString("nom_article"),
					rs.getString("description"),
					rs.getDate("date_debut_encheres").toLocalDate(),
					rs.getDate("date_fin_encheres").toLocalDate(), 
					rs.getInt("prix_initial"), 
					rs.getString("etat_vente"));

			retrait = new Retrait(rs.getString("rue"), 
					rs.getString("code_postal"),
					rs.getString("ville"));
				
			retrait.setNoArticle(art);

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_RETRAIT_BY_ID_ECHEC);
			throw businessException;
		}

		return retrait;

}

public List<Retrait> selectAll() throws BusinessException {

List<Retrait> retraits = new ArrayList<Retrait>();
		try (Connection con = ConnectionProvider.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(SELECTALL);) {
			Retrait retrait= null;
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

				retrait = new Retrait(rs.getString("rue"), 
					rs.getString("code_postal"),
					rs.getString("ville"));

				retrait.setNoArticle(article);
				article.setNoCategorie(cat);
				article.setNoUtilisateur(utilisateur);

				retraits.add(retrait);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_TOUS_RETRAIT_ECHEC);
			throw businessException;
		}
		return retraits;

}

public void update(Retrait retrait) throws BusinessException {

 try(Connection con = ConnectionProvider.getConnection();
	        PreparedStatement Pstmt = con.prepareStatement(UPDATE,PreparedStatement.RETURN_GENERATED_KEYS);
	                ) 
	        {
	        
	        	Pstmt.setString(i++, retrait.getRue());
			Pstmt.setString(i++, retrait.getCodePostal());
			Pstmt.setString(i++, retrait.getVille());
	          
	            Pstmt.executeUpdate();
	            
	        } catch (Exception e) {
	        	
	        	e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.UPDATE_RETRAIT_ECHEC);
				throw businessException;
	            
	        }

}

public void insert(Retrait retrait) throws BusinessException {

		if(retrait==null)
			{
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
				throw businessException;
			}

		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);) {

			pstmt.setString(i++, retrait.getRue());
			pstmt.setString(i++, retrait.getCodePostal());
			pstmt.setString(i++, retrait.getVille());
			pstmt.setInt(i++, retrait.getNoArticle().getNoArticle());

			pstmt.executeUpdate(); 
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				retrait.getNoArticle().setNoArticle(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
				BusinessException businessException = new BusinessException();
				if(e.getMessage().contains("CK_ArticleVendu_note"))
				{
					businessException.ajouterErreur(CodesResultatDAL.INSERT_RETRAIT_TOUS_LES_CHAMPS_ECHEC);
				}
				else
				{
					businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
				}
				throw businessException;
		}

}

public void delete(int noArticle) throws BusinessException {

try (Connection con = ConnectionProvider.getConnection();
                PreparedStatement Pstmt = con.prepareStatement(DELETE)){
                Pstmt.setInt(1, noArticle);
                Pstmt.executeUpdate();
        }catch (Exception e) {
        	e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_RETRAIT_ECHEC);
			throw businessException;
    }

}
}