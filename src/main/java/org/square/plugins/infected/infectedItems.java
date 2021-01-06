package org.square.plugins.infected;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.square.plugins.infected.utils.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class infectedItems {
    private static Infected plugin = Infected.getPlugin();

    public static Integer locationToIndex (Location location) {
        Integer globalInfectionIndex = plugin.config.getInt("globalInfectionIndex");
        for (int i = 0; i < (globalInfectionIndex + 1); i++) {
            if (plugin.infectedChunks.getInt("infectedArea." + i + ".location.x") == location.getX() && plugin.infectedChunks.getInt("infectedArea." + i + ".location.z") == location.getZ()) {
                return i;
            }
        }
        return -1;
    }

    public static Integer isLocationInInfectedArea (Location location) {
        if (plugin.config.getInt("globalInfectionIndex") == 0) return -1;
        for (int i = 1; i < (plugin.config.getInt("globalInfectionIndex")); i++) {
                try {
                    double fx = plugin.infectedChunks.getInt("infectedArea." + i + ".location.x") - location.getX();
                    double sx = location.getX() - plugin.infectedChunks.getInt("infectedArea." + i + ".location.x");
                    double fz = plugin.infectedChunks.getInt("infectedArea." + i + ".location.z") - location.getZ();
                    double sz = location.getZ() - plugin.infectedChunks.getInt("infectedArea." + i + ".location.z");

                    if ((Math.abs(fx*sx)) <= 20 && (Math.abs(fz*sz)) <= 10) {
                            return i;
                    }
                } catch(Exception e) {
                    //if comparing between world and nether
                }
        }
        return -1;
    }
    public static void infectItem (Player player, Integer index) {
        if (player.getItemInHand().getType() == Material.AIR) {
            return;
        }
        Log.info("Infected!");
        ItemMeta itemMeta = player.getItemInHand().getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        try {
            lore.addAll(itemMeta.getLore());
        } catch (Exception exxx) {}
        lore.add("infected:" + index.toString());
        itemMeta.setLore(lore);
        player.getItemInHand().setItemMeta(itemMeta);
    }

    public static void cleanItem (ItemStack item) {
        if (item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            List<String> lore = null;
            try {
                meta.setLore(lore);
            } catch (Exception e) {}
        }
    }
}