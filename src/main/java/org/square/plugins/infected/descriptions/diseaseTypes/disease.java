package org.square.plugins.infected.descriptions.diseaseTypes;

import org.bukkit.block.Biome;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

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
    public Integer getTransmission() { return transmission; }
    public void onPlayerInteract(PlayerInteractEvent e) {}
    public void onPlayerDropItem(PlayerDropItemEvent e) {}

}
