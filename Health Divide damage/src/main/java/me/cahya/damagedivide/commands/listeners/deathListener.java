package me.cahya.damagedivide.commands.listeners;

import me.cahya.damagedivide.DamageDivide;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class deathListener implements Listener {
    DamageDivide plugin;

    public deathListener(DamageDivide plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if(plugin.started) {
            Player p = e.getEntity();

            for(Player players : Bukkit.getOnlinePlayers()) {
                players.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
                players.setHealth(20);
            }
            plugin.started = false;
            Bukkit.broadcastMessage(ChatColor.GOLD + "The challenge has ended because " + ChatColor.GREEN + p.getDisplayName() + ChatColor.RED + " died!");
        }
    }
}
