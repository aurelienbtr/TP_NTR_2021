package uphf.ntr.controller;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uphf.ntr.model.Produit;
import uphf.ntr.repository.ClientRepository;
import uphf.ntr.repository.ProduitRepository;


@RestController

public class ProduitController {

    @Autowired
    ProduitRepository produitsRepository;

    @Autowired
    ClientRepository clientsRepository;

    @GetMapping("/produit/{nom}")
    public Produit getProduitByName(@PathVariable("nom") String nom) {
        return produitsRepository.findByName(nom);
    }
 
    @GetMapping("/produits")
    public List<Produit> getAllProduit() {
    	return produitsRepository.findAll();
    }
    
    @GetMapping("/produit/{categorie}")
    public Produit getProduitByCategorie(@PathVariable("categorie") String categorie) {
        return produitsRepository.findByCategorie(categorie);
    }
 
    
    

    @RequestMapping(value = "/developpeur", method =  RequestMethod.POST)
    public Produit AddProduit(@Validated @RequestBody Produit prod){
    	
        return produitsRepository.save(
                Produit
                .builder()
                .nom(prod.getNom())
                .prix(prod.getPrix())
                .categorie(prod.getCategorie())
                .owner(prod.getOwner())
                .build()
        );
    }
    
   

    @DeleteMapping("/developpeur/{id}")
    public void deleteDeveloppeur(@PathVariable("id") Integer id) {
        
    	if(produitsRepository.existsById(id))
    		{
    		produitsRepository.deleteById(id);
    		}
    
    }
}