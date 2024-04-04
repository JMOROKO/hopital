package ma.enset.hopital.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder @Data
public class Patient {
    // @TODO comment faire pour mettre personnaliser le formulaire d'authentification ?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Veuillez renseigner le nom s'il vous plait")
    @Size(min=3, max=40, message = "Le nombre de caractère du nom doit être compris entre 4 et 40")
    private String nom;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd") //specification du format de la date à récupérer
    private Date dateNaissance;
    private boolean malade;
    @DecimalMin("100")
    private int score;
}
