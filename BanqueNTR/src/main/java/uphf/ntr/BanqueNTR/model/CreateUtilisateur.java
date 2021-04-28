package uphf.ntr.BanqueNTR.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUtilisateur {

	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private int enabled;
	private ArrayList<Operation> listeOperation;
    
}