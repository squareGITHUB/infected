package org.square.plugins.infected;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Arrays;
import java.util.List;


public class infectedItems {
    private static Infected plugin = Infected.getPlugin();

    public static Location stringToLocation(String str){
        String str2loc[]=str.split("\\:");
        Location loc = new Location(Bukkit.getServer().getWorld(str2loc[0]),0,0,0);
        loc.setX(Double.parseDouble(str2loc[1]));
        loc.setY(Double.parseDouble(str2loc[2]));
        loc.setZ(Double.parseDouble(str2loc[3]));
        return loc;
    }

    public static boolean isPlayerInInfectedArea (Player player) {
        List<String> allCoordinates = plugin.infectedChunks.getStringList("infectedArea");
        for (String coordinate : allCoordinates) {
            Location location = stringToLocation(coordinate);
            // if (!player.getLocation().distanceSquared(location)); need to fix this
        }
        return true;
    }
    public static void infectItem (Player player, String disease) {
        if (player.getItemInHand().getType() == Material.AIR) {
            return;
        }

    }

    public static void cleanItem (Player player) {

    }
}
