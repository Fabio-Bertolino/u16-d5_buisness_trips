package it.epicode.u16_d5_buisness_trips.prenotazioni;

import it.epicode.u16_d5_buisness_trips.dipendenti.Dipendente;
import it.epicode.u16_d5_buisness_trips.viaggi.Viaggio;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PrenotazioneResponse {
    private Long id;
    private Viaggio viaggio;
    private Dipendente dipendente;
    private LocalDate dataRichiesta;
    private String note;
}
