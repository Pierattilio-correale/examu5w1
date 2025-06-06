package it.epicode.examu5w1.entities;

import it.epicode.examu5w1.enums.Tipo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codiceUnivoco;
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(name = "numero_massimo_occupanti")
    private int numeroMassimoOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;

}
