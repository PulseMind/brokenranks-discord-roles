package pl.pulsemind;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;

public class Main {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        JDABuilder builder = JDABuilder.createDefault(dotenv.get("DISCORD_BOT_TOKEN"));
        builder.build();
    }
}