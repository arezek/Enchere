package eni.fr.dal;

import java.util.List;

import eni.fr.bo.Enchere;

/**
 * @author EUGENIE FUCHS 
 */

public interface EnchereDAO {
	
	//Sélectionner une Enchere par son Utilisateur
	public Enchere selectById(int noUtilisateur, int noArticle) throws DALException;
				
	//Sélectionner tous les Encheres 
	public List<Enchere> selectAll() throws DALException;
				
	//Modifier les attributs d'une Enchere connu en BD
	public void update(Enchere enchere) throws DALException;
				
	//Insérer une nouvelle Enchere
	public void insert(Enchere enchere) throws DALException;
				
	//Supprimer une Enchere
	public void delete(int noArticle, int noUtilisateur) throws DALException;


}
