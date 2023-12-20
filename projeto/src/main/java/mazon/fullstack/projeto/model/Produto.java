package mazon.fullstack.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Produto extends EntityId{

    @Column(name = "nome_produto", nullable = false)
    private String nome;

    @Column(name = "descricao",nullable = false)
    private String descricao;


    @Column(name = "preco",nullable = false)
    private String preco;

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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
