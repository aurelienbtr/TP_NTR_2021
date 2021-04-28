package uphf.ntr.repository;
import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import uphf.ntr.model.Client;


public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findById(Integer idClient);
    Client findClientByName(String nom);

}