package de.oxcellerator.recipeproject.domain;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

  public Category() {
  }

  protected boolean canEqual(Object other) {
    return other instanceof Category;
  }

}
