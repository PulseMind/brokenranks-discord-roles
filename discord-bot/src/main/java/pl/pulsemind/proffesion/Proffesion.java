package pl.pulsemind.proffesion;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.Icon;
import net.dv8tion.jda.api.entities.Role;
import org.jetbrains.annotations.Nullable;
import pl.pulsemind.utils.RoleUtil;

import java.awt.*;

/** TODO: Role Color & Role Icons */
@RequiredArgsConstructor
public enum Proffesion {
    MAG("Mag Ognia"),
    BARBA("Barbarzyńca"),
    RYCERZ("Rycerz"),
    DRUID("Druid"),
    VODOO("Vodoo"),
    LUCZNIK("Łucznik"),
    SHEED("Sheed");

    @NonNull
    String name;

    @Nullable
    Color color;

    @Nullable
    Icon icon;

    public Role getRole(@NonNull String guildId) {
        return RoleUtil.getRole(guildId, guildId);
    }
}
