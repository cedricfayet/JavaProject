package eResto.Commande;

import eResto.Produit.Produit;
import eResto.Produit.ajoutProduitException;
import eResto.Produit.retraitProduitException;

public abstract class EtatCommande 
{
	public abstract String toString();
	public abstract String info();
	
	public abstract void ajouterProduit(Produit produit) throws ajoutProduitException;
	public abstract void retirerProduit(Produit produit) throws retraitProduitException;
}