package me.cahya.allinone.listeners;

import me.cahya.allinone.AllInOne;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class guiClick implements Listener {
    AllInOne plugin;

    public guiClick(AllInOne plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Plugins menu")) {
            if(e.getCurrentItem() == null) {
                return;
            }
            switch(e.getCurrentItem().getType()) {
                case GRASS_BLOCK:
                    if(plugin.startedRandom || plugin.startedOP || plugin.startedPots) {
                        p.sendMessage(ChatColor.RED + "You cannot do that!");
                    } else {
                        plugin.openChunkGUI(p);
                    }
                    break;
                case IRON_SWORD:
                    plugin.startedHalf = true;
                    plugin.guiState = false;
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        players.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(2147483647);
                        players.setHealth(2048);
                    }
                    Bukkit.broadcastMessage(ChatColor.AQUA + "Damage Half HP plugin has started!");
                    p.closeInventory();
                    break;
                case LAVA_BUCKET:
                    plugin.startedLava = true;
                    plugin.guiState = false;
                    Bukkit.broadcastMessage(ChatColor.AQUA + "Lava Fall plugin has started!");
                    p.closeInventory();
                    break;
                case JUNGLE_LOG:
                    plugin.startedItem = true;
                    plugin.guiState = false;
                    Bukkit.broadcastMessage(ChatColor.AQUA + "Item Multiply plugin has started!");
                    p.closeInventory();
                    break;
                case CREEPER_HEAD:
                    plugin.startedCreeper = true;
                    plugin.guiState = false;
                    Bukkit.broadcastMessage(ChatColor.AQUA + "Creeper OP plugin has started!");
                    p.closeInventory();
                    break;
                case IRON_BARS:
                    plugin.startedCage = true;
                    plugin.guiState = false;
                    Bukkit.broadcastMessage(ChatColor.AQUA + "Cage Challenge plugin has started!");
                    p.closeInventory();
                    break;
            }
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Chunk challenge type?")) {
            if(e.getCurrentItem() == null) {
                return;
            }
            switch(e.getCurrentItem().getType()) {
                case GRASS_BLOCK:
                    plugin.startedRandom = true;
                    plugin.guiState = false;
                    Bukkit.broadcastMessage(ChatColor.AQUA + "Chunk Random plugin has started!");
                    p.closeInventory();
                    break;
                case NETHERITE_CHESTPLATE:
                    plugin.startedOP = true;
                    plugin.guiState = false;
                    Bukkit.broadcastMessage(ChatColor.AQUA + "Chunk OP plugin has started!");
                    p.closeInventory();
                    break;
                case POTION:
                    plugin.startedPots = true;
                    plugin.guiState = false;
                    Bukkit.broadcastMessage(ChatColor.AQUA + "Chunk Pots plugin has started!");
                    p.closeInventory();
                    break;
            }
            e.setCancelled(true);
        }
    }
}
