package it.epicode.u16_d5_buisness_trips.common;

import com.github.javafaker.Faker;
import it.epicode.u16_d5_buisness_trips.dipendenti.Dipendente;
import it.epicode.u16_d5_buisness_trips.dipendenti.DipendenteRepository;
import it.epicode.u16_d5_buisness_trips.enums.Stato;
import it.epicode.u16_d5_buisness_trips.viaggi.Viaggio;
import it.epicode.u16_d5_buisness_trips.viaggi.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CommonRunner implements CommandLineRunner {
    @Autowired
    private ViaggioRepository viaggioRepository;
    @Autowired
    private DipendenteRepository dipendenteRepository;
    @Autowired
    private Faker faker;


    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 10; i++) {
            Dipendente dipendente = new Dipendente();
            dipendente.setUsername(faker.name().username());
            dipendente.setNome(faker.name().firstName());
            dipendente.setCognome(faker.name().lastName());
            dipendente.setEmail(faker.internet().emailAddress());
            dipendenteRepository.save(dipendente);

            Viaggio viaggio = new Viaggio();
            viaggio.setDestinazione(faker.address().city());
            viaggio.setDataPartenza(LocalDate.of(faker.number().numberBetween(2025, 2026), faker.number().numberBetween(1, 12), faker.number().numberBetween(1, 28)));
            viaggio.setStato(Stato.valueOf(faker.options().option("IN_PROGRAMMA", "COMPLETATO")));
            viaggioRepository.save(viaggio);
        }
    }
}
