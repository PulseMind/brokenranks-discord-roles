package pl.pulsemind;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.pulsemind.language.Language;
import pl.pulsemind.listeners.ReadyListener;
import pl.pulsemind.listeners.CommandListener;

public class BrokenDiscordRoles {

    @NonNull
    @Getter(AccessLevel.PUBLIC)
    private final Logger logger = LoggerFactory.getLogger(BrokenDiscordRoles.class);

    @NonNull
    @Getter(AccessLevel.PRIVATE)
    private final Dotenv dotEnv = Dotenv.load();

    @NonNull
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PRIVATE)
    private JDA jda;

    @NonNull
    @Getter
    private Language lang = new Language(this.dotEnv.get("LANGUAGE"));

    private void registerListeners(@NonNull JDABuilder jdaBuilder) {
        jdaBuilder.addEventListeners(
                new ReadyListener(),
                new CommandListener()
        );
    }

    private void enableIntents(@NonNull JDABuilder jdaBuilder) {
        jdaBuilder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
    }

    void run() {
        JDABuilder jdaBuilder = JDABuilder.createDefault(
                this.dotEnv.get("DISCORD_BOT_TOKEN")
        );

        this.registerListeners(jdaBuilder);
        this.enableIntents(jdaBuilder);

        jdaBuilder.setActivity(Activity.playing("Broken Ranks"));
        setJda(jdaBuilder.build());
    }
}
