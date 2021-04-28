package uphf.ntr.repository;

import uphf.ntr.model.Produit;
import uphf.ntr.model.Client;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProduitRepository extends CrudRepository<Produit, Integer> {

    List<Produit> findAllByOwnerNot(Client client);

    List<Produit> findAllByOwner(Client client);

    List<Produit> findAll();
    Produit findById(int id);
	Produit findByName(String nom);
	Produit findByCategorie (String categorie);
}
