package mazon.fullstack.projeto.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "produtor")
public class Produtor extends Usuario{

    @Column(name = "cnpj", nullable = false)
    private String cnpj;
    @Column(name = "razao_social",nullable = false)
    private String razaoSocial;
    @Column(name = "pix",nullable = false)
    private String pix;

    @OneToMany(mappedBy = "produtorId", cascade = CascadeType.ALL)
    private List<Doacao> doacoes;

    public List<Doacao> getDoacoes() {
        return doacoes;
    }

    public void setDoacoes(List<Doacao> doacoes) {
        this.doacoes = doacoes;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }
}
