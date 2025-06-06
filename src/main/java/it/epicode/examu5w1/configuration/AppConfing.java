package it.epicode.examu5w1.configuration;

import it.epicode.examu5w1.entities.Edificio;
import it.epicode.examu5w1.entities.Postazione;
import it.epicode.examu5w1.entities.Utente;
import it.epicode.examu5w1.enums.Tipo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class AppConfing {

@Bean(name = "edificio_a")
    public Edificio getEdificioA(){
    Edificio e = new Edificio();
    e.setCitta("Napoli");
    e.setNome("Edificio A");
    e.setIndirizzo("Via Napoli 24");
   return e;
}
    @Bean(name = "edificio_b")
    public Edificio getEdificioB(){
        Edificio e = new Edificio();
        e.setCitta("Roma");
        e.setNome("Edificio B");
        e.setIndirizzo("Via Roma 11");
        return e;
    }
    @Bean(name = "edificio_c")
    public Edificio getEdificioC(){
        Edificio e = new Edificio();
        e.setCitta("Verona");
        e.setNome("Edificio C");
        e.setIndirizzo("Via Verona 85");
        return e;
    }
    @Bean(name = "postazione_privata_r")
    public Postazione getPostazionePrivataR() {
        Postazione p = new Postazione();
        p.setDescrizione("Postazione privata singola");
        p.setTipo(Tipo.PRIVATO);
        p.setNumeroMassimoOccupanti(1);

        return p;
    }
    @Bean(name = "postazione_privata_v")
    public Postazione getPostazionePrivataV() {
        Postazione p = new Postazione();
        p.setDescrizione("Postazione privata singola");
        p.setTipo(Tipo.PRIVATO);
        p.setNumeroMassimoOccupanti(1);

        return p;
    }
    @Bean(name = "postazione_privata_n")
    public Postazione getPostazionePrivataN() {
        Postazione p = new Postazione();
        p.setDescrizione("Postazione privata singola");
        p.setTipo(Tipo.PRIVATO);
        p.setNumeroMassimoOccupanti(1);

        return p;
    }

    @Bean(name = "postazione_openspace_r")
    public Postazione getPostazioneOpenSpaceR() {
        Postazione p = new Postazione();
        p.setDescrizione("Open Space 4 persone");
        p.setTipo(Tipo.OPENSPACE);
        p.setNumeroMassimoOccupanti(4);

        return p;
    }
    @Bean(name = "postazione_openspace_n")
    public Postazione getPostazioneOpenSpaceN() {
        Postazione p = new Postazione();
        p.setDescrizione("Open Space 4 persone");
        p.setTipo(Tipo.OPENSPACE);
        p.setNumeroMassimoOccupanti(4);

        return p;
    }
    @Bean(name = "postazione_openspace_v")
    public Postazione getPostazioneOpenSpaceV() {
        Postazione p = new Postazione();
        p.setDescrizione("Open Space 4 persone");
        p.setTipo(Tipo.OPENSPACE);
        p.setNumeroMassimoOccupanti(4);

        return p;
    }
    @Bean(name = "postazione_sala_riunioni")
    public Postazione getPostazioneSalaRiunioni() {
        Postazione p = new Postazione();
        p.setDescrizione("sala riunioni 10 persone");
        p.setTipo(Tipo.SALA_RIUNIONI);
        p.setNumeroMassimoOccupanti(10);

        return p;
    }
    @Bean(name = "postazione_sala_riunioni_n")
    public Postazione getPostazioneSalaRiunioniN() {
        Postazione p = new Postazione();
        p.setDescrizione("sala riunioni 10 persone");
        p.setTipo(Tipo.SALA_RIUNIONI);
        p.setNumeroMassimoOccupanti(10);

        return p;
    }


    @Bean(name = "mario")
    public Utente getUtenteMario() {
        Utente u = new Utente();
        u.setUsername("mariobross");
        u.setNome("Mario Rossi");
        u.setEmail("m.rossi@yahoo.it");
        return u;
    }

    @Bean(name = "luca")
    public Utente getUtenteLuca() {
        Utente u = new Utente();
        u.setUsername("lucamarchins");
        u.setNome("Luca Marchini");
        u.setEmail("l.bianchi@gmail.it");
        return u;
    }
    @Bean(name = "gaia")
    public Utente getUtentegaia() {
        Utente u = new Utente();
        u.setUsername("gbianchi");
        u.setNome("Gaia Bianchi");
        u.setEmail("g.bianchi@hotmail.it");
        return u;
    }
}
