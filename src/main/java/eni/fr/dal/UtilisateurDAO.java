package eni.fr.dal;

import eni.fr.bo.Utilisateur;

/**
 * @author EUGENIE FUCHS 
 */

public class UtilisateurDAO {
	
	//Sélectionner un Categorie par son noCategorie
	public Utilisateur selectById(int noUtilisateur) throws DALException;
			
	//Sélectionner tous les Categories 
	public Utilisateur selectAll() throws DALException;
			
	//Modifier les attributs d'un Categorie connu en BD
	public void update(Utilisateur utilisateur) throws DALException;
			
	//Insérer une nouvelle Categorie
	public void insert(Utilisateur utilisateur) throws DALException;
			
	//Supprimer une Categorie
	public void delete(int id) throws DALException;

}
