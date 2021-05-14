package me.cahya.allinone.listeners;

import me.cahya.allinone.AllInOne;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class deathListener implements Listener {
    AllInOne plugin;

    public deathListener(AllInOne plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if(plugin.startedHalf) {
            Player p = e.getEntity();

            for(Player players : Bukkit.getOnlinePlayers()) {
                players.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
                players.setHealth(20);
            }
            plugin.startedHalf = false;
            plugin.guiState = true;
            Bukkit.broadcastMessage(ChatColor.GOLD + "Damage Half HP challenge has ended because " + ChatColor.GREEN + p.getDisplayName() + ChatColor.RED + " died!");
        }
        if(plugin.startedLava) {
            Player p = e.getEntity();

            plugin.startedLava = false;
            plugin.guiState = true;
            Bukkit.broadcastMessage(ChatColor.GOLD + "Lava Fall challenge has ended because " + ChatColor.GREEN + p.getDisplayName() + ChatColor.RED + " died!");
        }
    }
}
