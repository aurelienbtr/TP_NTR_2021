package uphf.ntr.BanqueNTR.services;
import java.util.Collection;
import java.util.Optional;
import uphf.ntr.BanqueNTR.model.Utilisateur;

import uphf.ntr.BanqueNTR.repository.UtilisateurRepository;

public interface UtilisateurService {

	Collection<Utilisateur> getAllUtilisateurs();
	
	Optional<Utilisateur> getUtilisateurById(Long id);
	
	Optional<Utilisateur> findByLogin(String login);
	
	Utilisateur saveOrUpdateUtilisateur(Utilisateur user);
	
	void deleteUser(int id);

	Optional<Utilisateur> findByLoginAndPassword(String login, String password);

}