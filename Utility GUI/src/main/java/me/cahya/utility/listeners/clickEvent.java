package me.cahya.utility.listeners;

import me.cahya.utility.Utility;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class clickEvent implements Listener {

    Utility plugin;

    public clickEvent(Utility plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Utility Menu")) {
            if(e.getCurrentItem() == null) {
                return;
            }
            switch(e.getCurrentItem().getType()) {
                case GOLDEN_APPLE:
                    p.setHealth(20);
                    p.sendMessage(ChatColor.GOLD + "You have been healed to full HP!");
                    p.closeInventory();
                    break;
                case COOKED_BEEF:
                    p.setFoodLevel(20);
                    p.sendMessage(ChatColor.GOLD + "You have been fed!");
                    p.closeInventory();
                    break;
                case CRAFTING_TABLE:
                    plugin.openGamemode(p);
                    break;
                case BARRIER:
                    plugin.openBanGUI(p);
                    break;
                case DIAMOND_BOOTS:
                    break;
            }
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Ban Menu")) {
            if(e.getCurrentItem() == null) {
                return;
            }
            if(e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                Player whoToBan = p.getServer().getPlayer(e.getCurrentItem().getItemMeta().getDisplayName());
                plugin.openConfirmBan(p, whoToBan);
            }
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Confirm ban?")) {
            if(e.getCurrentItem() == null) {
                return;
            }
            switch(e.getCurrentItem().getType()) {
                case GREEN_CONCRETE:
                    String name = e.getInventory().getItem(4).getItemMeta().getDisplayName();
                    p.getServer().getBanList(BanList.Type.NAME).addBan(name, "Banned by an operator", null, "Operator");
                    p.sendMessage("You have banned " + name + " from the server");
                    p.closeInventory();
                    break;
                case BARRIER:
                    plugin.openGUI(p);
                    break;
                case AIR:
                    break;
            }
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Set Gamemode")) {
            if(e.getCurrentItem() == null) {
                return;
            }
            if(e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                Player name = p.getServer().getPlayer(e.getCurrentItem().getItemMeta().getDisplayName());
                name.setGameMode(GameMode.SURVIVAL);
                p.closeInventory();
            }
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Kick Menu")) {
            if(e.getCurrentItem() == null) {
                return;
            }
            if(e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                Player whoToKick = p.getServer().getPlayer(e.getCurrentItem().getItemMeta().getDisplayName());
                plugin.openConfirmKick(p, whoToKick);
            }
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Confirm kick?")) {
            if(e.getCurrentItem() == null) {
                return;
            }
            switch(e.getCurrentItem().getType()) {
                case GREEN_CONCRETE:
                    Player name = p.getServer().getPlayer(e.getInventory().getItem(4).getItemMeta().getDisplayName());
                    name.kickPlayer("You have been kicked by an operator!");
                    p.sendMessage(ChatColor.GOLD + "You have kicked " + name + " from the server!");
                    p.closeInventory();
                    break;
                case BARRIER:
                    plugin.openGUI(p);
                    break;
            }
        }
    }
}
