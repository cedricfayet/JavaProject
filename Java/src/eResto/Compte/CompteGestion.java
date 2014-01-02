package eResto.Compte;


/**
 * 
 * @author Cédric Fayet
 * Cette interface permet de spécifier l'implémentation d'un gestionnaire de compte
 * Celui-ci doit assurer l'unicité d'un compte
 * 
 */

public interface CompteGestion 
{
	public void ajouterCompte(Compte compte) throws InscriptionException;
	public void connecterCompte(String adresse_mail, String mot_de_passe) throws ConnectionException;
	public Compte getCompteConnecté() throws VisiteurException;
}

