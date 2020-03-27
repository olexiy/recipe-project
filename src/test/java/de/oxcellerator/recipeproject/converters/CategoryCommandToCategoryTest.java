package de.oxcellerator.recipeproject.converters;

import de.oxcellerator.recipeproject.commands.CategoryCommand;
import de.oxcellerator.recipeproject.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Olexiy Sokurenko <ol.sakura@gmail.com>
 * Date: 27.03.2020
 */
class CategoryCommandToCategoryTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;

    CategoryCommandToCategory converter;

    @BeforeEach
    public void setUP() {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void testConvert() {
        CategoryCommand command = new CategoryCommand();

        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);
        Category category = converter.convert(command);
        assertEquals(LONG_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());

    }

}