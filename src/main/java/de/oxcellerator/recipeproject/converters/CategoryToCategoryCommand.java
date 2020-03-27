package de.oxcellerator.recipeproject.converters;

import de.oxcellerator.recipeproject.commands.CategoryCommand;
import de.oxcellerator.recipeproject.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category source) {
        if (source != null) {
            final CategoryCommand target = new CategoryCommand();
            target.setId(source.getId());
            target.setDescription(source.getDescription());
            return target;
        }
        return null;
    }
}
