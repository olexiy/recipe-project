package de.oxcellerator.recipeproject.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Olexiy Sokurenko
 **/
public class CategoryTest {

  Category category;

  @Before
  public void setUp(){
    category = new Category();
  }
  @Test
  public void getId() {
    Long idValue= 4L;
    category.setId(idValue);
    assertEquals(idValue, category.getId());
  }

  @Test
  public void getDescription() {
  }

  @Test
  public void getRecipes() {
  }
}