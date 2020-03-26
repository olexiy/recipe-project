package de.oxcellerator.recipeproject.converters;

import de.oxcellerator.recipeproject.commands.UnitOfMeasureCommand;
import de.oxcellerator.recipeproject.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author Olexiy Sokurenko
 */
@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {

        if (source == null) {
            return null;
        }

        final UnitOfMeasure target = new UnitOfMeasure();
        target.setId(source.getId());
        target.setDescription((source.getDescription()));
        return target;
    }
}
