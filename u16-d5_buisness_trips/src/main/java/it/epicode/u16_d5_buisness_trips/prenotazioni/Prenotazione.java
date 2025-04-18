package it.epicode.u16_d5_buisness_trips.prenotazioni;

import it.epicode.u16_d5_buisness_trips.dipendenti.Dipendente;
import it.epicode.u16_d5_buisness_trips.viaggi.Viaggio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Viaggio viaggio;
    @ManyToOne
    private Dipendente dipendente;
    @Column(nullable = false, name = "data_richiesta")
    private LocalDate dataRichiesta;
    @Column(nullable = false, length = 250)
    private String note;
}
