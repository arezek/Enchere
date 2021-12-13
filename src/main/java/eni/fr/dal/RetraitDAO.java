package eni.fr.dal;

import java.util.List;

import eni.fr.bo.Retrait;

/**
 * @author ALLIOUCHE 
 */

public interface RetraitDAO {
	
			//Sélectionner un Retrait par son idRetrait
			public Retrait selectById(int noArticle) throws DALException;
			
			//Sélectionner tous les Retraits 
			public List<Retrait> selectAll() throws DALException;
			
			//Modifier les attributs d'un Retrait connu en BD
			public void update(Retrait Retrait) throws DALException;
			
			//Insérer une nouvelle Retrait
			public void insert(Retrait Retrait) throws DALException;
			
			//Supprimer une Retrait
			public void delete(int noArticle) throws DALException;
	
	
}
