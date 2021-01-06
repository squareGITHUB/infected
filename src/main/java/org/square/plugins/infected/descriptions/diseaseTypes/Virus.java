package org.square.plugins.infected.descriptions.diseaseTypes;

import org.bukkit.block.Biome;
import org.square.plugins.infected.Infected;

public class Virus extends disease {
    private static Infected plugin = Infected.getPlugin();

    public Virus() {
        super("Virus", 3, Biome.PLAINS);
    }
}
