package springinaction.tacocloud.DAO;

import springinaction.tacocloud.domain.Ingredient;

import java.util.List;

public interface IngredientRepository {

    List<Ingredient> finfAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);
}
