package it.epicode.examu5w1.repositories;

import it.epicode.examu5w1.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente,Integer> {
    Optional<Utente> findByUsername(String username);
}
