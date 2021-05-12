package me.cahya.lavarun.commands;

import me.cahya.lavarun.LavaRun;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class toggle implements CommandExecutor {

    LavaRun plugin;

    public toggle(LavaRun plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("lavarun.toggle")) {
                if(!(args.length == 0)) {
                    if(args[0].equalsIgnoreCase("start")) {
                        if(plugin.started) {
                            p.sendMessage(ChatColor.AQUA + "Already started!");
                            return false;
                        }
                        plugin.started = true;
                        Bukkit.broadcastMessage(ChatColor.GOLD + "THE PLUGIN HAS STARTED!");
                    } else if(args[0].equalsIgnoreCase("stop")) {
                        if(!plugin.started) {
                            p.sendMessage(ChatColor.AQUA + "Already off!");
                            return false;
                        }
                        plugin.started = false;
                        Bukkit.broadcastMessage(ChatColor.GOLD + "THE PLUGIN HAVE BEEN STOPPED!");
                    } else {
                        p.sendMessage(ChatColor.RED + "Invalid usage! Use /lava <start/stop>");
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Invalid usage! Use /lava <start/stop>");
                }
            } else {
                p.sendMessage(ChatColor.RED + "You don't have the permission to execute that command!");
            }
        }


        return false;
    }
}
