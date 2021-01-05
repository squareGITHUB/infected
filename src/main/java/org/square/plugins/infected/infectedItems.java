package org.square.plugins.infected;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
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

    public static Integer isLocationInInfectedArea (Location location, String diseaseType) {
        if (plugin.config.getInt("globalInfectionIndex") == 0) return -1;
        for (int i = 0; i < (plugin.config.getInt("globalInfectionIndex") + 1); i++) {
            Location location2 = new Location(Bukkit.getWorld(plugin.infectedChunks.getString("infectedArea." + i + ".location.world")), plugin.infectedChunks.getInt("infectedArea." + i + ".location.x"), 0, plugin.infectedChunks.getInt("infectedArea." + i + ".location.z"));
            if (location.distance(location2) <= (20 * plugin.infectedChunks.getInt("infectedArea." + i + ".transmission"))) {
                if (plugin.infectedChunks.getString("infectedArea." + i + ".type") == diseaseType || diseaseType == "") {
                    return i;
                }
            }
        }
        return -1;
    }
    public static void infectItem (Player player, String disease, Integer index) {
        if (player.getItemInHand().getType() == Material.AIR) {
            return;
        }
        double chance = Math.random() * (5 - 1 + 1) + 1;
        if (chance == 1) {
            ItemMeta itemMeta = player.getItemInHand().getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.DARK_GRAY + "DiseaseIndex: " + index.toString());
            itemMeta.setLore(lore);

        }
    }

    public static void cleanItem (Player player) {

    }
}
