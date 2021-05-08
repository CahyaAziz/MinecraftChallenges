package me.cahya.creeperop.commandStart;

import me.cahya.creeperop.CreeperOP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class start implements CommandExecutor {

    CreeperOP plugin;

    public start(CreeperOP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length != 1) {
                p.sendMessage(ChatColor.RED + "Invalid usage! Use /creeperOP <start/stop>");
                return false;
            }

            if(args[0].equalsIgnoreCase("start")) {
                if (p.hasPermission("creeperop.start")) {
                    if(plugin.isStarted) {
                        p.sendMessage(ChatColor.GOLD + "Already started!");
                        return false;
                    }
                    plugin.isStarted = true;
                    Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "Creeper OP plugin has started!");
                } else {
                    p.sendMessage(ChatColor.RED + "You do not have the permission to do that!");
                }
            } else if(args[0].equalsIgnoreCase("stop")) {
                if (p.hasPermission("creeperop.stop")) {
                    if(!plugin.isStarted) {
                        p.sendMessage(ChatColor.GOLD + "Already off!");
                        return false;
                    }
                    plugin.isStarted = false;
                    Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "Creeper OP plugin has been stopped!");
                } else {
                    p.sendMessage(ChatColor.RED + "You do not have the permission to do that!");
                }
            } else {
                p.sendMessage(ChatColor.RED + "Invalid usage! Use /creeperOP <start/stop>");
            }
        }
        return false;
    }
}
