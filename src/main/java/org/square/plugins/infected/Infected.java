package org.square.plugins.infected;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.square.plugins.infected.commands.isPlayerInsideInfectedAreaCommand;
import org.square.plugins.infected.events.*;
import org.square.plugins.infected.utils.Config;

import java.io.File;

public final class Infected extends JavaPlugin {
    private static Infected plugin;
    public static Infected getPlugin()
    {
        return plugin;
    }

    public Config infectedChunks;
    public Config config;

    @Override
    public void onEnable() {
        plugin = this;
        config = new Config("config.yml");

        config.set("globalInfectionIndex", 0);
        config.save();

        File infectedArea = new File(plugin.getDataFolder(), "infectedArea.yml");
        infectedArea.delete();
        infectedChunks = new Config("infectedArea.yml");

        PluginManager manager = this.getServer().getPluginManager();
        manager.registerEvents(new entityDeath(), this);
        manager.registerEvents(new entitySpawn(), this);
        manager.registerEvents(new onPlayerInteract(), this);
        manager.registerEvents(new playerDropEvent(), this);

        getCommand("isPlayerInsideInfectedAreaCommand").setExecutor(new isPlayerInsideInfectedAreaCommand());
    }
}
