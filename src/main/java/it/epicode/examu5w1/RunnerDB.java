package it.epicode.examu5w1;

import it.epicode.examu5w1.entities.Postazione;
import it.epicode.examu5w1.entities.Prenotazione;
import it.epicode.examu5w1.entities.Utente;
import it.epicode.examu5w1.enums.Tipo;
import it.epicode.examu5w1.repositories.PostazioneRepository;
import it.epicode.examu5w1.repositories.PrenotazioneRepository;
import it.epicode.examu5w1.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class RunnerDB implements CommandLineRunner {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- MENU GESTIONE PRENOTAZIONI ---");
            System.out.println("1. Cerca postazioni disponibili");
            System.out.println("2. Effettua prenotazione");
            System.out.println("3. Visualizza prenotazioni utente");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");

            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1" -> cercaPostazioni(scanner);
                case "2" -> effettuaPrenotazione(scanner);
                case "3" -> visualizzaPrenotazioniUtente(scanner);
                case "0" -> {
                    System.out.println("Uscita dal programma.");
                    running = false;
                }
                default -> System.out.println("Opzione non valida. Riprova.");
            }
        }


    }

    private void cercaPostazioni(Scanner scanner) {
        System.out.print("Tipo (PRIVATO, OPENSPACE, SALA_RIUNIONI): ");
        Tipo tipo = Tipo.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Città: ");
        String citta = scanner.nextLine();

        List<Postazione> results = postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
        if (results.isEmpty()) {
            System.out.println("Nessuna postazione trovata.");
        } else {
            results.forEach(p -> System.out.println("ID: " + p.getCodiceUnivoco() + " - " + p.getDescrizione()));
        }

    }

    private void effettuaPrenotazione(Scanner scanner) {
        System.out.print("Username dell'utente: ");
        String username = scanner.nextLine();
        Optional<Utente> utenteOpt = utenteRepository.findByUsername(username);

        if (utenteOpt.isEmpty()) {
            System.out.println("Utente non trovato.");
            return;
        }

        Utente utente = utenteOpt.get();

        System.out.print("ID della postazione da prenotare: ");
        int postazioneId = Integer.parseInt(scanner.nextLine());
        Optional<Postazione> postazioneOpt = postazioneRepository.findById(postazioneId);

        if (postazioneOpt.isEmpty()) {
            System.out.println("Postazione non trovata.");
            return;
        }

        Postazione postazione = postazioneOpt.get();

        System.out.print("Data prenotazione (yyyy-MM-dd): ");
        LocalDate dataPrenotazione = LocalDate.parse(scanner.nextLine());


        boolean postazioneOccupata = prenotazioneRepository.existsByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);
        if (postazioneOccupata) {
            System.out.println("Postazione già prenotata per questa data.");
            return;
        }


        boolean utenteHaPrenotazione = prenotazioneRepository.existsByUtenteAndDataPrenotazione(utente, dataPrenotazione);
        if (utenteHaPrenotazione) {
            System.out.println("L’utente ha già una prenotazione per questa data.");
            return;
        }


        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);
        prenotazione.setDataPrenotazione(dataPrenotazione);

        prenotazioneRepository.save(prenotazione);
        System.out.println("Prenotazione registrata con successo!");
    }

    private void visualizzaPrenotazioniUtente(Scanner scanner) {
        System.out.print("Inserisci lo username dell'utente: ");
        String username = scanner.nextLine();

        Optional<Utente> utenteOpt = utenteRepository.findByUsername(username);

        if (utenteOpt.isEmpty()) {
            System.out.println("Utente non trovato.");
            return;
        }

        Utente utente = utenteOpt.get();
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByUtente(utente);

        if (prenotazioni.isEmpty()) {
            System.out.println("Nessuna prenotazione trovata per questo utente.");
            return;
        }

        System.out.println("--- Prenotazioni di " + utente.getNome() + " ---");
        for (Prenotazione p : prenotazioni) {
            System.out.println("Data: " + p.getDataPrenotazione() +
                    " | Postazione: " + p.getPostazione().getDescrizione() +
                    " (" + p.getPostazione().getTipo() + ") " +
                    "| Edificio: " + p.getPostazione().getEdificio().getNome() +
                    " - " + p.getPostazione().getEdificio().getCitta());
        }
    }
}


