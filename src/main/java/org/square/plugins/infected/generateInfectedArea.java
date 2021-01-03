package org.square.plugins.infected;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class generateInfectedArea {
    private static Infected plugin = Infected.getPlugin();

    private static void storePoint(Location point) {
        String string = String.format("{}, {}, {}", point.getBlockX(), point.getBlockZ(), point.getWorld());
        plugin.infectedChunks.set("infectedArea." + string + ".age", point.getWorld().getFullTime());
        plugin.infectedChunks.save();
        describeInfectedArea.describeInfectedArea(string, point);
    }

    public static Location findLocation(Player player) {
        Location location = player.getLocation();
        return location;
    }
    public static void generateNewChunk(Location location) {
        double buffer = Math.random() * (200 - 100 + 1) + 100;
        Location newLocation = location.add(buffer, 0, buffer);
        storePoint(newLocation);
    }

}
