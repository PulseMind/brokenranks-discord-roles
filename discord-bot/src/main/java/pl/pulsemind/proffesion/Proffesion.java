package pl.pulsemind.proffesion;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.pulsemind.Main;

import java.awt.*;

@RequiredArgsConstructor
public enum Proffesion {
    FIRE_MAGE("\uD83D\uDD25", Main.instance().isPolish() ? "Mag Ognia" : "Fire Mage", Color.ORANGE),
    VOODOO("\uD83E\uDE84", "Voodoo", Color.ORANGE),
    BARBARIAN("⚔\uFE0F", Main.instance().isPolish() ? "Barbarzyńca" : "Barbarian", Color.ORANGE),
    DRUID("\uD83C\uDF3F", "Druid", Color.ORANGE),
    ARCHER("\uD83C\uDFF9", Main.instance().isPolish() ? "Łucznik" : "Archer", Color.ORANGE),
    SHEED("\uD83E\uDD4A", "Sheed", Color.ORANGE),
    KNIGHT("\uD83D\uDEE1\uFE0F", Main.instance().isPolish() ? "Rycerz" : "Knight", Color.ORANGE);

    @NonNull
    private final String emoji;

    @NonNull
    @Getter
    private final String name;

    @NonNull
    @Getter
    private final Color roleColor;

    public String getRoleName() {
        return String.format("%s %s",
                this.emoji,
                this.name
        );
    }
}
