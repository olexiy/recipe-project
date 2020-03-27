package de.oxcellerator.recipeproject.controllers;

import de.oxcellerator.recipeproject.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Olexiy Sokurenko
 */
@Controller
@Slf4j
public class IndexController {

  private final RecipeService recipeService;

  public IndexController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @GetMapping({"", "/", "/index"})
  public String getIndexPage(Model model) {
    log.debug("Getting Index page");

    model.addAttribute("recipes", recipeService.getRecipes());

    return "index";
  }


}
