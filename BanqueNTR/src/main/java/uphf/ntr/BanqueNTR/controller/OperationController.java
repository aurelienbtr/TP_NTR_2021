package uphf.ntr.BanqueNTR.controller;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uphf.ntr.BanqueNTR.model.CreateOperation;
import uphf.ntr.BanqueNTR.model.Operation;
import uphf.ntr.BanqueNTR.repository.OperationRepository;



@CrossOrigin(origins = "http://localhost:8080/BanqueNTR", maxAge = 3600)
@RestController
@RequestMapping("/operation/*")
public class OperationController {
	
	  @Autowired
	OperationRepository operationsRepository;

	  @GetMapping("TOUT")
	    public List<Operation> getAllOperations() {
	    	return operationsRepository.findAll();
	    }
	  
	  
	  @GetMapping("{id}")
	    public Optional<Operation> getOperationById(@PathVariable("id") Integer id) {
	    	
	    	Optional<Operation> operations = operationsRepository.findById(id);
	  	        return operations;
	    }
	  
	  
	  @PostMapping("operation")
	    public Operation createOperation(@Validated @RequestBody CreateOperation operation){
	        return operationsRepository.save(
	        		Operation
	                .builder()
	                .somme(operation.getSomme())
	                .type(operation.getType())
	                .idUtilisateur(operation.getIdUtilisateur())
	                .build()
	        );
	    }
	      
	  
}

