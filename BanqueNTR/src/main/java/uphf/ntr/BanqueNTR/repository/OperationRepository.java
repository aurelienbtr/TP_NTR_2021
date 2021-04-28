package uphf.ntr.BanqueNTR.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import uphf.ntr.BanqueNTR.model.Operation;

public interface OperationRepository extends JpaRepository<Operation, Integer>  {

	Operation findByType(int type);
	Operation findById(int id);
}
