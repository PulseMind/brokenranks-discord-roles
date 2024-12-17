package pl.pulsemind.listeners;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import pl.pulsemind.Main;
import pl.pulsemind.proffesion.Profession;
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

        event.getGuild().updateCommands().addCommands(
                Commands.slash("profession", "Wybierz profesję")
                        .addOptions(new OptionData(OptionType.STRING, "profession", "Wybierz profesję")
                                .setRequired(true)
                                .setAutoComplete(true))
        ).queue();

        Arrays.stream(Profession.values())
                .filter(profession -> RoleUtil.getRole(guildId, profession.getRoleName()) == null)
                .forEach(profession -> RoleUtil.createRole(guildId, profession.getRoleName(), profession.getRoleColor()));
    }
}
