package uphf.ntr.BanqueNTR.controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uphf.ntr.BanqueNTR.model.CreateUtilisateur;
import uphf.ntr.BanqueNTR.model.Utilisateur;
import uphf.ntr.BanqueNTR.repository.UtilisateurRepository;

import uphf.ntr.BanqueNTR.model.Operation;
import uphf.ntr.BanqueNTR.repository.OperationRepository;
import uphf.ntr.BanqueNTR.services.UtilisateurService;


@CrossOrigin(origins = "http://localhost:8080/BanqueNTR", maxAge = 3600)
@RestController
@RequestMapping("/utilisateur/*")
public class UtilisateurController {
	
	  @Autowired
	UtilisateurRepository utilisateursRepository;
	  
	  @Autowired
		OperationRepository operationsRepository;

	  @GetMapping("TOUT")
	    public List<Utilisateur> getAllUtilisateurs() {
	    	return utilisateursRepository.findAll();
	    }
	  
	  
	  @GetMapping("{id}")
	    public Optional<Utilisateur> getUtilisateurById(@PathVariable("id") Long id) {
	    	
	    	Optional<Utilisateur> utilisateurs = utilisateursRepository.findById(id);
	  	        return utilisateurs;
	    }
	  
	  @PostMapping("utilisateur")
	    public Utilisateur createUtilisateur(@Validated @RequestBody CreateUtilisateur utilisateur){
	        return utilisateursRepository.save(
	                Utilisateur
	                .builder()
	                .firstname(utilisateur.getFirstname())
	                .lastname(utilisateur.getLastname())
	                .email(utilisateur.getEmail())
	                .password(utilisateur.getPassword())
	                .listeOperation(utilisateur.getListeOperation())
	                .enabled(utilisateur.getEnabled())
	                .build()
	        );
	    }
	    
	  //on ajoute une operation à un utilisateur
//	  @PutMapping("utilisateur/{id}/operation/{idOpe}")
//	    public ResponseEntity<?> ajoutOpe(@PathVariable("id") Long id,@PathVariable("idOpe") Integer idOpe){
//	    	
//	            Utilisateur utilisateur = this.utilisateursRepository.findById(id).map(
//	            		utilisateurModifie ->{
//	            		ArrayList<Operation> opeAjoute = this.operationsRepository.findById(idOpe);
//	            			if(utilisateur.getListeOperation().contains(opeAjoute)){
//	            				utilisateurModifie.setListeOperation(opeAjoute);
//	            					return utilisateursRepository.save(utilisateurModifie);
//	            			}
//	            			else{
//	            				throw new RuntimeException("Operation non trouvé");
//	            				}
//	            			}).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
//	            return ResponseEntity.ok(utilisateur);
//	        
//	        }

}
