package de.oxcellerator.recipeproject.converters;

import de.oxcellerator.recipeproject.commands.IngredientCommand;
import de.oxcellerator.recipeproject.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author Olexiy Sokurenko <ol.sakura@gmail.com>
 * Date: 27.03.2020
 */

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureConverter) {
        this.unitOfMeasureConverter = unitOfMeasureConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }

        Ingredient target = new Ingredient();
        target.setId(source.getId());
        target.setAmount(source.getAmount());
        target.setDescription(source.getDescription());
        target.setUom(unitOfMeasureConverter.convert(source.getUom()));

        return target;

    }
}
