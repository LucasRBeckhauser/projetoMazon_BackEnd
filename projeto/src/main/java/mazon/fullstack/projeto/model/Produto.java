package mazon.fullstack.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Produto extends EntityId{

    @Column(name = "nome_produto", nullable = false)
    private String nome;

    @Column(name = "descricao",nullable = false)
    private String descricao;

    @Column(name = "preco",nullable = false)
    private BigDecimal preco;

    @ManyToMany(mappedBy = "produtos")
    private Set<Doacao> doacoes;


    public Set<Doacao> getDoacoes() {
        return doacoes;
    }

    public void setDoacoes(Set<Doacao> doacoes) {
        this.doacoes = doacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
