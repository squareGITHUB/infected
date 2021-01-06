package org.square.plugins.infected.descriptions.diseaseTypes;

import org.bukkit.block.Biome;
import org.square.plugins.infected.Infected;

public class Combustion extends disease {
    private static Infected plugin = Infected.getPlugin();

    public Combustion() {
        super("Combustion", 1, Biome.NETHER_WASTES);
    }
}
