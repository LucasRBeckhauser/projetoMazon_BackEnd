package mazon.fullstack.projeto.service;

import mazon.fullstack.projeto.model.Consumidor;
import mazon.fullstack.projeto.model.Doacao;
import mazon.fullstack.projeto.repository.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoacaoService {


        @Autowired
        private DoacaoRepository repository;

        public Doacao salvar(Doacao entity) {

        //Aqui vão as regras de negócio.

            return  repository.save(entity);
        }

        public List<Doacao> buscaTodos() { return  repository.findAll();}

        public Doacao buscaPorId(Long id) {
            return repository.findById(id).orElse(null);
        }

        public Doacao alterar(Long id, Doacao alterado) {
            Optional<Doacao> encontrado = repository.findById(id);
            if(encontrado.isPresent()) {
                Doacao doacao = encontrado.get();
                doacao.setDisponibilidade(alterado.getDisponibilidade());
                doacao.setProdutos(alterado.getProdutos());
                doacao.setProdutorId(alterado.getProdutorId());
                doacao.setQuantidade(alterado.getQuantidade());
                doacao.setValidade(alterado.getValidade());
                return repository.save(doacao);
            }
            return null;}

        public void remover(Long id) { repository.deleteById(id);}


    }


