package uphf.ntr.BanqueNTR.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Builder


@Entity
@Table(name="operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
	private int idUtilisateur;
	private int somme ;
	private int type;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getidUtilisateur() {
		return idUtilisateur;
	}
	public void setidUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public int getSomme() {
		return somme;
	}
	public void setSomme(int somme) {
		this.somme = somme;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		String typeOp = (type==0) ? "ACHAT" : "REMBOURSEMENT";
		
		return "Type: " + typeOp + "\n"
				+ "Montant: " + somme + "\n";
		
	}
    
	
	public Operation() {
		idUtilisateur = -1;
		type = -1;
		somme = -1;
	}
	
	public Operation(int id,int idu,int type, int somme) {
		super();
		this.id = id;
		this.idUtilisateur= idu;
		this.type = type;
		this.somme = somme;
	}
	
	public Operation(int idu, int type, int somme) {
		this.idUtilisateur= idu;
		this.type = type;
		this.somme = somme;
	}
	

	
	
	

}
