package eResto.Compte;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import eResto.Commande.Commande;
import api_perso.Observable;
import api_perso.Observer;

/**
 * 
 * @author C�dric Fayet
 * Cette classe permet de mod�liser sur le syst�me un compte internet sur le site pour le client
 * 
 */

public class Compte implements Observable
{
        private String mot_de_passe;
        private String num�ro_t�l�phone;
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

		public String getNum�ro_t�l�phone() {
			return num�ro_t�l�phone;
		}
		public void setNum�ro_t�l�phone(String num�ro_t�l�phone) {
			this.num�ro_t�l�phone = num�ro_t�l�phone;
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

        public Compte(String adresse_mail,String mot_de_passe,String num�ro_t�l�phone,String adresse_postale)
        {
                this.setMot_de_passe(mot_de_passe);
                this.setNum�ro_t�l�phone(num�ro_t�l�phone);
                this.setAdresse_postale(adresse_postale);
                this.setAdresse_mail(adresse_mail);
        }
        
        public String toString() 
        {
                return("Compte("+getAdresse_mail()+","+getMot_de_passe()+","+getNum�ro_t�l�phone()+","+getAdresse_postale()+")"); 
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