package springinaction.tacocloud.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springinaction.tacocloud.DAO.IngredientRepository;
import springinaction.tacocloud.TacoCloudApplication;
import springinaction.tacocloud.config.PostgreSqlContainerConfig;
import springinaction.tacocloud.domain.Ingredient;

@SpringBootTest(classes = {TacoCloudApplication.class,
        PostgreSqlContainerConfig.class})
public class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Test
    public void ingredientRepositoryTest(){
        Iterable<Ingredient> all = ingredientRepository.findAll();
        Assertions.assertNotNull(all);
    }
}
