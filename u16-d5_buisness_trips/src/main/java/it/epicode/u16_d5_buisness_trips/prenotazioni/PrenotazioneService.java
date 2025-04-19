package it.epicode.u16_d5_buisness_trips.prenotazioni;

import it.epicode.u16_d5_buisness_trips.dipendenti.Dipendente;
import it.epicode.u16_d5_buisness_trips.dipendenti.DipendenteRepository;
import it.epicode.u16_d5_buisness_trips.enums.Stato;
import it.epicode.u16_d5_buisness_trips.exceptions.NotFoundException;
import it.epicode.u16_d5_buisness_trips.viaggi.Viaggio;
import it.epicode.u16_d5_buisness_trips.viaggi.ViaggioRepository;
import it.epicode.u16_d5_buisness_trips.viaggi.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Service
@Validated
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    DipendenteRepository dipendenteRepository;
    @Autowired
    ViaggioService viaggioService;
    @Autowired
    ViaggioRepository viaggioRepository;

    public Prenotazione richiestaPrenotazione(Dipendente dipendente, Viaggio viaggio, String note) {
        Prenotazione prenotazione = new Prenotazione();
        Long dipendenteId = dipendenteRepository.findById(dipendente.getId()).orElseThrow(() -> new NotFoundException("Dipendente non trovato")).getId();
        Stato statoViaggio = viaggio.getStato();

            if (statoViaggio.equals(Stato.IN_PROGRAMMA)) {
                if (viaggioRepository.findByStatoAndDipendente(statoViaggio, dipendente).isEmpty()) {
                    prenotazione.setDipendente(dipendenteRepository.findById(dipendenteId).orElseThrow(() -> new NotFoundException("Dipendente non trovato")));
                    prenotazione.setViaggio(viaggioService.findById(viaggio.getId()));
                    prenotazione.setDataRichiesta(LocalDate.now());
                    prenotazione.setNote(note);
                    viaggio.setDipendente(dipendente);
                    viaggioRepository.save(prenotazione.getViaggio());
                    return prenotazioneRepository.save(prenotazione);
                } else {
                    Throwable throwable = new Throwable("Dipendente già prenotato per questo viaggio");
                    throw new RuntimeException(throwable);
                }
            } else {
                Throwable throwable = new Throwable("Viaggio già completato");
                throw new RuntimeException(throwable);
            }
    }

    public Prenotazione save(Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    public Page<Prenotazione> getPrenotazioni(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return prenotazioneRepository.findAll(pageable);
    }

    public Prenotazione findById(Long id) {
        return prenotazioneRepository.findById(id).orElseThrow(() -> new NotFoundException(String.valueOf(id)));
    }

    public void delete(Long id) {
        Prenotazione found = this.findById(id);
        prenotazioneRepository.delete(found);
    }

    public Prenotazione update(Long id, Prenotazione prenotazione) {
        Prenotazione found = this.findById(id);
        found.setDataRichiesta(prenotazione.getDataRichiesta());
        found.setNote(prenotazione.getNote());
        return prenotazioneRepository.save(found);
    }


}
