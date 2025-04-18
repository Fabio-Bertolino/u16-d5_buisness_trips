package it.epicode.u16_d5_buisness_trips.dipendenti;

import it.epicode.u16_d5_buisness_trips.cloudinary.CloudinaryService;
import it.epicode.u16_d5_buisness_trips.exceptions.NotFoundException;
import jakarta.mail.Multipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DipendenteService {
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private DipendenteRepository dipendenteRepository;

    public void uploadProfilePicture(Long dipendenteId, MultipartFile file) {
        Dipendente dipendente = dipendenteRepository.findById(dipendenteId)
                .orElseThrow(() -> new NotFoundException(String.valueOf(dipendenteId)));

        String url = cloudinaryService.uploadImage(file);

        dipendente.setImmagineProfilo(url);

        dipendenteRepository.save(dipendente);
    }

    public Page<Dipendente> getDipendenti(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return dipendenteRepository.findAll(pageable);
    }

    public Dipendente findById(Long id) {
        return dipendenteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));
    }

    public Dipendente save(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public void delete(Long id) {
        Dipendente found = this.findById(id);
        dipendenteRepository.delete(found);
    }

    public Dipendente update(Long id, Dipendente dipendente) {
        Dipendente found = this.findById(id);
        found.setUsername(dipendente.getUsername());
        found.setNome(dipendente.getNome());
        found.setCognome(dipendente.getCognome());
        found.setEmail(dipendente.getEmail());
        found.setImmagineProfilo(dipendente.getImmagineProfilo());
        return dipendenteRepository.save(found);
    }
}
