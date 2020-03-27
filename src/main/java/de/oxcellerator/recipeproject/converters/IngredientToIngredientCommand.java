package de.oxcellerator.recipeproject.converters;

import de.oxcellerator.recipeproject.commands.IngredientCommand;
import de.oxcellerator.recipeproject.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Olexiy Sokurenko <ol.sakura@gmail.com>
 * Date: 27.03.2020
 */
@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureConverter) {
        this.unitOfMeasureConverter = unitOfMeasureConverter;
    }

    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source != null) {
            IngredientCommand target = new IngredientCommand();
            target.setId(source.getId());
            target.setAmount(source.getAmount());
            target.setDescription(source.getDescription());
            target.setUom(unitOfMeasureConverter.convert(source.getUom()));
            return target;
        }
        return null;
    }
}
