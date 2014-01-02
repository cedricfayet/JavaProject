package eResto.Compte;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import eResto.Commande.Commande;
import api_perso.Observable;
import api_perso.Observer;

/**
 * 
 * @author Cédric Fayet
 * Cette classe permet de modéliser sur le systéme un compte internet sur le site pour le client
 * 
 */

public class Compte implements Observable
{
        private String mot_de_passe;
        private String numéro_téléphone;
        private String adresse_postale;
        private String adresse_mail;
        private Collection<Commande> commandes;
        
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
        
		public String getMot_de_passe() {
			return mot_de_passe;
		}
		public void setMot_de_passe(String mot_de_passe) {
			this.mot_de_passe = mot_de_passe;
			notifyObservers();
		}

		public String getNuméro_téléphone() {
			return numéro_téléphone;
		}
		public void setNuméro_téléphone(String numéro_téléphone) {
			this.numéro_téléphone = numéro_téléphone;
			notifyObservers();
		}

		public String getAdresse_postale() {
			return adresse_postale;
		}
		public void setAdresse_postale(String adresse_postale) {
			this.adresse_postale = adresse_postale;
			notifyObservers();
		}

		public String getAdresse_mail() {
			return adresse_mail;
		}
		public void setAdresse_mail(String adresse_mail) {
			this.adresse_mail = adresse_mail;
			notifyObservers();
		}

        public Compte(String adresse_mail,String mot_de_passe,String numéro_téléphone,String adresse_postale)
        {
                this.setMot_de_passe(mot_de_passe);
                this.setNuméro_téléphone(numéro_téléphone);
                this.setAdresse_postale(adresse_postale);
                this.setAdresse_mail(adresse_mail);
        }
        
        public String toString() 
        {
                return("Compte("+getAdresse_mail()+","+getMot_de_passe()+","+getNuméro_téléphone()+","+getAdresse_postale()+")"); 
        }   
        public boolean equals(Object o)
        {
            if (this == o)					return true;
            if (o == null)					return false;
            if (getClass() != o.getClass())	return false;
            
            Compte compte=(Compte)o;
            
            if(getAdresse_mail() == compte.getAdresse_mail())
            	return true;
            
            return false;    	
        }
        public int hashCode()
        {
        	return getAdresse_mail().hashCode();
        }
        
        public void show() 
        {        
                System.out.println(toString());
        }


}