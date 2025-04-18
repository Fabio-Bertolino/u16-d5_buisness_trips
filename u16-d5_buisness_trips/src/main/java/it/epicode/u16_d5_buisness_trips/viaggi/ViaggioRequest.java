package it.epicode.u16_d5_buisness_trips.viaggi;

import it.epicode.u16_d5_buisness_trips.enums.Stato;
import jakarta.persistence.Column;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ViaggioRequest {
    @NotBlank
    private String destinazione;
    @FutureOrPresent
    private LocalDate dataPartenza;
    @NotNull
    private Stato stato;
}
