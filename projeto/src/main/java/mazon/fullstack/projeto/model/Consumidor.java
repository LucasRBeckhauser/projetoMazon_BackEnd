package mazon.fullstack.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Consumidor extends Usuario{
    @Column(name = "nome",nullable = false)
    private String nome;

    //Usar RegExr na validação do Cartão de Crédito.
    @Column(name = "cartao_credito",nullable = false)
    private String cartaoCredito;

}
