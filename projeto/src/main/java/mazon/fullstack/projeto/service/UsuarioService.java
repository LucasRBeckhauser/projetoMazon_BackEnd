package mazon.fullstack.projeto.service;

import mazon.fullstack.projeto.model.Produto;
import mazon.fullstack.projeto.model.Usuario;
import mazon.fullstack.projeto.repository.ProdutoRepository;
import mazon.fullstack.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario salvar(Usuario entity) {

        //regras de negócio ficam aqui

        return  repository.save(entity);
    }

    public List<Usuario> buscaTodos() { return  repository.findAll();}

    public Usuario buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario alterar(Long id, Usuario alterado) {
        Optional<Usuario> encontrado = repository.findById(id);
        if(encontrado.isPresent()) {
            Usuario usuario = encontrado.get();
            usuario.setEmail(alterado.getEmail());
            usuario.setTelefone(alterado.getTelefone());
            usuario.setEndereco(alterado.getEndereco());
            return repository.save(usuario);
        }
        return null;}

    public void remover(Long id) { repository.deleteById(id);}

}
