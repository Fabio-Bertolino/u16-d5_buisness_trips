package it.epicode.u16_d5_buisness_trips.viaggi;

import it.epicode.u16_d5_buisness_trips.dipendenti.Dipendente;
import it.epicode.u16_d5_buisness_trips.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaggioService {
    @Autowired
    private ViaggioRepository viaggioRepository;

    public Viaggio findById(Long id) {
        return viaggioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));
    }

    public Viaggio save(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    public void delete(Long id) {
        Viaggio found = this.findById(id);
        viaggioRepository.delete(found);
    }

    public Viaggio update(Long id, Viaggio viaggio) {
        Viaggio found = this.findById(id);
        found.setDestinazione(viaggio.getDestinazione());
        found.setDataPartenza(viaggio.getDataPartenza());
        found.setStato(viaggio.getStato());
        return viaggioRepository.save(found);
    }
}
