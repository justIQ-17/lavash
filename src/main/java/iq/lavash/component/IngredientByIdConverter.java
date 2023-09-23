package iq.lavash.component;

import iq.lavash.entity.Ingredient;
import iq.lavash.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@RequiredArgsConstructor
@Component
public class IngredientByIdConverter implements Converter<String,Ingredient> {
    private final IngredientRepository ingredientRepository;
    @Override
    public Ingredient convert(String id){
        return ingredientRepository.findById(id).orElse(null);
    }


}
