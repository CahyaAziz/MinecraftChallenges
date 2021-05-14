package me.cahya.allinone.listeners;

import me.cahya.allinone.AllInOne;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class hpHalf implements Listener {
    AllInOne plugin;

    public hpHalf(AllInOne plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if(plugin.startedHalf) {
            if(e.getEntity().getType() == EntityType.PLAYER) {
                Player p = (Player) e.getEntity();

                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() / 2);
                    long heartcount = (long) players.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() / 2;
                    players.sendMessage(ChatColor.WHITE + "[" + ChatColor.LIGHT_PURPLE + "!" + ChatColor.WHITE + "]" + " " + ChatColor.GREEN + "You now have " + ChatColor.RED + heartcount + " ♥'s");
                }
            }
        }
    }
}
