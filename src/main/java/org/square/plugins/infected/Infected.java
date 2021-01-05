package org.square.plugins.infected;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.square.plugins.infected.events.entityDeath;
import org.square.plugins.infected.events.entitySpawn;
import org.square.plugins.infected.utils.Config;

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
        infectedChunks = new Config("infectedArea.yml");
        config = new Config("config.yml");

        PluginManager manager = this.getServer().getPluginManager();
        manager.registerEvents(new entityDeath(), this);
        manager.registerEvents(new entitySpawn(), this);
    }
}
