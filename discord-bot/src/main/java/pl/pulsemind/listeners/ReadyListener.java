package pl.pulsemind.listeners;

import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import pl.pulsemind.Main;

public class ReadyListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        Main.getLogger().info("I'm active on {} servers.", event.getGuildAvailableCount());
    }
}
