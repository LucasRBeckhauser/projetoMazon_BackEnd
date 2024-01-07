package mazon.fullstack.projeto.resources;

import mazon.fullstack.projeto.model.Doacao;
import mazon.fullstack.projeto.model.Produto;
import mazon.fullstack.projeto.service.DoacaoService;
import mazon.fullstack.projeto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController extends AbstractController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Produto entity) {
        Produto save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/produto" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<Produto> produto = service.buscaTodos();
        return ResponseEntity.ok(produto);
    }

    @GetMapping ("{id}")
    public ResponseEntity findById(@PathVariable ("id") Long id) {
        Produto produto = service.buscaPorId(id);
        return ResponseEntity.ok(produto);}

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Produto entity) {
        Produto alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
    
}
