package backend_comptes.repositories;


import backend_comptes.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    // méthodes personnalisées si besoin
}