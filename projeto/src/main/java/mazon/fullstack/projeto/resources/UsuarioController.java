package mazon.fullstack.projeto.resources;

import mazon.fullstack.projeto.model.Usuario;
import mazon.fullstack.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Usuario entity) {
        Usuario save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/usuario" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<Usuario> usuario = service.buscaTodos();
        return ResponseEntity.ok(usuario);
    }

    @GetMapping ("{id}")
    public ResponseEntity findById(@PathVariable ("id") Long id) {
        Usuario usuario = service.buscaPorId(id);
        return ResponseEntity.ok(usuario);}

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Usuario entity) {
        Usuario alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
