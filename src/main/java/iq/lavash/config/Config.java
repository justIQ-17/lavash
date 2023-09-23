package iq.lavash.config;
import iq.lavash.entity.Ingredient;
import iq.lavash.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class    Config implements WebMvcConfigurer {

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientRepository) {
        return args -> {
            ingredientRepository.save(new Ingredient("TXM", "Tandir Hamir", Ingredient.Type.DOUGH));
            ingredientRepository.save(new Ingredient("LXM", "Lavash Hamir", Ingredient.Type.DOUGH));
            ingredientRepository.save(new Ingredient("CBF", "Cow Beef", Ingredient.Type.MEAT));
            ingredientRepository.save(new Ingredient("CKN", "Chicken", Ingredient.Type.MEAT));
            ingredientRepository.save(new Ingredient("TMT", "Tomatoes", Ingredient.Type.VEGETABLES));
            ingredientRepository.save(new Ingredient("CCB", "Cucumber", Ingredient.Type.VEGETABLES));
            ingredientRepository.save(new Ingredient("CDR", "Cheddar", Ingredient.Type.CHEESE));
            ingredientRepository.save(new Ingredient("MZL", "Mozzarella", Ingredient.Type.CHEESE));
            ingredientRepository.save(new Ingredient("SNS", "Sweet Sour", Ingredient.Type.SAUCE));
            ingredientRepository.save(new Ingredient("KTP", "Ketchup", Ingredient.Type.SAUCE));
        };

    }
}
