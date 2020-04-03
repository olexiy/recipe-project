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
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes source) {
        if (source != null) {
            NotesCommand target = new NotesCommand();
            target.setId(source.getId());
            target.setRecipeNotes(source.getRecipeNotes());

            return target;
        }
        return null;
    }
}
