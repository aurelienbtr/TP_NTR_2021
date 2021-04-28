package uphf.ntr.BanqueNTR.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import uphf.ntr.BanqueNTR.model.Utilisateur;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	Optional<Utilisateur> findByEmail(String emailPara);
	

 }