package me.cahya.creeperop.listeners;

import me.cahya.creeperop.CreeperOP;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class blowUp implements Listener {

    CreeperOP plugin;

    public blowUp(CreeperOP plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onExplosion(EntityExplodeEvent e) {
        if (plugin.isStarted) {
            Creeper c = (Creeper) e.getEntity();
            List<Block> bl = e.blockList();
            Random rand = new Random();
            ArrayList<Material> mats = new ArrayList<>();
            mats.add(Material.COAL_BLOCK);
            mats.add(Material.COAL_BLOCK);
            mats.add(Material.COAL_BLOCK);
            mats.add(Material.COAL_BLOCK);
            mats.add(Material.COAL_BLOCK);
            mats.add(Material.IRON_BLOCK);
            mats.add(Material.IRON_BLOCK);
            mats.add(Material.IRON_BLOCK);
            mats.add(Material.IRON_BLOCK);
            mats.add(Material.EMERALD_BLOCK);
            mats.add(Material.EMERALD_BLOCK);
            mats.add(Material.EMERALD_BLOCK);
            mats.add(Material.GOLD_BLOCK);
            mats.add(Material.DIAMOND_BLOCK);

            Material rmat = mats.get(rand.nextInt(mats.size()));
            for (Block b : bl) {
                b.getLocation().getBlock().setType(rmat);
            }

            e.setCancelled(true);
        }
        
    }
}
