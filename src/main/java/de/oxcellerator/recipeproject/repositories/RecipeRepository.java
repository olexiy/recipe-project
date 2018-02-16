package de.oxcellerator.recipeproject.repositories;

import de.oxcellerator.recipeproject.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Olexiy Sokurenko
 **/
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
