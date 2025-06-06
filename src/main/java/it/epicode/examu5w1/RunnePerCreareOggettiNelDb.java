package it.epicode.examu5w1;

import it.epicode.examu5w1.entities.Edificio;
import it.epicode.examu5w1.entities.Postazione;
import it.epicode.examu5w1.entities.Utente;
import it.epicode.examu5w1.repositories.EdificioRepository;
import it.epicode.examu5w1.repositories.PostazioneRepository;
import it.epicode.examu5w1.repositories.PrenotazioneRepository;
import it.epicode.examu5w1.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component

public class RunnePerCreareOggettiNelDb implements CommandLineRunner {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    @Qualifier("edificio_a")
    private Edificio e1;

    @Autowired
    @Qualifier("edificio_b")
    private Edificio e2;

    @Autowired
    @Qualifier("edificio_c")
    private Edificio e3;

    @Autowired
    @Qualifier("postazione_privata_r")
    private Postazione pos1;
    @Autowired
    @Qualifier("postazione_privata_n")
    private Postazione pos1n;
    @Autowired
    @Qualifier("postazione_privata_v")
    private Postazione pos1v;

    @Autowired
    @Qualifier("postazione_openspace_r")
    private Postazione pos2;
    @Autowired
    @Qualifier("postazione_openspace_v")
    private Postazione pos2v;
    @Autowired
    @Qualifier("postazione_openspace_n")
    private Postazione pos2n;


    @Autowired
    @Qualifier("postazione_sala_riunioni")
    private Postazione pos3;
    @Autowired
    @Qualifier("postazione_sala_riunioni_n")
    private Postazione pos3n;

    @Autowired
    @Qualifier("mario")
    private Utente u1;

    @Autowired
    @Qualifier("luca")
    private Utente u2;

    @Autowired
    @Qualifier("gaia")
    private Utente u3;


    @Override
    public void run(String... args) throws Exception {

        edificioRepository.save(e1);
        edificioRepository.save(e2);
        edificioRepository.save(e3);

        pos1.setEdificio(e1);
        pos1v.setEdificio(e2);
        pos1n.setEdificio(e3);


        pos2.setEdificio(e2);
        pos2n.setEdificio(e1);
        pos2v.setEdificio(e3);


        pos3.setEdificio(e3);
        pos3n.setEdificio(e2);


        postazioneRepository.save(pos1);
        postazioneRepository.save(pos1v);
        postazioneRepository.save(pos1n);
        postazioneRepository.save(pos2n);
        postazioneRepository.save(pos2v);
        postazioneRepository.save(pos2);
        postazioneRepository.save(pos3);
        postazioneRepository.save(pos3n);

        utenteRepository.save(u1);
        utenteRepository.save(u2);
        utenteRepository.save(u3);

        System.out.println("Dati iniziali salvati con successo nel database!!.");

    }
}
