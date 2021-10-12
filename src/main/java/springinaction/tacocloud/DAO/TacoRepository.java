package springinaction.tacocloud.DAO;

import org.springframework.data.repository.CrudRepository;
import springinaction.tacocloud.domain.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
