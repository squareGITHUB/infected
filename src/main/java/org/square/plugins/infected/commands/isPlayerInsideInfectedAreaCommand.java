package org.square.plugins.infected.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.square.plugins.infected.infectedItems;

public class isPlayerInsideInfectedAreaCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        sender.sendMessage(ChatColor.GREEN + String.valueOf(infectedItems.isLocationInInfectedArea(player.getLocation())));
        return true;
    }
}
