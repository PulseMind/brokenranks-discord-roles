package pl.pulsemind;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.pulsemind.listeners.ReadyListener;

@RequiredArgsConstructor
public class BrokenDiscordRoles {

    @Getter (AccessLevel.PUBLIC)
    private final Logger logger;

    @NonNull
    @Getter (AccessLevel.PRIVATE)
    private final Dotenv dotEnv;

    public BrokenDiscordRoles() {
        this.logger = LoggerFactory.getLogger(BrokenDiscordRoles.class);
        this.dotEnv = Dotenv.load();
    }

    private void registerListeners(JDABuilder jdaBuilder) {
        jdaBuilder.addEventListeners(new ReadyListener());
    }

    private void enableIntents(JDABuilder jdaBuilder) {
        jdaBuilder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
    }

    void run() {
        JDABuilder jdaBuilder = JDABuilder.createDefault(
                this.dotEnv.get("DISCORD_BOT_TOKEN")
        );

        this.registerListeners(jdaBuilder);
        this.enableIntents(jdaBuilder);

        jdaBuilder.setActivity(Activity.playing("Broken Ranks"));
        jdaBuilder.build();
    }
}
