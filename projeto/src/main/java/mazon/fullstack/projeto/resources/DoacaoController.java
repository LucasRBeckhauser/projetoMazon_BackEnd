package mazon.fullstack.projeto.resources;

import jakarta.persistence.Entity;
import mazon.fullstack.projeto.model.Consumidor;
import mazon.fullstack.projeto.model.Doacao;
import mazon.fullstack.projeto.service.ConsumidorService;
import mazon.fullstack.projeto.service.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/doacao")
public class DoacaoController extends AbstractController{

    @Autowired
    private DoacaoService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Doacao entity) {
        Doacao save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/doacao" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<Doacao> doacao = service.buscaTodos();
        return ResponseEntity.ok(doacao);
    }

    @GetMapping ("{id}")
    public ResponseEntity findById(@PathVariable ("id") Long id) {
        Doacao doacao = service.buscaPorId(id);
        return ResponseEntity.ok(doacao);}

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Doacao entity) {
        Doacao alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
