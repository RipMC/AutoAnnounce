package org.ripmc.announce;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.ripmc.announce.commands.CommandReload;
import org.ripmc.announce.tasks.AnnounceTask;
import org.ripmc.announce.utils.Configuration;

public class Announce extends JavaPlugin {

    private static Announce instance;
    private static BukkitTask task;

    public static Announce getInstance() { return instance; }

    @Override
    public void onEnable() {
        instance = this;

        Configuration.load();
        createTask();

        getCommand("autoannouncereload").setExecutor(new CommandReload());
    }

    public static void createTask() {
        int interval = Configuration.getConfig().getInt("interval") * 20;

        task = Bukkit.getScheduler().runTaskTimerAsynchronously(instance, new AnnounceTask(), interval, interval);
    }

    public static void cancelTask() { task.cancel(); }

}
