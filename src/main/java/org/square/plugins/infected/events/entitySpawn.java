package org.square.plugins.infected.events;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.square.plugins.infected.Infected;
import org.square.plugins.infected.generateInfectedArea;
import org.square.plugins.infected.utils.Log;

public class entitySpawn implements Listener {
    private Infected plugin;
    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        Location location = event.getLocation();
        Entity entity = event.getEntity();
        String pathToRate = "server.InfectionRate." + location.getBlock().getBiome();

        if (!plugin.config.contains(pathToRate)) {
            return;
        }
        if (plugin.infectedChunks.contains(String.format("{}, {}, {}", entity.getLocation().getBlockX(), entity.getLocation().getBlockZ(), entity.getLocation().getWorld()))) {
            return;
        }
        int infectionRate = plugin.config.getInt("server.InfectionRate." + location.getBlock().getBiome());

        if (Math.floor(Math.random() * (infectionRate+1)) == 1) {
            generateInfectedArea.generateNewChunk(location);
            Log.info("Created a new infection point!");
        }
    }
}
