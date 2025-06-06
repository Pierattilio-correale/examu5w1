package it.epicode.examu5w1.repositories;

import it.epicode.examu5w1.entities.Postazione;
import it.epicode.examu5w1.enums.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {
    List<Postazione>findByTipoAndEdificio_Citta(Tipo tipo ,String citta);
}
