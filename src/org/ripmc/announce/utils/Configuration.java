package org.ripmc.announce.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.ripmc.announce.Announce;

public class Configuration {

    private static final Announce announce = Announce.getInstance();
    private static FileConfiguration config;

    public static void load() {
        announce.reloadConfig();
        announce.saveDefaultConfig();
        config = announce.getConfig();
    }

    public static FileConfiguration getConfig() { return config; }

}
