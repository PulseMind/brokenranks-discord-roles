package pl.pulsemind.utils;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.requests.restaction.RoleAction;
import org.jetbrains.annotations.Nullable;
import pl.pulsemind.Main;

import java.awt.*;

@UtilityClass
public class RoleUtil {

    public void createRole(@NonNull String guildId, @NonNull String name, @Nullable Color color) {
        Guild guild = Main.instance().getJda().getGuildById(guildId);
        if(guild == null) return;

        RoleAction roleAction = guild.createRole();
        roleAction.setName(name);
        if(color != null) roleAction.setColor(color);

        roleAction.queue();
    }

    public Role getRole(@NonNull String guildId, @NonNull String name) {
        Guild guild = Main.instance().getJda().getGuildById(guildId);
        if(guild == null) return null;
        return guild.getRoles().stream()
                .filter(role -> role.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public boolean hasRole(Member member, String roleId) {
        for (Role role : member.getRoles())
            if (role.getId().equals(roleId))
                return true;

        return false;
    }
}
