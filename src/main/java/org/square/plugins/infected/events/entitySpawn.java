package org.square.plugins.infected.events;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.square.plugins.infected.Infected;
import org.square.plugins.infected.generateInfectedArea;
import org.square.plugins.infected.infectedItems;
import org.square.plugins.infected.utils.Log;

import java.util.Locale;

public class entitySpawn implements Listener {
    private static Infected plugin = Infected.getPlugin();

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        Location location = event.getLocation();
        Entity entity = event.getEntity();
        Integer index = infectedItems.locationToIndex(location);
        if (index != -1) {
            return;
        }
        if (!plugin.config.contains("server.infectionRate." + location.getBlock().getBiome().toString().toUpperCase())) {
            int infectionRate = 10;
            if (Math.floor(Math.random() * (infectionRate+1)) == 1) {
                generateInfectedArea.generateNewChunk(location);
                Log.info("Created a new infection point! (not defined in config)");
            }
        } else {
            int infectionRate = plugin.config.getInt("server.infectionRate." + location.getBlock().getBiome().toString());
            if (Math.floor(Math.random() * (infectionRate+1)) == 1) {
                generateInfectedArea.generateNewChunk(location);
                Log.info("Created a new infection point!");
            }
        }
    }
}
