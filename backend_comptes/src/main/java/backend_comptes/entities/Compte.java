package backend_comptes.entities;



import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "comptes")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal solde;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreation;


    @Enumerated(EnumType.STRING)
    private CompteType type;

    // Constructeurs
    public Compte() {}

    public Compte(Long id, BigDecimal solde, LocalDate dateCreation, CompteType type) {
        this.id = id;
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.type = type;
    }

    // Getters / Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getSolde() { return solde; }
    public void setSolde(BigDecimal solde) { this.solde = solde; }

    public LocalDate getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDate dateCreation) { this.dateCreation = dateCreation; }

    public CompteType getType() { return type; }
    public void setType(CompteType type) { this.type = type; }
}
