package uphf.ntr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter //Lombok
@Setter
@NoArgsConstructor
@Entity //JPA
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClient;
	private String nom;
	private String prenom; 
	private int solde;
	private String password;
	private int BankAccount;
	
	public Client(String nom, String prenom, String password, int bankAccount) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.solde = 0;
		this.password = password;
		this.BankAccount = bankAccount;
	}
	
	
}
