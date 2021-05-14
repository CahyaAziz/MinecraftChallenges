package me.cahya.allinone.listeners;

import me.cahya.allinone.AllInOne;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class itemBlocks implements Listener {
    AllInOne plugin;

    public itemBlocks(AllInOne plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if(plugin.startedItem) {
            Block b = e.getBlock();
            Location loc = b.getLocation();
            Material mats = b.getType();
            int m = plugin.multiplier;

            b.getWorld().dropItem(loc, new ItemStack(mats, m*m));
            plugin.multiplier++;
        }
    }
}
