package org.square.plugins.infected.descriptions.diseaseTypes;

import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.square.plugins.infected.Infected;

public class Parasite extends disease {
    private static Infected plugin = Infected.getPlugin();

    public Parasite() {
        super("Parasite", 2, Biome.DESERT);
    }
    public static void symptoms(Player player) {
        player.giveExp(5);
    }
}
