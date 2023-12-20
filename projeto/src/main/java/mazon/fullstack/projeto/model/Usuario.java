package mazon.fullstack.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Usuario extends EntityId {
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cnpj",nullable = false)
    private String cnpj;
    @Column(name = "endereco",nullable = false)
    private String endereco;
    @Column(name = "telefone",nullable = false)
    private String telefone;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "tipo_usuario", nullable = false)
    private String tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
