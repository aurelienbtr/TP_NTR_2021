package uphf.ntr.rest;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Produit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduit;

	private String nom;
	private int prix;
	private String categorie;
	
	public Produit(String nom, int prix, String categorie) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
}
