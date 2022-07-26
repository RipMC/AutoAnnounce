package org.ripmc.announce.tasks;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.ripmc.announce.utils.ComponentUtils;
import org.ripmc.announce.utils.Configuration;

import java.util.List;
import java.util.Random;

public class AnnounceTask implements Runnable {

    private Random random = new Random();

    @Override
    public void run() {
        List<String> messages = Configuration.getConfig().getStringList("announcements");
        Component message = ComponentUtils.toComponent(messages.get(random.nextInt(messages.size() - 1)));

        for (Player player : Bukkit.getOnlinePlayers())
            player.sendMessage(message);
    }

}
