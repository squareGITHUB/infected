package org.square.plugins.infected;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class generateInfectedArea {
    private static Infected plugin = Infected.getPlugin();

    private static void storePoint(Location point) {
        String string = point.toString();
        Integer index = 1;
        while (!plugin.infectedChunks.contains("index: " + index)) {
            index = index + 1;
        }
        plugin.infectedChunks.set("infectedArea." + index + "." + string + ".age", point.getWorld().getFullTime());
        plugin.infectedChunks.save();
        describeInfectedArea.describeInfectedArea(point);
    }

    public static void generateNewChunk(Location location) {
        double buffer = Math.random() * (200 - 100 + 1) + 100;
        Location newLocation = location.add(buffer, 0, buffer);
        storePoint(newLocation);
    }

}
