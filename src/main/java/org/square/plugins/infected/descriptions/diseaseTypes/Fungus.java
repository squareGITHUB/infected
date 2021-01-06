package org.square.plugins.infected.descriptions.diseaseTypes;

import org.bukkit.block.Biome;
import org.square.plugins.infected.Infected;

public class Fungus extends disease {
    private static Infected plugin = Infected.getPlugin();

    public Fungus() {
        super("Fungus", 5, Biome.MUSHROOM_FIELDS);
    }
}
