package iq.lavash.controller;
import iq.lavash.entity.Ingredient;
import iq.lavash.entity.Ingredient.Type;
import iq.lavash.entity.Lavash;
import iq.lavash.entity.LavashOrder;
import iq.lavash.repository.IngredientRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@Slf4j
@SessionAttributes("lavashOrder")
@RequestMapping("/design")
@RequiredArgsConstructor
public class DesignController {
    private final IngredientRepository ingredientRepository;

    @ModelAttribute
    public void addIngredientsToModel(Model model) {

        List<Ingredient> ingredients = ingredientRepository.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString(), filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "lavashOrder")
    public LavashOrder order() {

        return new LavashOrder();
    }

    @ModelAttribute(name = "lavash")
    public Lavash lavash() {

        return new Lavash();
    }

    @GetMapping
    public String showDesign() {
        return "design";
    }

    // TODO: Learn each of them!!!
    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processLavash(@Valid Lavash lavash, Errors errors,                                                                           //TODO: Bi iwo'ra lavashni barganlamiz uchun user giritgan malumotlani "Lavash lavash"a saqlab duripmi yo balandda yazgan "th:object bn th:field" la uchunmi?
                                @ModelAttribute LavashOrder lavashOrder) {
        if (errors.hasErrors()){
            return "design";
        }
        lavashOrder.addLavash(lavash);
        // TODO: What is it doing?
        log.info("Processing lavash: {}", lavash);
        return "redirect:/orders/current";

    }
}
