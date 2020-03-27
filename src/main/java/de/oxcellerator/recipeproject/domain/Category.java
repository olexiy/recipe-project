package de.oxcellerator.recipeproject.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Olexiy Sokurenko
 **/
@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String description;
  @ManyToMany(mappedBy = "categories")
  private Set<Recipe> recipes;

  protected boolean canEqual(Object other) {
    return other instanceof Category;
  }

}
