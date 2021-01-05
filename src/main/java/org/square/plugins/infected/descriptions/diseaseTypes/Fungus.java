package org.square.plugins.infected.descriptions.diseaseTypes;

import org.bukkit.block.Biome;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.square.plugins.infected.Infected;

public class Fungus extends disease {
    private static Infected plugin = Infected.getPlugin();

    public Fungus() {
        super("Fungus", 5, Biome.MUSHROOM_FIELDS);
    }
    @Override
    public void onPlayerInteract(PlayerInteractEvent e) {
        Inventory inventory = e.getPlayer().getInventory();
        for (ItemStack i : inventory.getContents()) {
            if (i != null && i.hasItemMeta()) {
                ItemMeta meta = i.getItemMeta();
                if (meta.hasLore()) {
                    for (String line : meta.getLore()) {
                        if(line.trim().contains("DiseaseIndex: ")) {
                            if(plugin.infectedChunks.getString("infectedArea." + line.replace("DiseaseIndex: ", "") + ".type") == "Virus") {
                                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 1));
                                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 999999, 1));
                            }
                        }
                    }
                }
            }
        }
        return;
    }
}
