package me.cahya.lavarun.runnable;

import me.cahya.lavarun.LavaRun;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class lavaFall extends BukkitRunnable {

    LavaRun plugin;

    public lavaFall(LavaRun plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        if(plugin.started) {
            for(Player p : Bukkit.getOnlinePlayers()) {

                p.getWorld().getBlockAt(p.getLocation().add(0,20,0)).setType(Material.LAVA);
            }
        }
    }
}
