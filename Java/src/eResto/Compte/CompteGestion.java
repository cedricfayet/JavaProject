package eResto.Compte;


/**
 * 
 * @author C�dric Fayet
 * Cette interface permet de sp�cifier l'impl�mentation d'un gestionnaire de compte
 * Celui-ci doit assurer l'unicit� d'un compte
 * 
 */

public interface CompteGestion 
{
	public void ajouterCompte(Compte compte) throws InscriptionException;
	public void connecterCompte(String adresse_mail, String mot_de_passe) throws ConnectionException;
	public Compte getCompteConnect�() throws VisiteurException;
}

