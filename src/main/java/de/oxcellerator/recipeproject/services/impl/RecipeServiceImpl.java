package de.oxcellerator.recipeproject.services.impl;

import de.oxcellerator.recipeproject.domain.Recipe;
import de.oxcellerator.recipeproject.repositories.RecipeRepository;
import de.oxcellerator.recipeproject.services.RecipeService;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Olexiy Sokurenko
 **/
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
  private final RecipeRepository recipeRepository;

  public RecipeServiceImpl(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  @Override
  public Set<Recipe> getRecipes() {
    log.debug("I'm in the service");

    Set<Recipe> recipeSet = new HashSet<>();
    recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
    return recipeSet;
  }
}
