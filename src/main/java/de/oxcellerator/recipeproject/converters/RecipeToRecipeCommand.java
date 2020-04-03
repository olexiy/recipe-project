package de.oxcellerator.recipeproject.converters;

import de.oxcellerator.recipeproject.commands.RecipeCommand;
import de.oxcellerator.recipeproject.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @author Olexiy Sokurenko <ol.sakura@gmail.com>
 * Date: 27.03.2020
 */
@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final CategoryToCategoryCommand categoryConverter;
    private final IngredientToIngredientCommand ingredientConverter;
    private final NotesToNotesCommand notesConverter;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConverter, IngredientToIngredientCommand ingredientConverter, NotesToNotesCommand notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Override
    public RecipeCommand convert(Recipe source) {
        if (source != null) {
            RecipeCommand target = new RecipeCommand();
            target.setId(source.getId());
            target.setCookTime(source.getCookTime());
            target.setPrepTime(source.getPrepTime());
            target.setDescription(source.getDescription());
            target.setDifficulty(source.getDifficulty());
            target.setDirections(source.getDirections());
            target.setServings(source.getServings());
            target.setSource(source.getSource());
            target.setUrl(source.getUrl());
            target.setNotes(notesConverter.convert(source.getNotes()));

            if (!CollectionUtils.isEmpty(source.getCategories())) {
                source.getCategories()
                        .forEach(category -> target.getCategories().add(categoryConverter.convert(category)));
            }
            if (!CollectionUtils.isEmpty(source.getIngredients())) {
                source.getIngredients()
                        .forEach(ingredient -> target.getIngredients().add(ingredientConverter.convert(ingredient)));
            }
            return target;
        }
        return null;
    }
}
