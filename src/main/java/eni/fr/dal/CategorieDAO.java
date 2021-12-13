package eni.fr.dal;


import java.util.List;

import eni.fr.bo.Categorie;

/**
 * @author ALLIOUCHE 
 */

public interface CategorieDAO {
		//Sélectionner un Categorie par son noCategorie (test)
		public Categorie selectById(int noCategorie) throws DALException;
		
		//Sélectionner tous les Categories 
		public List<Categorie> selectAll() throws DALException;
		
		//Modifier les attributs d'un Categorie connu en BD (test)
		public void update(Categorie categorie) throws DALException;
		
		//Insérer une nouvelle Categorie
		public void insert(Categorie categorie) throws DALException;
		
		//Supprimer une Categorie
		public void delete(int noCategorie) throws DALException;
	
}
