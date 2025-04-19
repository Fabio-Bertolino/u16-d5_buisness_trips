package it.epicode.u16_d5_buisness_trips.prenotazioni;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {
    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione createPrenotazione(@RequestBody Prenotazione prenotazione) throws Exception {
        return prenotazioneService.save(prenotazione);
    }
    @GetMapping("")
    public Page<Prenotazione> getPrenotazioni(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size,
                                          @RequestParam(defaultValue = "id") String sortBy) {
        return prenotazioneService.getPrenotazioni(page, size, sortBy);
    }
    @GetMapping("/{prenotazioneId}")
    public Prenotazione findById(@PathVariable Long prenotazioneId) {
        return prenotazioneService.findById(prenotazioneId);
    }
    @PutMapping("/{prenotazioneId}")
    public Prenotazione updatePrenotazioneById(@PathVariable Long prenotazioneId, @RequestBody Prenotazione prenotazione) {
        return prenotazioneService.update(prenotazioneId, prenotazione);
    }
}
