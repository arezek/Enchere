package eni.fr.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import eni.fr.bo.ArticleVendu;
//yeah

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS(nom_article,description , date_debut_encheres, date_fin_encheres, prix_initial, etat_vente,no_utilisateur,no_categorie ) VALUES(?,?,?,?,?,?,?,2)";
	private static final String SEARCH = "SELECT nom_article, prix_initial, date_fin_encheres, libelle ,nom , code_postal, ville FROM ARTICLES_VENDUS INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie INNER JOIN UTILISATEURS ON UTILISATEURS.no_utilisateur = ARTICLES_VENDUS.no_utilisateur WHERE nom_article = ? AND CATEGORIES.no_categorie = ?";

	@Override
	public void insert(ArticleVendu articleVendu) throws DALException {

//		if(ArticleVendu==null)
//			{
//				BusinessException businessException = new BusinessException();
//				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
//				throw businessException;
//			}

		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);) {

			int i = 1;

			pstmt.setString(i++, articleVendu.getNomArticle());
			pstmt.setString(i++, articleVendu.getDescription());
			pstmt.setDate(i++, java.sql.Date.valueOf(articleVendu.getDateDebutEncheres()));
			pstmt.setDate(i++, java.sql.Date.valueOf(articleVendu.getDateFinEncheres()));
			pstmt.setInt(i++, articleVendu.getMiseAPrix());
			pstmt.setString(i++, articleVendu.getEtatVente());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				articleVendu.setNoArticle(rs.getInt(1));
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
		return null;

	}

	@Override
	public List<ArticleVendu> search(String nomArticle, int noCategorie) throws DALException {

		ResultSet rs = null;
		List<ArticleVendu> liste = new ArrayList<ArticleVendu>();
		try (Connection con = JdbcTools.getConnection();
				PreparedStatement rqt = con.prepareStatement(SEARCH);)

		{
			
			rqt.setString(1, nomArticle);
			rqt.setInt(2, noCategorie);
			rs = rqt.executeQuery();
			rs.next();
			
			String dateFinEnchereString = rs.getString("date_fin_encheres");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.FRENCH);
			LocalDate dateFinEnchere = LocalDate.parse(dateFinEnchereString, formatter);
			
			System.out.println(rs.getString("nom_article") + " " + rs.getInt("prix_initial") + " " + dateFinEnchere);
			ArticleVendu art = null;

		

//			SELECT nom_article as nom_art,
//			prix_initial as prix,
//			date_fin_encheres as fin_de_enchere,
//			libelle AS cat,
//			nom AS vendeur,
//			code_postal AS cp,
//			ville AS villeVendeur
//			FROM ARTICLES_VENDUS
//			INNER JOIN CATEGORIES
//			ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie
//			INNER JOIN UTILISATEURS
//			ON UTILISATEURS.no_utilisateur = ARTICLES_VENDUS.no_utilisateur
//			WHERE nom_article = 'nom_article' AND CATEGORIES.no_categorie = 1
			
			while (rs.next()) {
				art = new ArticleVendu(rs.getString("nom_article"), rs.getInt("prix_initial"), dateFinEnchere
						
//						,rs.getString("libelle"), rs.getString("nom"), rs.getString("code_postal"),
//						rs.getString("ville")
						);

				liste.add(art);

			}
			
		} catch (SQLException e) {
			throw new DALException("erreur de requete de recherche d'articles", e);
		}
		
		return liste;
	}
}
