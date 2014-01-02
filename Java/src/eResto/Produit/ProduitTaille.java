package eResto.Produit;

public enum ProduitTaille
{
	grande_taille(32),
	moyenne_taille(16),
	petite_taille(8);
 
	private final int valeur;
	
	ProduitTaille(int valeur){	this.valeur=valeur;	}
	public int valueOf(){	return valeur;	}

};
