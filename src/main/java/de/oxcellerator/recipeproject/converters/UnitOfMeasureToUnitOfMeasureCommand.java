package de.oxcellerator.recipeproject.converters;

import de.oxcellerator.recipeproject.commands.UnitOfMeasureCommand;
import de.oxcellerator.recipeproject.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {

        if (source != null) {
            final UnitOfMeasureCommand target = new UnitOfMeasureCommand();
            target.setId(source.getId());
            target.setDescription((source.getDescription()));
            return target;
        }

        return null;
    }
}
