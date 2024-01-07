package mazon.fullstack.projeto.service;

import mazon.fullstack.projeto.model.Produto;
import mazon.fullstack.projeto.model.Produtor;
import mazon.fullstack.projeto.repository.ProdutoRepository;
import mazon.fullstack.projeto.repository.ProdutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutorService {

    @Autowired
    private ProdutorRepository repository;

    public Produtor salvar(Produtor entity) {

        //regras de negócio ficam aqui

        return  repository.save(entity);
    }

    public List<Produtor> buscaTodos() { return  repository.findAll();}

    public Produtor buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Produtor alterar(Long id, Produtor alterado) {
        Optional<Produtor> encontrado = repository.findById(id);
        if(encontrado.isPresent()) {
            Produtor produtor = encontrado.get();
            produtor.setCnpj(alterado.getCnpj());
            produtor.setDoacoes(alterado.getDoacoes());
            produtor.setPix(alterado.getPix());
            produtor.setRazaoSocial(alterado.getRazaoSocial());
            produtor.setTelefone(alterado.getTelefone());
            produtor.setEndereco(alterado.getEndereco());
            produtor.setEmail(alterado.getEmail());


            return repository.save(produtor);
        }
        return null;}

    public void remover(Long id) { repository.deleteById(id);}

}
