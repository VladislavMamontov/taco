package springinaction.tacocloud.DAO;

import org.springframework.data.repository.CrudRepository;
import springinaction.tacocloud.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
