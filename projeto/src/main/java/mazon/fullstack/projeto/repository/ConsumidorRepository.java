package mazon.fullstack.projeto.repository;

import mazon.fullstack.projeto.model.Consumidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumidorRepository extends JpaRepository <Consumidor, Long> {
}
