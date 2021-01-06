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
    private static Infected plugin = Infected.getPlugin();

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        Location location = e.getEntity().getLocation();
        if (e.getEntity().getKiller() == null) return;
        ItemMeta itemMeta = e.getEntity().getKiller().getItemInHand().getItemMeta();
        try {
            if (!itemMeta.getLore().contains(ChatColor.RED + "Dirtied.")) {
                ArrayList<String> lore = new ArrayList<String>();
                try {
                    lore.addAll(itemMeta.getLore());
                } catch (Exception exxx) {}
                lore.add(ChatColor.RED + "Dirtied.");
                itemMeta.setLore(lore);
                e.getEntity().getKiller().getItemInHand().setItemMeta(itemMeta);
            }
        } catch (NullPointerException er) {
            ArrayList<String> lore = new ArrayList<String>();

            lore.add(ChatColor.RED + "Dirtied.");
            itemMeta.setLore(lore);
            e.getEntity().getKiller().getItemInHand().setItemMeta(itemMeta);
        }
        Integer index = infectedItems.isLocationInInfectedArea(location);
        Log.info("Kill result: " + index);
        if (index != -1) {
            try {
                infectedItems.infectItem(e.getEntity().getKiller().getPlayer(), index);
            } catch (NullPointerException nullE) {
                Log.warn("Null Exception at entityDeath");
            }
        }
    }
}
