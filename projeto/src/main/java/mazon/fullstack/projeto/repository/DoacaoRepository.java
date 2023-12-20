package mazon.fullstack.projeto.repository;

import mazon.fullstack.projeto.model.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoacaoRepository extends JpaRepository <Doacao, Long> {

}
