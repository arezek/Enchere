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


public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String INSERT="INSERT INTO Utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe,credit,administrateur) VALUES(?,?,?,?,?,?,?,?,?,100,0);";
	private static final String SELECTBYID = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS  WHERE no_utilisateur =?";
	private static final String SELECTBYPSEUDO = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS  WHERE pseudo=?";
	private static final String SELECTALL = "SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres, prix_initial,etat_vente, ARTICLES_VENDUS.no_utilisateur,ARTICLES_VENDUS.no_categorie, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur, libelle FROM UTILISATEURS  INNER JOIN ARTICLES_VENDUS ON UTILISATEURS.no_utilisateur = ARTICLES_VENDUS.no_utilisateur inner join CATEGORIES on CATEGORIES.no_categorie=ARTICLES_VENDUS.no_categorie";
	private static final String DELETE = "delete from UTILISATEURS where no_utilisateur=?";
//	private static final String UPDATE = "UPDATE UTILISATEURS SET ? = ? WHERE no_utilisateur = ?";
	int i = 1;
	private static final String SELECTCOUNTBYPSEUDO = "SELECT COUNT(*) as compteur FROM UTILISATEURS WHERE pseudo = ?";
	
	@Override 
	public int selectCountByPseudo(String pseudo) throws DALException, BusinessException {
		
		int nombrePseudo;
		ResultSet rs = null;

		try (Connection con = ConnectionProvider.getConnection(); 
			 PreparedStatement rqt = con.prepareStatement(SELECTCOUNTBYPSEUDO);)
		{
			
			
			rqt.setString(1, pseudo);
			rs = rqt.executeQuery();
			rs.next();

			nombrePseudo = rs.getInt("compteur");

		} catch (Exception e) {
			
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_Utilisateur_BY_PSEUDO_ECHEC);
			throw businessException;
		}

		
		return nombrePseudo;
	}
	
	@Override
	public void insert(Utilisateur utilisateur) throws DALException,BusinessException{
		
		if(utilisateur==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);	
			)
		{
			
			int i = 1;
			pstmt.setString(i++, utilisateur.getPseudo()); 
			pstmt.setString(i++, utilisateur.getNom());
			pstmt.setString(i++, utilisateur.getPrenom());
			pstmt.setString(i++, utilisateur.getEmail());
			pstmt.setString(i++, utilisateur.getTelephone());
			pstmt.setString(i++, utilisateur.getRue());
			pstmt.setString(i++, utilisateur.getCodePostal());
			pstmt.setString(i++, utilisateur.getVille());
			pstmt.setString(i++, utilisateur.getMotDePasse());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if(e.getMessage().contains("CK_Utilisateur_note"))
			{
				businessException.ajouterErreur(CodesResultatDAL.INSERT_TOUS_LES_CHAMPS_ECHEC);
			}
			else
			{
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			}
			throw businessException;
		}	
	}

	@Override
	public Utilisateur selectById(int noArticle) throws DALException,BusinessException {
		ResultSet rs = null;
		Utilisateur utilisateur = new Utilisateur();
		try (Connection con = ConnectionProvider.getConnection(); 
			 PreparedStatement rqt = con.prepareStatement(SELECTBYID);)

		{
			
			rqt.setInt(1, noArticle);
			rs = rqt.executeQuery();
			rs.next();

			utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), 
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
				
			
			System.out.println(utilisateur.getPseudo() + " " + utilisateur.getNom());

		} catch (Exception e) {
			
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_Utilisateur_BY_ID_ECHEC);
			throw businessException;
		}

		return utilisateur;
	}
	
	@Override
	public Utilisateur selectByPseudo(String pseudo) throws DALException,BusinessException {
		ResultSet rs = null;
		Utilisateur utilisateur = new Utilisateur();
		try (Connection con = ConnectionProvider.getConnection(); 
			 PreparedStatement rqt = con.prepareStatement(SELECTBYPSEUDO);)

		{
			
			rqt.setString(1, pseudo);
			rs = rqt.executeQuery();
			rs.next();

			utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), 
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
				
			
			System.out.println(utilisateur.getPseudo() + " " + utilisateur.getNom());

		} catch (Exception e) {
			
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_Utilisateur_BY_PSEUDO_ECHEC);
			throw businessException;
		}

		return utilisateur;
	}

	@Override
	public List<Utilisateur> selectAll() throws DALException,BusinessException {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		try (Connection con = ConnectionProvider.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(SELECTALL);) {
			Utilisateur utilisateur= null;
			while (rs.next()) {
				
				ArticleVendu article = new ArticleVendu(rs.getInt("no_article"),
						rs.getString("nom_article"),
						rs.getDate("date_fin_encheres").toLocalDate(),
						rs.getInt("prix_initial"),
						rs.getString("etat_vente"));
				
				Categorie categorie = new Categorie(rs.getString("libelle"));
				
				utilisateur = new Utilisateur(rs.getInt("no_utilisateur"),
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
				
				article.setNoUtilisateur(utilisateur);
				article.setNoCategorie(categorie);
				
				utilisateurs.add(utilisateur);
		
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_TOUS_Utilisateurs_ECHEC);
			throw businessException;
		}
		return utilisateurs;
	}

	@Override
	public void update(String champs, String valeur, Utilisateur utilisateur) throws DALException, BusinessException {
		String UPDATE = null;
		if(champs.equals("pseudo")) {
			UPDATE = "UPDATE UTILISATEURS SET pseudo = ? WHERE no_utilisateur = ?";
		}
		else if(champs.equals("nom")) {
			UPDATE = "UPDATE UTILISATEURS SET nom = ? WHERE no_utilisateur = ?";
		}
		else if(champs.equals("prenom")) {
			UPDATE = "UPDATE UTILISATEURS SET prenom = ? WHERE no_utilisateur = ?";
		}
		else if(champs.equals("email")) {
			UPDATE = "UPDATE UTILISATEURS SET email = ? WHERE no_utilisateur = ?";
		}
		else if(champs.equals("telephone")) {
			UPDATE = "UPDATE UTILISATEURS SET telephone = ? WHERE no_utilisateur = ?";
		}
		else if(champs.equals("rue")) {
			UPDATE = "UPDATE UTILISATEURS SET rue = ? WHERE no_utilisateur = ?";
		}
		else if(champs.equals("codePostal")) {
			UPDATE = "UPDATE UTILISATEURS SET codePostal = ? WHERE no_utilisateur = ?";
		}
		else if(champs.equals("ville")) {
			UPDATE = "UPDATE UTILISATEURS SET ville = ? WHERE no_utilisateur = ?";
		}
		else if(champs.equals("mot_de_passe")) {
			UPDATE = "UPDATE UTILISATEURS SET mot_de_passe = ? WHERE no_utilisateur = ?";
		}
		else if(champs.equals("credit")) {
			UPDATE = "UPDATE UTILISATEURS SET credit = ? WHERE no_utilisateur = ?";
		}
		  try(Connection con = ConnectionProvider.getConnection();
			        PreparedStatement Pstmt = con.prepareStatement(UPDATE,PreparedStatement.RETURN_GENERATED_KEYS);
			                ) 
			        {
			        
			  
//			        	Pstmt.setString(1,champs);
						Pstmt.setString(1, valeur);
						Pstmt.setInt(2, utilisateur.getNoUtilisateur());
			          System.out.println(Pstmt.toString());
			            Pstmt.executeUpdate();
			            
			        } catch (Exception e) {
			        	
			        	e.printStackTrace();
						BusinessException businessException = new BusinessException();
						businessException.ajouterErreur(CodesResultatDAL.UPDATE_UTILISATEUR_ECHEC);
						throw businessException;
			            
			        }
		
	}


	@Override
	public void delete(int noUtilisateur) throws  DALException,BusinessException {
		try (Connection con = ConnectionProvider.getConnection();
                PreparedStatement Pstmt = con.prepareStatement(DELETE)){
                Pstmt.setInt(1, noUtilisateur);
                Pstmt.executeUpdate();
        }catch (Exception e) {
        	e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_UTILISATEUR_ECHEC);
			throw businessException;
            
    }
		
	}

}
