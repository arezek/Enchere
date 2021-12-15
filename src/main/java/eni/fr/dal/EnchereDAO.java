package eni.fr.dal;

import java.util.List;

import eni.fr.BusinessException;
import eni.fr.bo.Enchere;

/**
 * @author EUGENIE FUCHS 
 */


public interface EnchereDAO {
	
	//Sélectionner une Enchere par son Utilisateur
	public Enchere selectById(int noUtilisateur, int noArticle) throws DALException,BusinessException;
				
	//Sélectionner tous les Encheres 
	public List<Enchere> selectAll() throws DALException,BusinessException;
				
	//Modifier les attributs d'une Enchere connu en BD
	public void update(Enchere enchere) throws DALException,BusinessException;
				
	//Insérer une nouvelle Enchere
	public void insert(Enchere enchere) throws DALException,BusinessException;
				
	//Supprimer une Enchere
	public void delete(int noArticle, int noUtilisateur) throws DALException,BusinessException;


}
