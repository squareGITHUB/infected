package org.square.plugins.infected.descriptions.diseaseTypes;

import org.bukkit.block.Biome;
import org.bukkit.event.entity.EntityDeathEvent;

public class disease {
    private String name;
    private Integer transmission;
    private Biome favouriteBiome;

    public disease(String name, Integer transmission, Biome favouriteBiome) {
        this.name = name;
        this.transmission = transmission;
        this.favouriteBiome = favouriteBiome;
    }
    public String getFavouriteBiome() {
        return favouriteBiome.toString();
    }
    public void onEntityDeath(EntityDeathEvent e) {}

}
