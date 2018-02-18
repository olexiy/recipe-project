package de.oxcellerator.recipeproject.repositories;

import de.oxcellerator.recipeproject.domain.UnitOfMeasure;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Olexiy Sokurenko
 **/
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
  Optional<UnitOfMeasure> findByDescription(String description);
}
