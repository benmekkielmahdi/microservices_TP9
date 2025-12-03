package backend_comptes.controllers;



import backend_comptes.entities.Compte;
import backend_comptes.services.CompteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/comptes")
@CrossOrigin(origins = "http://localhost:3001") //  React local
public class CompteController {

    private final CompteService service;

    public CompteController(CompteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Compte> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compte> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Compte> create(@RequestBody Compte compte) {
        Compte saved = service.save(compte);
        return ResponseEntity.created(URI.create("/api/comptes/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compte> update(@PathVariable Long id, @RequestBody Compte compte) {
        return service.findById(id)
                .map(existing -> {
                    compte.setId(existing.getId());
                    Compte updated = service.save(compte);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.findById(id)
                .map(existing -> {
                    service.delete(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
