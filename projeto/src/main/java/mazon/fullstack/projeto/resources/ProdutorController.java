package mazon.fullstack.projeto.resources;

import mazon.fullstack.projeto.model.Produto;
import mazon.fullstack.projeto.model.Produtor;
import mazon.fullstack.projeto.service.ProdutoService;
import mazon.fullstack.projeto.service.ProdutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtor")
public class ProdutorController {
    @Autowired
    private ProdutorService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Produtor entity) {
        Produtor save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/produtor" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<Produtor> produtor = service.buscaTodos();
        return ResponseEntity.ok(produtor);
    }

    @GetMapping ("{id}")
    public ResponseEntity findById(@PathVariable ("id") Long id) {
        Produtor produtor = service.buscaPorId(id);
        return ResponseEntity.ok(produtor);}

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Produtor entity) {
        Produtor alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
