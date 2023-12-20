package mazon.fullstack.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Produtor extends Usuario{

    @Column(name = "cnpj", nullable = false)
    private String cnpj;
    @Column(name = "razao_social",nullable = false)
    private String razaoSocial;
    @Column(name = "pix",nullable = false)
    private String pix;

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
