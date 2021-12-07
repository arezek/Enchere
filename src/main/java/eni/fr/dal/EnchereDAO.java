package eni.fr.dal;

import eni.fr.bo.Enchere;

/**
 * @author EUGENIE FUCHS 
 */

public interface EnchereDAO {
	
	//Sélectionner un Categorie par son noCategorie
	public Enchere selectById(int noCategorie) throws DALException;
				
	//Sélectionner tous les Categories 
	public Enchere selectAll() throws DALException;
				
	//Modifier les attributs d'un Categorie connu en BD
	public void update(Enchere enchere) throws DALException;
				
	//Insérer une nouvelle Categorie
	public void insert(Enchere enchere) throws DALException;
				
	//Supprimer une Categorie
	public void delete(int id) throws DALException;


}
