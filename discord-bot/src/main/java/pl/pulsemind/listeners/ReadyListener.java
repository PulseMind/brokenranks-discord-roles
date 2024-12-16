package pl.pulsemind.listeners;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import pl.pulsemind.Main;
import pl.pulsemind.proffesion.Proffesion;
import pl.pulsemind.utils.RoleUtil;

import java.util.Arrays;

public class ReadyListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        Main.getLogger().info("I'm active on {} servers.", event.getGuildAvailableCount());
    }

    @Override
    public void onGuildReady(GuildReadyEvent event) {
        final String guildId = event.getGuild().getId();
        Arrays.stream(Proffesion.values())
                .filter(proffesion -> RoleUtil.getRole(guildId, proffesion.getRoleName()) == null)
                .forEach(proffesion -> RoleUtil.createRole(
                        guildId,
                        proffesion.getRoleName(),
                        proffesion.getRoleColor())
                );
    }
}
