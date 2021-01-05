package org.square.plugins.infected.descriptions.diseaseTypes;

import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.square.plugins.infected.Infected;
import org.square.plugins.infected.infectedItems;

import java.util.List;

public class Virus extends disease {
    private static Infected plugin = Infected.getPlugin();

    public Virus() {
        super("Virus", 5, Biome.PLAINS);
    }
    public static void symptoms(Player player) {
        player.giveExp(5);
    }
    @Override
    public void onEntityDeath(EntityDeathEvent e) {
        Location location = e.getEntity().getLocation();
        if (infectedItems.isPlayerInInfectedArea(location, "Virus") != "null") {
            double chance = Math.random() * (5 - 1 + 1) + 1;
        }
    }
}
