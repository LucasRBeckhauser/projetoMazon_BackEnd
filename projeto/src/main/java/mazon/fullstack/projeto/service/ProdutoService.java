package mazon.fullstack.projeto.service;

import mazon.fullstack.projeto.model.Doacao;
import mazon.fullstack.projeto.model.Produto;
import mazon.fullstack.projeto.repository.DoacaoRepository;
import mazon.fullstack.projeto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto entity) {

        //regras de negócio ficam aqui

        return  repository.save(entity);
    }

    public List<Produto> buscaTodos() { return  repository.findAll();}

    public Produto buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Produto alterar(Long id, Produto alterado) {
        Optional<Produto> encontrado = repository.findById(id);
        if(encontrado.isPresent()) {
            Produto produto = encontrado.get();
            produto.setDescricao(alterado.getDescricao());
            produto.setDoacoes(alterado.getDoacoes());
            produto.setNome(alterado.getNome());
            produto.setPreco(alterado.getPreco());
            return repository.save(produto);
        }
        return null;}

    public void remover(Long id) { repository.deleteById(id);}

}
