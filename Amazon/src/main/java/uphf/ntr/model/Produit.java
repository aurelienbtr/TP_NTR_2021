package uphf.ntr.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Builder;

@Builder
public class Produit {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduit;

	private String nom;
	private int prix;
	private String categorie;
	
	@ManyToOne
    private Client owner;

	
	public Produit(String nom, int prix, String categorie, Client owner) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
		this.owner = owner;
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


	public Client getOwner() {
		return owner;
	}


	public void setOwner(Client owner) {
		this.owner = owner;
	}



	public Produit(int idProduit, String nom, int prix, String categorie, Client owner) {
		super();
		this.idProduit = idProduit;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
		this.owner = owner;
	}
	
	
}
