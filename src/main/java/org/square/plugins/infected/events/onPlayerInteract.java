package org.square.plugins.infected.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.square.plugins.infected.Infected;
import org.square.plugins.infected.utils.Log;

public class onPlayerInteract implements Listener {
    private static Infected plugin = Infected.getPlugin();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Inventory inventory = e.getPlayer().getInventory();
        for (ItemStack i : inventory.getContents()) {
            if (i != null && i.hasItemMeta()) {
                ItemMeta meta = i.getItemMeta();
                if (meta.hasLore()) {
                    for (String line : meta.getLore()) {
                        if(line.contains("infected:")) {
                            if(plugin.infectedChunks.getString("infectedArea." + line.replace("infected:", "") + ".type") == "VIRUS") {
                                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 99999, 1));
                                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, 999999, 1));
                            } else if(plugin.infectedChunks.getString("infectedArea." + line.replace("infected:", "") + ".type") == "FUNGUS") {
                                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 1));
                                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 999999, 1));
                            } else if(plugin.infectedChunks.getString("infectedArea." + line.replace("infected:", "") + ".type") == "BACTERIA") {
                                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 99999, 1));
                            } else if(plugin.infectedChunks.getString("infectedArea." + line.replace("infected:", "") + ".type") == "COMBUSTION") {
                                e.getPlayer().setFireTicks(999999);
                                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 999999, 1));
                            }
                        }
                    }
                }
            }
        }
        return;
    }
}
