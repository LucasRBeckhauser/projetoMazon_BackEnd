package mazon.fullstack.projeto.repository;

import mazon.fullstack.projeto.model.Produtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutorRepository extends JpaRepository <Produtor, Long> {

}
