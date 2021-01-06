package org.square.plugins.infected.descriptions.diseaseTypes;

import org.bukkit.block.Biome;
import org.square.plugins.infected.Infected;

public class Bacteria extends disease {
    public Bacteria() {
        super("Bacteria", 1, Biome.JUNGLE);
    }
    private static Infected plugin = Infected.getPlugin();

}
