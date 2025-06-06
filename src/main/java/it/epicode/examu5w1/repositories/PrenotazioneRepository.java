package it.epicode.examu5w1.repositories;

import it.epicode.examu5w1.entities.Postazione;
import it.epicode.examu5w1.entities.Prenotazione;
import it.epicode.examu5w1.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione ,Integer> {
    boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);

    boolean existsByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);

    List<Prenotazione> findByUtente(Utente utente);
}
