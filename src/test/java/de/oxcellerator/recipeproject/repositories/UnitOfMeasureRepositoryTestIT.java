package de.oxcellerator.recipeproject.repositories;

import de.oxcellerator.recipeproject.domain.UnitOfMeasure;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Olexiy Sokurenko
 **/
@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTestIT {

  @Autowired
  UnitOfMeasureRepository unitOfMeasureRepository;

  @Test
  // @DirtiesContext //add if test is destructive for the context
  public void findByDescription() {
    Optional<UnitOfMeasure> optionalUnitOfMeasure =
        unitOfMeasureRepository.findByDescription("Teaspoon");

    assertEquals("Teaspoon", optionalUnitOfMeasure.get().getDescription());
  }
}