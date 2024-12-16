package pl.pulsemind;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.pulsemind.listeners.GuildMessageListener;
import pl.pulsemind.listeners.ReadyListener;

public class BrokenDiscordRoles {

    @NonNull
    @Getter (AccessLevel.PUBLIC)
    private final Logger logger = LoggerFactory.getLogger(BrokenDiscordRoles.class);

    @NonNull
    @Getter (AccessLevel.PUBLIC)
    private final Dotenv dotEnv = Dotenv.load();

    @NonNull
    @Getter (AccessLevel.PUBLIC)
    @Setter (AccessLevel.PRIVATE)
    private JDA jda;

    @Getter
    private final boolean isPolish = Boolean.parseBoolean(dotEnv.get("POLISH_LANGUAGE"));

    private void registerListeners(@NonNull JDABuilder jdaBuilder) {
        jdaBuilder.addEventListeners(
                new ReadyListener(),
                new GuildMessageListener()
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
