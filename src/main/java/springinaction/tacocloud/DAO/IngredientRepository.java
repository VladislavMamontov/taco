package springinaction.tacocloud.DAO;

import org.springframework.data.repository.CrudRepository;
import springinaction.tacocloud.domain.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
