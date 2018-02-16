package de.oxcellerator.recipeproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Olexiy Sokurenko
 */
@Controller
public class IndexController {

  @RequestMapping({"", "/", "/index"})
  public String getIndexPage() {
    return ("index");
  }
}
