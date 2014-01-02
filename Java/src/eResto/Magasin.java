package eResto;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import eResto.Compte.Compte;
import eResto.Compte.CompteGestion;
import eResto.Compte.ConnectionException;
import eResto.Compte.InscriptionException;
import eResto.Compte.VisiteurException;
import eResto.Produit.Produit;
import eResto.Produit.ProduitGestion;
import eResto.Produit.ajoutProduitException;
import eResto.Produit.retraitProduitException;
import api_perso.Observable;
import api_perso.Observer;


public class Magasin implements CompteGestion,ProduitGestion,Observable
{
	private static Magasin uniqueInstance = null;
	private static Compte utilisateur = null;
    private Set<Produit> catalogue = new HashSet<Produit>();
    private Hashtable<String, Compte> bd_membre = new Hashtable<String, Compte>();

	
	private Magasin()
	{}
	
    private Set<Observer> observers = new HashSet<Observer>(); 
	
    @Override
    public void registerObserver(Observer o) 
	{
		observers.add(o);
	}  
    
	@Override
	public void removeObserver(Observer o) 
	{
		observers.remove(o);
	}

	@Override
	public void notifyObservers() 
	{
		for(Observer o:observers)
		{
			o.update(this);
		}
	}  
    
	public static Magasin getInstance()
	{
		if(uniqueInstance == null)
		{
			uniqueInstance=new Magasin();
		}
		
		return uniqueInstance;
	}

	// Catalogue
	@Override
	public void ajouterProduit(Produit produit) throws ajoutProduitException
	{
		if(!catalogue.add(produit))
			throw new ajoutProduitException();
		
		notifyObservers();
	}
	
	@Override
	public void retirerProduit(Produit produit) throws retraitProduitException 
	{
		if(!catalogue.remove(produit))
			throw new retraitProduitException();
		
		notifyObservers();
	}
	
	// Utilisateurs
	@Override
	public void ajouterCompte(Compte compte) throws InscriptionException
	{
		if(!bd_membre.containsKey(compte.getAdresse_mail()))
			bd_membre.put(compte.getAdresse_mail(),compte);
		else
			throw new InscriptionException();
		
		notifyObservers();
	}
	
	@Override
	public void connecterCompte(String adresse_mail, String mot_de_passe) throws ConnectionException
	{
		Compte compte;
		compte = bd_membre.get(adresse_mail);
		
		if(compte.getMot_de_passe() == mot_de_passe)
			utilisateur=compte;
		else
			throw new ConnectionException();
		
		notifyObservers();
	}
	
	@Override
	public Compte getCompteConnecté() throws VisiteurException
	{	
		if(utilisateur == null)
			throw new VisiteurException();
	
		return utilisateur;
	}

	
}
