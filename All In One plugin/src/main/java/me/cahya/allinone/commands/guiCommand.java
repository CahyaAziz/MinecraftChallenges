package me.cahya.allinone.commands;

import me.cahya.allinone.AllInOne;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

public class guiCommand implements CommandExecutor {
    AllInOne plugin;

    public guiCommand(AllInOne plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("challenges.toggle")) {
                if (args.length == 0) {
                    if (plugin.guiState) {
                        plugin.openGUI(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "There's a challenge already running... use " + ChatColor.AQUA + "/challenges stop " + ChatColor.RED + "to stop all the challenges! If you want to run multiple challenges at once, do " + ChatColor.AQUA + "/challenges bypass " + ChatColor.RED + "(Keep in mind that there might be bugs)");
                    }
                    AllInOne.player = ((Player) sender);
                } else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("stop")) {
                        if (!plugin.guiState) {
                            plugin.guiState = true;
                            plugin.startedOP = false;
                            plugin.startedRandom = false;
                            plugin.startedPots = false;
                            plugin.startedHalf = false;
                            plugin.startedLava = false;
                            plugin.startedItem = false;
                            plugin.startedCreeper = false;
                            plugin.startedCage = false;
                            plugin.allChunk = false;

                            plugin.timerCage = 300;
                            plugin.multiplier = 1;
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
                                players.setHealth(20);
                            }
                            for (Entity item : p.getWorld().getEntities()) {
                                if (item instanceof Item) {
                                    item.remove();
                                }
                            }
                            Bukkit.broadcastMessage(ChatColor.GOLD + "All challenges have been stopped by " + ChatColor.AQUA + p.getDisplayName());
                        }
                    } else if (args[0].equalsIgnoreCase("bypass")) {
                        plugin.openGUI(p);
                    } else if (args[0].equalsIgnoreCase("all")) {
                        if (!plugin.guiState) {
                            p.sendMessage(ChatColor.RED + "Do " + ChatColor.AQUA + "/challenges stop " + ChatColor.GOLD + " first...");
                            return false;
                        }
                        Bukkit.broadcastMessage(ChatColor.GOLD + "ALL CHALLENGES HAVE BEEN ENABLED! (May cause bugs)");
                        plugin.guiState = false;
                        plugin.startedHalf = true;
                        plugin.startedLava = true;
                        plugin.startedItem = true;
                        plugin.startedCreeper = true;
                        plugin.startedCage = true;
                        plugin.allChunk = true;

                        plugin.timerCage = 300;
                        plugin.multiplier = 1;
                    } else {
                        p.sendMessage(ChatColor.RED + "Invalid usage! Use /challenges <bypass/stop/all>");
                    }
                }
            } else {
                p.sendMessage(ChatColor.RED + "You do not have the permission to execute this command!");
            }
        }
        return false;
    }
}
