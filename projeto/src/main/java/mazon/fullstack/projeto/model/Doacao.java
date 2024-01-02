package mazon.fullstack.projeto.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Doacao extends EntityId {

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    @Column(name = "disponibilidade", nullable = false)
    private Boolean disponibilidade;
    @Column(name = "validade", nullable = false)
    private LocalDate validade;


    //Cardinalidade Produtor- Doação
    @ManyToOne
    @JoinColumn (name = "produtor_id", referencedColumnName = "id")
    private Produtor produtorId;

    // Cardinalidade Produto - Doação
    @ManyToMany
    @JoinTable(
            name = "doacao_produto",
            joinColumns = @JoinColumn(name = "doacao_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
                )

    private Set<Produto> produtos;


    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public Produtor getProdutorId() {
        return produtorId;
    }

    public void setProdutorId(Produtor produtorId) {
        this.produtorId = produtorId;
    }

    @Override
    public String toString() {
        return "Doacao{" +
                "quantidade=" + quantidade +
                ", disponibilidade=" + disponibilidade +
                ", validade=" + validade +
                ", produtorId=" + produtorId +
                '}';
    }
}
