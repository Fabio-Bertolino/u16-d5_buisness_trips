package it.epicode.u16_d5_buisness_trips.viaggi;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import it.epicode.u16_d5_buisness_trips.dipendenti.Dipendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {
    @Autowired()
    private ViaggioService viaggioService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggio createViaggio(@RequestBody Viaggio viaggio) throws Exception {
        return viaggioService.save(viaggio);
    }

    @GetMapping("/{viaggioId}")
    public Viaggio findById(@PathVariable Long viaggioId) {
        return viaggioService.findById(viaggioId);
    }

    @PutMapping("/{viaggioId}")
    public Viaggio updateViaggioById(@PathVariable Long viaggioId, @RequestBody Viaggio viaggio) {
        return viaggioService.update(viaggioId, viaggio);
    }
    @DeleteMapping("/{viaggioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteViaggioById(@PathVariable Long viaggioId) {
        viaggioService.delete(viaggioId);
    }
}
