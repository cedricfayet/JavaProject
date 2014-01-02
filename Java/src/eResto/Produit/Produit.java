package eResto.Produit;
import java.util.HashSet;
import java.util.Set;
import api_perso.Observable;
import api_perso.Observer;


public class Produit implements Observable
{

    private String nom;
    private int prix;
    private ProduitTaille taille;
   
    private Set<Observer> observers = new HashSet<Observer>(); 
    public void registerObserver(Observer o) 
	{
		observers.add(o);
	}   
	public void removeObserver(Observer o) 
	{
		observers.remove(o);
	}
	public void notifyObservers() 
	{
		for(Observer o:observers)
		{
			o.update(this);
		}
	}  
    
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
		notifyObservers();
	}

	public ProduitTaille getTaille() {
		return taille;
	}
	public void setTaille(ProduitTaille taille) {
		this.taille = taille;
		notifyObservers();
	}

	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
		notifyObservers();
	}
    
    public Produit(String nom, ProduitTaille taille, int prix) 
    {
            this.setNom(nom);
            this.setTaille(taille);
            this.setPrix(prix);
    }

    public String toString() 
    {
            return("Produit("+getNom()+","+getTaille().valueOf()+"cm,"+getPrix()+")"); 
    }
    public boolean equals(Object o)
    {
        if (this == o)					return true;
        if (o == null)					return false;
        if (getClass() != o.getClass())	return false;
        
        Produit produit=(Produit)o;
        
        if(getNom() == produit.getNom() && getTaille() == produit.getTaille())
        	return true;
        
        return false;    	
    }
    public int hashCode()
    {
    	return (getNom()+"-"+getTaille().valueOf()).hashCode();
    }
    
    public void show() 
    {
            System.out.println(toString());
    }
}