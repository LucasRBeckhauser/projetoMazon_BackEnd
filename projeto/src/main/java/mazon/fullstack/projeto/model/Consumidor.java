package mazon.fullstack.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "consumidor")
public class Consumidor extends Usuario{
    @Column(name = "nome",nullable = false)
    private String nome;

    //Usar RegExr na validação do Cartão de Crédito.
    @Column(name = "cartao_credito",nullable = false)
    private String cartaoCredito;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }
}
