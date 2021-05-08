package me.cahya.chunkop.command;

import me.cahya.chunkop.ChunkOP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class start implements CommandExecutor {

    ChunkOP plugin;

    public start(ChunkOP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(!(args.length == 0)) {
                if (p.hasPermission("chunkop.toggle")) {
                    if(args[0].equalsIgnoreCase("random")) {
                        if(plugin.started && plugin.startedRandom) {
                            p.sendMessage(ChatColor.GOLD + "Already started!");
                            return false;
                        }
                        if(plugin.started && plugin.startedOP) {
                            p.sendMessage(ChatColor.GOLD + "Chunk OP is currently active! use " + ChatColor.AQUA + "/chunk stop " + ChatColor.GOLD + "to stop the plugin!");
                            return false;
                        }
                        plugin.started = true;
                        plugin.startedRandom = true;
                        Bukkit.broadcastMessage(ChatColor.GOLD + "Chunk Random plugin has started! Use " + ChatColor.AQUA + "/chunk stop " + ChatColor.GOLD + "to stop the plugin!");
                    } else if (args[0].equalsIgnoreCase("stop")) {
                        if(!plugin.started) {
                            p.sendMessage(ChatColor.GOLD + "Already off!");
                            return false;
                        }
                        plugin.started = false;
                        plugin.startedOP = false;
                        plugin.startedRandom = false;
                        Bukkit.broadcastMessage(ChatColor.GOLD + "Chunk OP plugin have been stopped!");
                    } else if (args[0].equalsIgnoreCase("op")) {
                        if(plugin.started && plugin.startedOP) {
                            p.sendMessage(ChatColor.GOLD + "Already started!");
                            return false;
                        }
                        if(plugin.started && plugin.startedRandom) {
                            p.sendMessage(ChatColor.GOLD + "Chunk Random is currently active! use " + ChatColor.AQUA + "/chunk stop " + ChatColor.GOLD + "to stop the plugin!");
                            return false;
                        }
                        plugin.started = true;
                        plugin.startedOP = true;
                        Bukkit.broadcastMessage(ChatColor.GOLD + "Chunk OP plugin has started! Use " + ChatColor.AQUA + "/chunk stop " + ChatColor.GOLD + "to stop the plugin!");
                    } else {
                        p.sendMessage(ChatColor.RED + "Invalid usage! Use /chunk <random/op>");
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "You do not have the permission to execute that command!");
                }
            } else {
                p.sendMessage(ChatColor.RED + "Invalid usage! Use /chunk <random/op>");
            }
        }
        return false;
    }
}
