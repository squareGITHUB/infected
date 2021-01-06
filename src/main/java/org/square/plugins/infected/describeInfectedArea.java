package org.square.plugins.infected;

import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.square.plugins.infected.descriptions.diseaseTypes.Virus;
import org.square.plugins.infected.descriptions.diseaseTypes.disease;
import org.square.plugins.infected.descriptions.diseaseTypes.diseaseTypes;
import org.square.plugins.infected.utils.Log;

public class describeInfectedArea {
    private static Infected plugin = Infected.getPlugin();

    public static String findFavouriteDisease(Biome biome) {
        for (diseaseTypes type : diseaseTypes.values()) {
            try {
                if (type.getDisease().newInstance().getFavouriteBiome() == biome.toString().toUpperCase()) {
                    return type.name();
                }
            } catch (Exception e) {
                Log.warn("Warning from findFavouriteDisease!");
            }
        }
        return "none";
    }
}

