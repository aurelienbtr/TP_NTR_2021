package uphf.ntr.controller;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uphf.ntr.rest.*;
import uphf.ntr.rest.exception.ClientIntrouvableException;
import uphf.ntr.rest.repository.ClientRepository;
import uphf.ntr.rest.repository.ProduitRepository;


import org.springframework.http.ResponseEntity;

@RestController
public class ClientController {

    @Autowired
    ClientRepository clientsRepository;

    @Autowired
    ProduitRepository produitsRepository;

    //test des routes avec un simple string
        @RequestMapping(value="/Client", method=RequestMethod.GET)
        public String listeBug() {
            return "Un exemple de client";
        }
    
    
    @GetMapping("client/{id}")
    public Optional<Client> getClients(@PathVariable("id") Integer id) {
    	
    	Optional<Client> clients = clientsRepository.findById(id);
    	if(clients==null) throw new ClientIntrouvableException("Le bug avec l'id " + id + " est inexistant.");
    	

        return clients;
    }
    
    @GetMapping("client")
    public List<Client> getAllClients() {
    	return clientsRepository.findAll();
    }
   
    @PostMapping("client")
    public Client createClient(@Validated @RequestBody CreateClient client){
        return clientsRepository.save(
                Client
                .builder()
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .solde(client.getSolde())
                .actif(client.isActif())
                .build()
        );
    }


    @DeleteMapping("client/{id}")
    public void deleteClient(@PathVariable Integer id){
   	clientsRepository.deleteById(id);

   }
    
    
    @GetMapping("client/nom")
    public List<Client> getClientByName(@RequestParam("nom") String nom) {
    	return clientsRepository.findClientByName(nom);
    }

   

    @GetMapping("client/prenom")
    public List<Client> getClientByFirstName(@RequestParam("prenom") String prenom) {
    	return clientsRepository.findClientByFirstName(prenom);
    }



}