package mazon.fullstack.projeto.resources;

import mazon.fullstack.projeto.model.Consumidor;
import mazon.fullstack.projeto.service.ConsumidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consumidor")
public class ConsumidorController extends AbstractController{
    @Autowired
    private ConsumidorService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Consumidor entity) {
        Consumidor save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/consumidor" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<Consumidor> consumidor = service.buscaTodos();
        return ResponseEntity.ok(consumidor);
    }

    @GetMapping ("{id}")
    public ResponseEntity findById(@PathVariable ("id") Long id) {
        Consumidor consumidor = service.buscaPorId(id);
        return ResponseEntity.ok(consumidor);}

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Consumidor entity) {
        Consumidor alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
