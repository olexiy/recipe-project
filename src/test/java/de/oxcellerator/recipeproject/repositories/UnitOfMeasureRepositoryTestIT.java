package de.oxcellerator.recipeproject.repositories;

import static org.junit.Assert.*;

import de.oxcellerator.recipeproject.domain.UnitOfMeasure;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Olexiy Sokurenko
 **/
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTestIT {

  @Autowired
  UnitOfMeasureRepository unitOfMeasureRepository;

  @Before
  public void setUp(){

  }

  @Test
  // @DirtiesContext //add if test is destructive for the context
  public void findByDescription() {
    Optional<UnitOfMeasure> optionalUnitOfMeasure =
        unitOfMeasureRepository.findByDescription("Teaspoon");

    assertEquals("Teaspoon", optionalUnitOfMeasure.get().getDescription());
  }
}