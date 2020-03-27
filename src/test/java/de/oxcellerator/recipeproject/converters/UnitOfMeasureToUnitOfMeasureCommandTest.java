package de.oxcellerator.recipeproject.converters;

import de.oxcellerator.recipeproject.commands.UnitOfMeasureCommand;
import de.oxcellerator.recipeproject.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Olexiy Sokurenko <ol.sakura@gmail.com>
 * Date: 26.03.2020
 */
public class UnitOfMeasureToUnitOfMeasureCommandTest {
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @BeforeEach
    public void setUp() {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    void convert() {
        //given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(LONG_VALUE);
        uom.setDescription(DESCRIPTION);

        //when
        UnitOfMeasureCommand command = converter.convert(uom);

        //then
        assertNotNull(command);
        assertEquals(command.getId(), LONG_VALUE);
        assertEquals(command.getDescription(), DESCRIPTION);
    }
}
