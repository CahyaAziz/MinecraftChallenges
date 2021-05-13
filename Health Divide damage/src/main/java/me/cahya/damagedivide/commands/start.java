package me.cahya.damagedivide.commands;

import me.cahya.damagedivide.DamageDivide;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class start implements CommandExecutor {

    DamageDivide plugin;

    public start(DamageDivide plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("damagedivide.toggle")) {
                if(!(args.length == 0)) {
                    if(args[0].equalsIgnoreCase("start")) {
                        if(plugin.started) {
                            p.sendMessage(ChatColor.AQUA + "Already started!");
                            return false;
                        }
                        plugin.started = true;
                        for(Player players : Bukkit.getOnlinePlayers()) {
                            players.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(2147483647);
                            players.setHealth(2048);
                        }
                        Bukkit.broadcastMessage(ChatColor.GOLD + "THE CHALLENGE HAS STARTED!");
                    } else if(args[0].equalsIgnoreCase("stop")) {
                        if(!plugin.started) {
                            p.sendMessage(ChatColor.AQUA + "Already off!");
                            for(Player players : Bukkit.getOnlinePlayers()) {
                                players.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
                                players.setHealth(20);
                            }
                            return false;
                        }
                        plugin.started = false;
                        for(Player players : Bukkit.getOnlinePlayers()) {
                            players.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
                            players.setHealth(20);
                        }
                        Bukkit.broadcastMessage(ChatColor.GOLD + "THE CHALLENGE HAVE BEEN STOPPED!");
                    } else {
                        p.sendMessage(ChatColor.RED + "Invalid usage! Use /half <start/stop>");
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Invalid usage! Use /half <start/stop>");
                }
            } else {
                p.sendMessage(ChatColor.RED + "You don't have the permission to execute that command!");
            }
        }


        return false;
    }
}
