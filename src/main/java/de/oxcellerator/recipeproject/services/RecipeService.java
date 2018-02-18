package de.oxcellerator.recipeproject.services;

import de.oxcellerator.recipeproject.domain.Recipe;
import java.util.Set;

/**
 * @author Olexiy Sokurenko
 **/
public interface RecipeService {
  Set<Recipe> getRecipes();
}
