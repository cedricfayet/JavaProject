import eResto.Magasin;
import eResto.Compte.Compte;
import eResto.Compte.ConnectionException;
import eResto.Compte.InscriptionException;
import eResto.Compte.VisiteurException;
import eResto.Produit.Produit;
import eResto.Produit.ProduitTaille;
import eResto.Produit.ajoutProduitException;

public class ConsoleIHM 
{
	public static void main(String[] args) 
	{
		Compte test = new Compte("contact@cfayet.eu","mdp","0649699284","22 chemin de la crx paps");
		Produit p1 = new Produit("Pizza",ProduitTaille.petite_taille,10);
		
		Magasin restaurant = Magasin.getInstance();
		
		try
		{
			restaurant.ajouterProduit(p1);
			p1.show();
			try
			{
				restaurant.ajouterCompte(test);
				try
				{
				restaurant.connecterCompte("contact@cfayet.eu","mdp");
					try
					{
						restaurant.getCompteConnecté().show();
					}
					catch(VisiteurException e)
					{
						System.out.println("Vous devez être connecté, pour la suite.");
					}
				}
				catch(ConnectionException e)
				{
					System.out.println("Connection refusée.");
				}
			}
			catch(InscriptionException e)
			{
				System.out.println("Inscription au restaurant impossible, le compte existe déjà.");
			}
		}
		catch(ajoutProduitException e)
		{
			System.out.println("Ajout d'un produit au catalogue");
		}
		
		
		
	}
}
