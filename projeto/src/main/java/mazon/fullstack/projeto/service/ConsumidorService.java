package mazon.fullstack.projeto.service;

import mazon.fullstack.projeto.model.Consumidor;
import mazon.fullstack.projeto.repository.ConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumidorService {

    @Autowired
    private ConsumidorRepository repository;

    public Consumidor salvar(Consumidor entity) {

//        if(repository.findByCnpj(entity.getCnpj()) != null) {
//            throw new ValidationException("Este CNPJ já está cadastrado no sistema.");
//        }
//
//        if (repository.findByRazaoSocial(entity.getRazaoSocial()) != null) {
//            throw new ValidationException("Já existe esta razão social cadastrada no sistema. ");
//        }

        return  repository.save(entity);
    }

    public List<Consumidor> buscaTodos() { return  repository.findAll();}

    public Consumidor buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Consumidor alterar(Long id, Consumidor alterado) {
        Optional<Consumidor> encontrado = repository.findById(id);
        if(encontrado.isPresent()) {
            Consumidor consumidor = encontrado.get();
            consumidor.setEmail(alterado.getEmail());
            consumidor.setEndereco(alterado.getEndereco());
            consumidor.setTelefone(alterado.getTelefone());
            consumidor.setCartaoCredito(alterado.getCartaoCredito());
            consumidor.setNome(alterado.getNome());
            return repository.save(consumidor);
        }
        return null;}

    public void remover(Long id) { repository.deleteById(id);}


}
