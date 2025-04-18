package it.epicode.u16_d5_buisness_trips.dipendenti;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {
    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente createDipendente(@RequestBody Dipendente dipendente) throws Exception {
        return dipendenteService.save(dipendente);
    }

    @PatchMapping(path = "{id}/immagine-profilo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadImmagineProfilo(@PathVariable Long id, @RequestPart MultipartFile file) {
        dipendenteService.uploadProfilePicture(id, file);
    }

    @GetMapping("")
    public Page<Dipendente> getDipendenti(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size,
                                          @RequestParam(defaultValue = "id") String sortBy) {
        return dipendenteService.getDipendenti(page, size, sortBy);
    }
    @GetMapping("/{dipendenteId}")
    public Dipendente findById(@PathVariable Long dipendenteId) {
        return dipendenteService.findById(dipendenteId);
    }
    @PutMapping("/{dipendenteId}")
    public Dipendente updateDipendenteById(@PathVariable Long dipendenteId, @RequestBody Dipendente dipendente) {
        return dipendenteService.update(dipendenteId, dipendente);
    }
    @DeleteMapping("/{dipendenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDipendenteById(@PathVariable Long dipendenteId) {
        dipendenteService.delete(dipendenteId);
    }
}
