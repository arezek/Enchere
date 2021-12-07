package eni.fr.dal;

import eni.fr.bo.Utilisateur;

public class testDal {

	public testDal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Utilisateur test1 = new Utilisateur("gege", "gérard", "bouchard", "gege@mail.com", "tel", "rue", "cp", "ville", "mdp fdp") ;
		UtilisateurDAOJdbcImpl testinsert = new UtilisateurDAOJdbcImpl();
		testinsert.insert(test1); 
	}

}
