package org.square.plugins.infected;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class generateInfectedArea {
    private static Infected plugin = Infected.getPlugin();

    private static void storePoint(Location point) {
        Integer globalInfectionIndex = plugin.config.getInt("globalInfectionIndex");
        plugin.infectedChunks.set("infectedArea."  + globalInfectionIndex+1 + ".age", point.getWorld().getFullTime());
        plugin.infectedChunks.set("infectedArea."  + globalInfectionIndex+1 + ".location.world", point.getWorld().toString());
        plugin.infectedChunks.set("infectedArea."  + globalInfectionIndex+1 + ".location.x", point.getX());
        plugin.infectedChunks.set("infectedArea."  + globalInfectionIndex+1 + ".location.z", point.getZ());
        plugin.infectedChunks.save();
        plugin.config.set("globalInfectionIndex", globalInfectionIndex + 1);
        describeInfectedArea.describeInfectedArea(point, globalInfectionIndex+1);
    }

    public static void generateNewChunk(Location location) {
        double buffer = Math.random() * (200 - 100 + 1) + 100;
        Location newLocation = location.add(buffer, 0, buffer);
        while (infectedItems.isLocationInInfectedArea(newLocation, "") == -1) {
            buffer = Math.random() * (200 - 100 + 1) + 100;
            newLocation = location.add(buffer, 0, buffer);
        }
        storePoint(newLocation);
    }

}
