package eResto.Produit;


/**
 * 
 * @author Cédric Fayet
 * Cette interface permet de spécifier l'implémentation d'un gestionnaire de produit
 * 
 */

public interface ProduitGestion 
{
	public void ajouterProduit(Produit produit) throws ajoutProduitException;
	public void retirerProduit(Produit produit) throws retraitProduitException;
}
