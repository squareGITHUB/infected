package org.square.plugins.infected;

import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.square.plugins.infected.descriptions.diseaseTypes.diseaseTypes;

public class generateInfectedArea {
    private static Infected plugin = Infected.getPlugin();

    private static void storePoint(Location point) {
        Integer globalInfectionIndex = plugin.config.getInt("globalInfectionIndex");
        Integer index = globalInfectionIndex + 1;
        plugin.infectedChunks.set("infectedArea."  + index + ".age", point.getWorld().getFullTime());
        plugin.infectedChunks.set("infectedArea."  + index + ".location.world", point.getWorld().getName());
        plugin.infectedChunks.set("infectedArea."  + index + ".location.x", point.getX());
        plugin.infectedChunks.set("infectedArea."  + index + ".location.z", point.getZ());
        plugin.infectedChunks.save();
        plugin.config.set("globalInfectionIndex", index);

        Biome biome = point.getBlock().getBiome();
        String favouriteDisease = describeInfectedArea.findFavouriteDisease(biome);
        if (favouriteDisease == "none") {
            plugin.infectedChunks.set("infectedArea." + index.toString() + ".type", "BACTERIA");
            plugin.infectedChunks.set("infectedArea." + index.toString() + ".transmission", "1");
            plugin.config.save();
        } else {
            String disease = favouriteDisease;
            plugin.infectedChunks.set("infectedArea." + index.toString() + ".type", disease);
            plugin.config.save();
            try {
                Integer transmission = diseaseTypes.VIRUS.getDisease().newInstance().getTransmission();
                plugin.infectedChunks.set("infectedArea." + index.toString() + ".transmission", transmission);
                plugin.config.save();
            } catch (Exception e) {
                plugin.infectedChunks.set("infectedArea." + index.toString() + ".transmission", 1);
                plugin.config.save();
            }
        }
    }

    public static void generateNewChunk(Location location) {
        double buffer = Math.random() * (10 - 10 + 1) + 10;
        Location newLocation = location.add(buffer, 0, buffer);
        storePoint(newLocation);
    }

}
