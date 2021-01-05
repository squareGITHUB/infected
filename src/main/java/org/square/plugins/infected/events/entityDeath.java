package org.square.plugins.infected.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.square.plugins.infected.Infected;
import org.square.plugins.infected.infectedItems;
import org.square.plugins.infected.utils.Log;

import java.util.ArrayList;
import java.util.Objects;

public class entityDeath implements Listener {
    private Infected plugin;
    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        Location location = e.getEntity().getLocation();
        Integer index = infectedItems.isLocationInInfectedArea(location, "");
        if (index != -1) {
            try {
                ItemMeta itemMeta = e.getEntity().getKiller().getPlayer().getItemInHand().getItemMeta();
                if (!itemMeta.getLore().contains(ChatColor.RED + "Dirtied.")) {
                    ArrayList<String> lore = new ArrayList<String>();
                    lore.add(ChatColor.RED + "Dirtied.");
                    itemMeta.setLore(lore);
                }
                infectedItems.infectItem(Objects.requireNonNull(e.getEntity().getKiller().getPlayer()), plugin.infectedChunks.getString("infectedArea." + index.toString() + ".type"), index);
            } catch (NullPointerException nullE) {
                Log.warn("Null Exception at entityDeath");
            }
        }
    }
}
