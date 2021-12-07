package eni.fr.dal;


import eni.fr.bo.Categorie;

/**
 * @author ALLIOUCHE 
 */

public interface CategorieDAO {
		//Sélectionner un Categorie par son noCategorie
		public Categorie selectById(int noCategorie) throws DALException;
		
		//Sélectionner tous les Categories 
		public Categorie selectAll() throws DALException;
		
		//Modifier les attributs d'un Categorie connu en BD
		public void update(Categorie categorie) throws DALException;
		
		//Insérer une nouvelle Categorie
		public void insert(Categorie categorie) throws DALException;
		
		//Supprimer une Categorie
		public void delete(int id) throws DALException;
	
}
