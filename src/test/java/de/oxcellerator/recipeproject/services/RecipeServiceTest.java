package de.oxcellerator.recipeproject.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.oxcellerator.recipeproject.domain.Recipe;
import de.oxcellerator.recipeproject.repositories.RecipeRepository;
import de.oxcellerator.recipeproject.services.impl.RecipeServiceImpl;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author Olexiy Sokurenko
 **/
public class RecipeServiceTest {

  RecipeServiceImpl recipeService;

  @Mock
  RecipeRepository recipeRepository;

  @Before
  public void setUp() throws Exception{
    MockitoAnnotations.initMocks(this);
    recipeService = new RecipeServiceImpl(recipeRepository);
  }

  @Test
  public void getRecipes() {
    Recipe recipe = new Recipe();
    HashSet<Recipe> recipesData = new HashSet<>();
    recipesData.add(recipe);
    when(recipeService.getRecipes()).thenReturn(recipesData);

    Set<Recipe> recipes = recipeService.getRecipes();
    assertEquals(recipes.size(), 1);
    verify(recipeRepository, times((1))).findAll();

  }
}