package it.epicode.u16_d5_buisness_trips.viaggi;

import it.epicode.u16_d5_buisness_trips.enums.Stato;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ViaggioResponse {
    private Long id;
    private String destinazione;
    private LocalDate dataPartenza;
    private Stato stato;
}
