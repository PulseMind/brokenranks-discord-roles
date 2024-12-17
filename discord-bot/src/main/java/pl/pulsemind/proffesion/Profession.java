package pl.pulsemind.proffesion;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.pulsemind.Main;

import java.awt.*;

@RequiredArgsConstructor
public enum Profession {
    FIRE_MAGE("\uD83D\uDD25", Main.instance().isPolish() ? "Mag Ognia" : "Fire Mage", Color.decode("#8C4F00")),
    VOODOO("\uD83E\uDE84", "Voodoo", Color.decode("#720C71")),
    BARBARIAN("⚔\uFE0F", Main.instance().isPolish() ? "Barbarzyńca" : "Barbarian", Color.decode("#560000")),
    DRUID("\uD83C\uDF3F", "Druid", Color.decode("#3D6A16")),
    ARCHER("\uD83C\uDFF9", Main.instance().isPolish() ? "Łucznik" : "Archer", Color.decode("#643922")),
    SHEED("\uD83E\uDD4A", "Sheed", Color.decode("#093E80")),
    KNIGHT("\uD83D\uDEE1\uFE0F", Main.instance().isPolish() ? "Rycerz" : "Knight", Color.decode("#6E9185"));

    @NonNull
    private final String emoji;

    @NonNull
    @Getter
    private final String name;

    @NonNull
    @Getter
    private final Color roleColor;

    public String getRoleName() {
        return String.format("%s • %s",
                this.emoji,
                this.name
        );
    }
}
