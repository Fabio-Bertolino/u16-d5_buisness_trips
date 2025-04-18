package it.epicode.u16_d5_buisness_trips.viaggi;

import it.epicode.u16_d5_buisness_trips.enums.Stato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "viaggi")
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 100)
    private String destinazione;
    @Column(nullable = false, name = "data_partenza")
    private LocalDate dataPartenza;
    @Column(nullable = false)
    private Stato stato;
}
