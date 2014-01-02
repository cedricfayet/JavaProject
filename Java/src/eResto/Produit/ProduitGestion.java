package eResto.Produit;


/**
 * 
 * @author C�dric Fayet
 * Cette interface permet de sp�cifier l'impl�mentation d'un gestionnaire de produit
 * 
 */

public interface ProduitGestion 
{
	public void ajouterProduit(Produit produit) throws ajoutProduitException;
	public void retirerProduit(Produit produit) throws retraitProduitException;
}
