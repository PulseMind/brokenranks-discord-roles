package pl.pulsemind.proffesion;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.pulsemind.Main;
import pl.pulsemind.language.Language;

import java.awt.*;

@RequiredArgsConstructor
public enum Profession {
    FIRE_MAGE("\uD83D\uDD25", Main.instance().getLang().getString("profession_name_fire_mage"), Color.decode("#8C4F00")),
    VOODOO("\uD83E\uDE84", Main.instance().getLang().getString("profession_name_voodoo"), Color.decode("#720C71")),
    BARBARIAN("⚔\uFE0F", Main.instance().getLang().getString("profession_name_barbarian"), Color.decode("#560000")),
    DRUID("\uD83C\uDF3F", Main.instance().getLang().getString("profession_name_druid"), Color.decode("#3D6A16")),
    ARCHER("\uD83C\uDFF9", Main.instance().getLang().getString("profession_name_archer"), Color.decode("#643922")),
    SHEED("\uD83E\uDD4A", Main.instance().getLang().getString("profession_name_sheed"), Color.decode("#093E80")),
    KNIGHT("\uD83D\uDEE1\uFE0F", Main.instance().getLang().getString("profession_name_knight"), Color.decode("#6E9185"));

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
