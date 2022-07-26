package org.ripmc.announce.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.ripmc.announce.Announce;
import org.ripmc.announce.utils.ComponentUtils;
import org.ripmc.announce.utils.Configuration;

public class CommandReload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        if (!sender.hasPermission("ripmc.announce.reload")) {
            sender.sendMessage(ComponentUtils.toComponent(Configuration.getConfig().getString("reload.nopermissions")));
            return true;
        }

        Configuration.load();
        Announce.cancelTask();
        Announce.createTask();

        sender.sendMessage(ComponentUtils.toComponent(Configuration.getConfig().getString("reload.complete")));

        return true;
    }

}
