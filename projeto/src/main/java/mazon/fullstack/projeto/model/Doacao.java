package mazon.fullstack.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Doacao extends EntityId {

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    @Column(name = "disponibilidade", nullable = false)
    private Boolean disponibilidade;
    @Column(name = "validade", nullable = false)
    private LocalDate validade;


}
