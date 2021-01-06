package org.square.plugins.infected.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.square.plugins.infected.Infected;
import org.square.plugins.infected.infectedItems;
import org.square.plugins.infected.utils.Log;

public class playerDropEvent implements Listener {
    private static Infected plugin = Infected.getPlugin();

    @EventHandler
    public void playerDropEvent(PlayerDropItemEvent e) {
        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            if(e.getItemDrop().getLocation().getBlock().getType().equals(Material.WATER)) {
                Log.info("Cleaned item!");
                infectedItems.cleanItem(e.getItemDrop().getItemStack());
            }
        }, 20L);

        Inventory inventory = e.getPlayer().getInventory();
        for (ItemStack i : inventory.getContents()) {
            if (i != null && i.hasItemMeta()) {
                ItemMeta meta = i.getItemMeta();
                if (meta.hasLore()) {
                    for (String line : meta.getLore()) {
                        if(line.contains("infected:")) {
                            if(plugin.infectedChunks.getString("infectedArea." + line.replace("infected:", "") + ".type") == "PARASITE") {
                                e.getPlayer().setHealth(0.0);
                            }
                        }
                    }
                }
            }
        }
        return;
    }
}
