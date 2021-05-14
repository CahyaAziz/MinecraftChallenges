package me.cahya.allinone.listeners;

import me.cahya.allinone.AllInOne;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class crashCheck implements Listener {
    AllInOne plugin;

    public crashCheck(AllInOne plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        if(plugin.startedItem) {
            Player p = e.getPlayer();
            for(Entity item : p.getWorld().getEntities()) {
                if(item instanceof Item) {
                    item.remove();
                }
            }
            plugin.startedItem = false;
            plugin.guiState = true;
            Bukkit.broadcastMessage(ChatColor.GOLD + "Item Multiply challenge has stopped because " + ChatColor.AQUA +  p.getDisplayName() + ChatColor.GOLD + " left/crashed...");
        }
    }
}
