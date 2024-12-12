package pl.pulsemind;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.slf4j.Logger;

public class Main {

    @Accessors(fluent = true)
    @Getter (AccessLevel.PUBLIC)
    @Setter (AccessLevel.PRIVATE)
    private static BrokenDiscordRoles instance;

    public static void main(String[] args) {
        instance(new BrokenDiscordRoles());
        instance().run();
    }

    public static Logger getLogger() {
        return instance().getLogger();
    }
}