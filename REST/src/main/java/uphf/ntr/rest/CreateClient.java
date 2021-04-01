package uphf.ntr.rest;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CreateClient {
 
	private String etat;
	private int idClient;
	private String nom;
	private String prenom; 
	private int solde;
	private boolean actif;
  
	   public String getEtat() {
			return etat;
		}
		public void setEtat(String etat) {
			this.etat = etat;
		}
		public int getIdClient() {
			return idClient;
		}
		public void setIdClient(int idClient) {
			this.idClient = idClient;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public int getSolde() {
			return solde;
		}
		public void setSolde(int solde) {
			this.solde = solde;
		}
		public boolean isActif() {
			return actif;
		}
		public void setActif(boolean actif) {
			this.actif = actif;
		}
		public CreateClient(String etat, int idClient, String nom, String prenom, int solde, boolean actif) {
			super();
			this.etat = etat;
			this.idClient = idClient;
			this.nom = nom;
			this.prenom = prenom;
			this.solde = solde;
			this.actif = actif;
		}
		
		
		

}