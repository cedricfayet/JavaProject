

/**
 * Cette classe permet de modéliser des produit
 * @author Matthieu Biache
 */
public class Produit {
	private int id;
	private String nom;
	private enum Taille{petit,moyen,grand};
	private Taille taille;
	private int prix;
	
	public Produit(int id, String nom, Taille taille, int prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.taille = taille;
		this.prix = prix;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setTaille(Taille taille) {
		this.taille = taille;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public Taille getTaille() {
		return taille;
	}
	public int getPrix() {
		return prix;
	}

	
	public String toString() {
		return("Produit("+getId()+","+getNom()+","+getTaille()+","+getPrix()+")"); 
	}
	
	public void affiche() {
		System.out.println(toString());
	}
	
}
