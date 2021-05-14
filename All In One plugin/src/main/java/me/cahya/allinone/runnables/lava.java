package me.cahya.allinone.runnables;

import me.cahya.allinone.AllInOne;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class lava extends BukkitRunnable {
    AllInOne plugin;

    public lava(AllInOne plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        if(plugin.startedLava) {
            for(Player p : Bukkit.getOnlinePlayers()) {

                p.getWorld().getBlockAt(p.getLocation().add(0,20,0)).setType(Material.LAVA);
            }
        }
    }
}
