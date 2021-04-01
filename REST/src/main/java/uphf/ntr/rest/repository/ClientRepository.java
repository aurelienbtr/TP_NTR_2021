package uphf.ntr.rest.repository;
import uphf.ntr.rest.Client;


import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findById(Integer idClient);
    
    @Query("SELECT b FROM Bug b WHERE b.datecreation BETWEEN ?1 AND  ?2")
    List<Client> findClientByName(String nom);
    
    @Query("SELECT b FROM Bug b WHERE b.datecreation BETWEEN ?1 AND  ?2")
    List<Client> findClientByFirstName(String prenom);

}