package eni.fr.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import eni.fr.bo.ArticleVendu;

public class ArticleVenduDAOJdbcImpl implements  ArticleVenduDAO {

	
private static final String INSERT = "INSERT INTO ARTICLES_VENDUS(nom_article,description , date_debut_encheres, date_fin_encheres, prix_initial, etat_vente,no_utilisateur,no_categorie ) VALUES(?,?,?,?,?,?,?,2)";
private static final String SEARCH="select no_article,nom_article,date_fin_encheres,prix_initial,nom from ARTICLES_VENDUS a inner join UTILISATEURS u on a.no_utilisateur=u.no_utilisateur";

	@Override
	public void insert(ArticleVendu articleVendu) throws DALException {
		
//		if(ArticleVendu==null)
//			{
//				BusinessException businessException = new BusinessException();
//				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
//				throw businessException;
//			}
			
			try(Connection cnx = JdbcTools.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);	
				)
			{
				
				int i = 1;
				
				pstmt.setString(i++, articleVendu.getNomArticle()); 
				pstmt.setString(i++, articleVendu.getDescription());
				pstmt.setDate(i++, java.sql.Date.valueOf(articleVendu.getDateDebutEncheres()));
				pstmt.setDate(i++, java.sql.Date.valueOf(articleVendu.getDateFinEncheres()));
				pstmt.setInt(i++, articleVendu.getMiseAPrix());				
				pstmt.setString(i++, articleVendu.getEtatVente());
				
				
				
				
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next())
				{
					articleVendu.setNoArticle(rs.getInt(1));
				}
			}
			catch(Exception e)
			{
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
		
		
	}
	
	@Override
	public ArticleVendu selectById(int noArticle) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ArticleVendu articleVendu) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int noArticle) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ArticleVendu> selectAll() throws DALException {
		
	}

	@Override
	public List<ArticleVendu> search(String nomArticle, int noCategorie) throws DALException {
		

		ResultSet rs = null;
		List<ArticleVendu> liste = new ArrayList<ArticleVendu>();
		try( Connection con = JdbcTools.getConnection();
				PreparedStatement rqt = con.prepareStatement(SEARCH);)
				
				{
		
		rqt.setString(1, nomArticle);
		rs = rqt.executeQuery();
		ArticleVendu art = null;

		select no_article,nom_article,description,date_fin_encheres,
		prix_initial,nom from ARTICLES_VENDUS a inner join UTILISATEURS u
		on a.no_utilisateur=u.no_utilisateur

		while (rs.next()) {
			art = new ArticleVendu(rs.getInt("no_article"),
		rs.getString("nom_article"),
		rs.getDate(java.sql.Date.valueOf("date_fin_encheres")),
		rs.getInt("prix_initial"),
		

		liste.add(art);
		}
				} catch (SQLException e) {
					throw new DALException("erreur de requete select by Id",e);
				}
				
				return liste;
}
