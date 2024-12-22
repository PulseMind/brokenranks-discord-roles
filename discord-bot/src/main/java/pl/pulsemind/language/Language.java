package pl.pulsemind.language;

import lombok.NonNull;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {

    private final ResourceBundle resourceBundle;

    public Language(@NonNull String locale) {
        this.resourceBundle = ResourceBundle.getBundle("language", getLocaleByString(locale));
    }

    public String getString(@NonNull String key, Object... args) {
        String message = resourceBundle.getString(key);
        return java.text.MessageFormat.format(message, args);
    }

    private static Locale getLocaleByString(@NonNull String locale) {
        if(locale.equalsIgnoreCase("pl"))
            return new Locale("pl", "PL");
        else
            return new Locale("en", "US");
    }
}
