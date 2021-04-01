package uphf.ntr.rest.repository;
import uphf.ntr.rest.Produit;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;


public interface ProduitRepository {

	 Optional<Produit> findById(Integer idProduit);
	    
	    @Query("SELECT b FROM Bug b WHERE b.datecreation BETWEEN ?1 AND  ?2")
	    List<Produit> findByName(String nom);
	    
	    @Query("SELECT b FROM Bug b WHERE b.titre LIKE %?1%")
	    List<Produit> findBugByCategorie(String categorie);

	}

