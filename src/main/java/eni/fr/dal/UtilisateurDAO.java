package eni.fr.dal;

import java.util.List;

import eni.fr.BusinessException;
import eni.fr.bo.Utilisateur;

/**
 * @author EUGENIE FUCHS 
 */

public interface UtilisateurDAO {
	
	//Compter le nombre d'utilisateur dont le pseudo est XXX
	public int selectCountByPseudo(String pseudo) throws  BusinessException;

	//Sélectionner un utilisateur par son noUtilisateur
	public Utilisateur selectById(int noUtilisateur) throws  BusinessException;
	
	
	//Sélectionner un utilisateur par son pseudo
	public Utilisateur selectByPseudo(String pseudo) throws  BusinessException;
			
	//Sélectionner tous les utilisateurs
	public List<Utilisateur> selectAll() throws BusinessException;
				
	//Modifier les attributs d'un utilisateur connu en BD
	public void update(String champs, String valeur, Utilisateur utilisateur) throws  BusinessException;
				
	//Insérer un nouvel utilisateur
	public void insert(Utilisateur utilisateur) throws  BusinessException;
				
	//Supprimer un utilisateur
	public void delete(int noUtilisateur) throws  BusinessException;
	
}
