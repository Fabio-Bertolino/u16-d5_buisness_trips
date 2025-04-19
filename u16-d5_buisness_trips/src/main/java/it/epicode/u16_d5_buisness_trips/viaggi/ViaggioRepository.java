package it.epicode.u16_d5_buisness_trips.viaggi;

import it.epicode.u16_d5_buisness_trips.dipendenti.Dipendente;
import it.epicode.u16_d5_buisness_trips.enums.Stato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
    List<Viaggio> findByStatoAndDipendente(Stato stato, Dipendente dipendente);
}
