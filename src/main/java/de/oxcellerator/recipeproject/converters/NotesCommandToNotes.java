package de.oxcellerator.recipeproject.converters;

import de.oxcellerator.recipeproject.commands.NotesCommand;
import de.oxcellerator.recipeproject.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author Olexiy Sokurenko <ol.sakura@gmail.com>
 * Date: 27.03.2020
 */

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        if (source == null) {
            return null;
        }

        final Notes target = new Notes();
        target.setId(source.getId());
        target.setRecipeNotes(source.getRecipeNotes());

        return target;
    }
}
