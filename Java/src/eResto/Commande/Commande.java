package eResto.Commande;

import java.util.List;
import java.util.Vector;

import eResto.Produit.Produit;
import eResto.Produit.ProduitGestion;
import eResto.Produit.ajoutProduitException;
import eResto.Produit.retraitProduitException;
import api_perso.DateModifiable;

public class Commande implements ProduitGestion
{
	private DateModifiable dateFacturation;
	private EtatCommande etat;
	private List <Produit> panier;
	
	public void setEtat(EtatCommande etat)
	{
		this.etat=etat;
	}
	
	public Commande() 
	{
		dateFacturation=new DateModifiable();
		panier=new Vector();
		etat=new EtatCommandeInitialisé(this,panier);
	}
	
	public String toString() 
	{
		return "Commande(etat:"+etat.toString()+")";
	}
	  
	public void show() 
	{
		 System.out.println(toString());
	}
	
	public String info()
	{
		return etat.info();
	}

	@Override
	public void ajouterProduit(Produit produit) throws ajoutProduitException 
	{
		etat.ajouterProduit(produit);
	}

	@Override
	public void retirerProduit(Produit produit) throws retraitProduitException 
	{
		etat.retirerProduit(produit);
	}
	
	
}
