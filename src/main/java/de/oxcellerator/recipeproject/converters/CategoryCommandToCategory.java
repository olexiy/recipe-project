package de.oxcellerator.recipeproject.converters;

import de.oxcellerator.recipeproject.commands.CategoryCommand;
import de.oxcellerator.recipeproject.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if (source == null) {
            return null;
        }

        final Category target = new Category();
        target.setId(source.getId());
        target.setDescription(source.getDescription());
        return target;
    }
}
