package it.epicode.u16_d5_buisness_trips.prenotazioni;

import it.epicode.u16_d5_buisness_trips.dipendenti.Dipendente;
import it.epicode.u16_d5_buisness_trips.viaggi.Viaggio;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrenotazioneRequest {
    @NotNull
    private Viaggio viaggio;
    @NotNull
    private Dipendente dipendente;
    @NotNull
    private LocalDate dataRichiesta;
    private String note;
}
