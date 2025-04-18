package it.epicode.u16_d5_buisness_trips.dipendenti;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DipendenteRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String nome;
    @NotBlank
    private String cognome;
    @Email
    private String email;
    @NotNull
    private String immagineProfilo;
}
