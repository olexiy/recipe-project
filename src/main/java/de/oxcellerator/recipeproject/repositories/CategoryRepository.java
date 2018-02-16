package de.oxcellerator.recipeproject.repositories;

import de.oxcellerator.recipeproject.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Olexiy Sokurenko
 **/
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
