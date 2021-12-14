package eni.fr.dal;

import java.util.List;

import eni.fr.bo.Utilisateur;

/**
 * @author EUGENIE FUCHS 
 */

public interface UtilisateurDAO {

	//Sélectionner un utilisateur par son noUtilisateur
	public Utilisateur selectById(int noUtilisateur) throws DALException;
	
	//Sélectionner un utilisateur par son pseudo
	public Utilisateur selectByPseudo(String pseudo) throws DALException;
			
	//Sélectionner tous les utilisateurs
	public List<Utilisateur> selectAll() throws DALException;
				
	//Modifier les attributs d'un utilisateur connu en BD
	public void update(String champs, String valeur, Utilisateur utilisateur) throws DALException;
				
	//Insérer un nouvel utilisateur
	public void insert(Utilisateur utilisateur) throws DALException;
				
	//Supprimer un utilisateur
	public void delete(int noUtilisateur) throws DALException;
	
}
