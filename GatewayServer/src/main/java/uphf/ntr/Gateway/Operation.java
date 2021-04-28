package uphf.ntr.Gateway;
import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
   
    private String date;
	private int idUtilisateur;
	private int somme ;
	private int type;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	
	
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
				+ "Montant: " + somme + "\n"
				+"Date: " + date;
		
	}
    
	
	public Operation() {
		idUtilisateur = -1;
		type = -1;
		somme = -1;
		date = null;
	}
	
	public Operation(int id,int idu, String date, int type, int somme) {
		this.id = id;
		this.idUtilisateur= idu;
		this.date = date;
		this.type = type;
		this.somme = somme;
	}
	
	public Operation(int idu, String date, int type, int somme) {
		this.idUtilisateur= idu;
		this.date = date;
		this.type = type;
		this.somme = somme;
	}
	
	public Operation(int idu, int type, int somme) {
		this.idUtilisateur= idu;
		this.date = formatter.format(new Date());
		this.type = type;
		this.somme = somme;
	}
	
	
	

}
