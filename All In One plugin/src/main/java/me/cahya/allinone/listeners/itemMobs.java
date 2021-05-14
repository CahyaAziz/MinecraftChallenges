package me.cahya.allinone.listeners;

import me.cahya.allinone.AllInOne;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class itemMobs implements Listener {
    AllInOne plugin;

    public itemMobs(AllInOne plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDrop(EntityDeathEvent e) {
        if(plugin.startedItem) {
            int m = plugin.multiplier;
            List<ItemStack> drops = e.getDrops();
            Location loc = e.getEntity().getLocation();

            for(ItemStack items : drops) {
                for(int i=0; i < m*m; i++)
                    e.getEntity().getWorld().dropItem(loc, items);
            }
            plugin.multiplier++;
        }
    }
}
