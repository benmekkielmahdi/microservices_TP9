package backend_comptes.services;


import backend_comptes.entities.Compte;
import backend_comptes.repositories.CompteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteService {

    private final CompteRepository repo;

    public CompteService(CompteRepository repo) {
        this.repo = repo;
    }

    public List<Compte> findAll() {
        return repo.findAll();
    }

    public Optional<Compte> findById(Long id) {
        return repo.findById(id);
    }

    public Compte save(Compte compte) {
        return repo.save(compte);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
