package eni.fr.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import eni.fr.bo.Utilisateur;



public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String INSERT="INSERT INTO Utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe,credit,administrateur) VALUES(?,?,?,?,?,?,?,?,?,100,0);";
	
	@Override
	public void insert(Utilisateur utilisateur) /*throws BusinessException*/ {
//		if(utilisateur==null)
//		{
//			BusinessException businessException = new BusinessException();
//			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
//			throw businessException;
//		}
		
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
//			BusinessException businessException = new BusinessException();
//			if(e.getMessage().contains("CK_Utilisateur_note"))
//			{
//				businessException.ajouterErreur(CodesResultatDAL.INSERT_Utilisateur_NOTE_ECHEC);
//			}
//			else
//			{
//				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
//			}
//			throw businessException;
		}	
	}

	@Override
	public Utilisateur selectById(int noUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utilisateur utilisateur) throws DALException {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
