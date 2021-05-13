package me.cahya.chunkpots.listeners;

import me.cahya.chunkpots.ChunkPots;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Random;

public class chunkGiver implements Listener {
    public HashMap<String, Chunk> pcl;
    public PotionEffectType[] pots;

    ChunkPots plugin;

    public chunkGiver(ChunkPots plugin) {
        this.plugin = plugin;
        this.pcl = new HashMap<String, Chunk>();
        this.pots = PotionEffectType.values();
    }

    @EventHandler
    public void onEnterChunk(PlayerMoveEvent e) {
        if(plugin.started) {
            Player p = e.getPlayer();
            String name = p.getName();
            Random rnd = new Random();
            PotionEffectType rpots = this.pots[rnd.nextInt(this.pots.length)];

            if (pcl.get(name) != p.getLocation().getChunk()) {
                pcl.put(name, p.getLocation().getChunk());
                p.addPotionEffect(new PotionEffect(rpots, 200, 5));
            }
        }
    }
}
