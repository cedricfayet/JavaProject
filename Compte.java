/**
 * 
 * @author Cédric Fayet
 * Cette classe permet de modéliser sur le systéme un compte internet sur le site pour le client
 */

public class Compte 
{
	private static int nombre_client=0;
	private String mot_de_passe;
	private int numéro_téléphone;
	private String adresse_postale;
	private String adresse_mail;
	private int num;

	public Compte(String mot_de_passe,int numéro_téléphone,String adresse_postale,String adresse_mail)
	{
		this.num=nombre_client;
		this.mot_de_passe=mot_de_passe;
		this.numéro_téléphone=numéro_téléphone;
		this.adresse_postale=adresse_postale;
		this.adresse_mail=adresse_mail;
		
		nombre_client=nombre_client+1;
	}
	
	public String getAdresse_mail() {
		return adresse_mail;
	}
	public void setAdresse_mail(String adresse_mail) {
		this.adresse_mail = adresse_mail;
	}
	
	public String getAdresse_postale() {
		return adresse_postale;
	}
	public void setAdresse_postale(String adresse_postale) {
		this.adresse_postale = adresse_postale;
	}
	
	public int getNuméro_téléphone() {
		return numéro_téléphone;
	}
	public void setNuméro_téléphone(int numéro_téléphone) {
		this.numéro_téléphone = numéro_téléphone;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	
	public String toString()
	{
		return "Compte(num="+this.num+","++";)";
	}
}
