package pl.pulsemind.listeners;

import lombok.Getter;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import pl.pulsemind.Main;
import pl.pulsemind.language.Language;
import pl.pulsemind.proffesion.Profession;
import pl.pulsemind.utils.RoleUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CommandListener extends ListenerAdapter {

    @Getter
    private final Language lang = Main.instance().getLang();

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        Guild guild = event.getGuild();
        Member member = event.getMember();
        if(guild == null || member == null)
            return;

        if(event.getName().equalsIgnoreCase(this.getLang().getString("profession_cmd_name"))) {
            String guildId = guild.getId();
            String roleName = Objects.requireNonNull(event.getOption(this.getLang().getString("profession_cmd_argument"))).getAsString();

            Role role = RoleUtil.getRole(guildId, roleName);
            Profession profession = Arrays.stream(Profession.values())
                    .filter(prof -> prof.getRoleName().equalsIgnoreCase(roleName))
                    .findAny().orElse(null);

            if(role == null || profession == null) {
                event.reply(this.getLang().getString("profession_cmd_not_found", roleName)).queue();
                return;
            }

            if(RoleUtil.hasRole(member, role.getId())) {
                guild.removeRoleFromMember(member, role).queue(
                        success -> event.reply(this.getLang().getString("profession_cmd_deleted", role.getAsMention())).queue(),
                        error -> event.reply(this.getLang().getString("profession_cmd_error", error.getMessage())).queue()
                );
                return;
            }

            guild.addRoleToMember(member, role).queue(
                    success -> event.reply(this.getLang().getString("profession_cmd_added", role.getAsMention())).queue(),
                    error -> event.reply(this.getLang().getString("profession_cmd_error", error.getMessage())).queue()
            );
        }
    }

    @Override
    public void onCommandAutoCompleteInteraction(CommandAutoCompleteInteractionEvent event) {
        if (event.getName().equalsIgnoreCase(this.getLang().getString("profession_cmd_name"))
                && event.getFocusedOption().getName().equals(this.getLang().getString("profession_cmd_argument"))) {
            final List<Command.Choice> options = Arrays.stream(Profession.values())
                    .map(Profession::getRoleName)
                    .filter(prof -> prof.toLowerCase().contains(event.getFocusedOption().getValue().toLowerCase()))
                    .map(prof -> new Command.Choice(prof, prof))
                    .collect(Collectors.toList());

            event.replyChoices(options).queue();
        }
    }
}
