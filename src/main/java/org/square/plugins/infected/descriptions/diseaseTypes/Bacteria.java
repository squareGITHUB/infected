package org.square.plugins.infected.descriptions.diseaseTypes;

import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

public class Bacteria extends disease {
    public Bacteria() {
        super("Bacteria", 1, Biome.JUNGLE);
    }
    public static void symptoms(Player player) {
        player.giveExp(5);
    }
}
