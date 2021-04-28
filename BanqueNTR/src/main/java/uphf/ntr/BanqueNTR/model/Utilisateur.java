package uphf.ntr.BanqueNTR.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;


@Builder

@Entity
@Table(name="UTILISATEUR")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", updatable = false, nullable = false)
    private Long id ;

    @Column(name = "FIRSTNAME", unique=false, insertable=true, updatable=true, nullable=false)
    private String firstname ;

    @Column(name = "LASTNAME", unique=false, insertable=true, updatable=true, nullable=false)
    private String lastname ;

    @Column(name = "EMAIL", unique=true, insertable=true, updatable=true, nullable=false)
    private String email;

    @Column(name = "PASSWORD", insertable=true, updatable=true, nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password ;

    @Column(name = "IS_ENABLED", insertable=true, updatable = true, nullable=false)
    private int enabled ;
    
    @Column(name = "OPERATION", insertable=true, updatable = true, nullable=false)
	private ArrayList<Operation> listeOperation;
    
    public Utilisateur() {
    	super();
    }

    public Utilisateur(String firstname, String lastname, String email, String password, int enabled) {
    	this.firstname = firstname;
    	this.lastname = lastname;
    	this.email = email;
        this.password = password;
        this.enabled = enabled;
    }
    
	public Utilisateur(Long id, String email, String password, int enabled, String firstname, String lastname) {
		this.id= id;
		this.firstname = firstname;
    	this.lastname = lastname;
    	this.email = email;
        this.password = password;
        this.enabled = enabled;
	}
	
	public Utilisateur(String email, String password) {
		this.email=email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}



	public ArrayList<Operation> getListeOperation() {
		return listeOperation;
	}

	public void setListeOperation(ArrayList<Operation> listeOperation) {
		this.listeOperation = listeOperation;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", enabled=" + enabled + ", listeOperation=" + listeOperation + "]";
	}

	public Utilisateur(Long id, String firstname, String lastname, String email, String password, int enabled,
			ArrayList<Operation> listeOperation) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.listeOperation = listeOperation;
	}

}