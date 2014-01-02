package eResto.Commande;

import java.util.List;

import eResto.Produit.Produit;
import eResto.Produit.ajoutProduitException;
import eResto.Produit.retraitProduitException;

public class EtatCommandeInitialisé extends EtatCommande 
{
	private Commande commande;
	private List<Produit> panier;

	public EtatCommandeInitialisé(Commande commande,List <Produit> panier) 
	{
		this.commande=commande;
		this.panier=panier;
	}

	@Override
	public void ajouterProduit(Produit produit) throws ajoutProduitException 
	{
		if(!panier.add(produit))
			throw new ajoutProduitException();
	}

	@Override
	public void retirerProduit(Produit produit) throws retraitProduitException 
	{
		if(!panier.remove(produit))
			throw new retraitProduitException();
	}
	
	@Override
	public String toString() 
	{
		return "instanciée";
	}

	@Override
	public String info() 
	{
		return "instance";
	}

}
