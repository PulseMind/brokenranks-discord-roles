package pl.pulsemind.proffesion;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.pulsemind.Main;

import java.awt.*;

@RequiredArgsConstructor
public enum Proffesion {
    FIRE_MAGE("\uD83D\uDD25 " + (Main.instance().isPolish() ? "Mag Ognia" : "Fire Mage"), Color.ORANGE),
    VOODOO("\uD83E\uDE84 Voodoo", Color.PINK.darker()),
    BARBARIAN("⚔\uFE0F " + (Main.instance().isPolish() ? "Barbarzyńca" : "Barbarian"), Color.RED.darker()),
    DRUID("\uD83C\uDF3F Druid", Color.GREEN.darker()),
    ARCHER("\uD83C\uDFF9" + (Main.instance().isPolish() ? "Łucznik" : "Archer"), Color.YELLOW.darker()),
    SHEED("\uD83E\uDD4A Sheed", Color.BLUE.darker()),
    KNIGHT("\uD83D\uDEE1\uFE0F " + (Main.instance().isPolish() ? "Rycerz" : "Knight"), Color.BLUE.brighter());

    @NonNull
    @Getter
    private final String roleName;

    @NonNull
    @Getter
    private final Color roleColor;
}
