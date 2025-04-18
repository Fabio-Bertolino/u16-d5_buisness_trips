package it.epicode.u16_d5_buisness_trips.dipendenti;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DipendenteResponse {
    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String immagineProfilo;
}
