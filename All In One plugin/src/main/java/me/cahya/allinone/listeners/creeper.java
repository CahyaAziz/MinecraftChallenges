package me.cahya.allinone.listeners;

import me.cahya.allinone.AllInOne;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class creeper implements Listener {

    AllInOne plugin;

    public creeper(AllInOne plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onExplosion(EntityExplodeEvent e) {
        if (plugin.startedCreeper) {
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
