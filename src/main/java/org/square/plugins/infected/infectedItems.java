package org.square.plugins.infected;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import java.util.Set;


public class infectedItems {
    private static Infected plugin = Infected.getPlugin();

    public static String isPlayerInInfectedArea (Location location, String diseaseType) {
        if (plugin.config.getInt("globalInfectionIndex") == 0) return "null";
        for (int i = 0; i < (plugin.config.getInt("globalInfectionIndex") + 1); i++) {
            Location location2 = new Location(Bukkit.getWorld(plugin.infectedChunks.getString("infectedArea." + i + ".location.world")), plugin.infectedChunks.getInt("infectedArea." + i + ".location.x"), 0, plugin.infectedChunks.getInt("infectedArea." + i + ".location.z"));
            if (location.distance(location2) <= 20) {
                if (plugin.infectedChunks.getString("infectedArea." + i + ".type") == diseaseType || diseaseType == "") {
                    return String.valueOf(i);
                }
            }
        }
        return "null";
    }
    public static void infectItem (Player player, String disease) {
        if (player.getItemInHand().getType() == Material.AIR) {
            return;
        }

    }

    public static void cleanItem (Player player) {

    }
}
