package de.oxcellerator.recipeproject.converters;

import de.oxcellerator.recipeproject.commands.RecipeCommand;
import de.oxcellerator.recipeproject.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @author Olexiy Sokurenko <ol.sakura@gmail.com>
 * Date: 27.03.2020
 */
@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryConverter, IngredientCommandToIngredient ingredientConverter, NotesCommandToNotes notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source == null) {
            return null;
        }
        final Recipe target = new Recipe();
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
}
