package me.cahya.cagechallenge.commands;

import me.cahya.cagechallenge.CageChallenge;
import me.cahya.cagechallenge.runnable.timesUp;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class start implements CommandExecutor {



    CageChallenge plugin;

    public start(CageChallenge plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (!(args.length == 0)) {
                if (args[0].equals("start")) {
                    this.plugin.isStarted = true;
                    Bukkit.broadcastMessage(ChatColor.GOLD + "The challenge has STARTED!");
                } else if (args[0].equals("stop")) {
                    this.plugin.isStarted = false;
                    this.plugin.timer = 10;
                    Bukkit.broadcastMessage(ChatColor.GOLD + "The challenge has ENDED!");
                } else {
                    player.sendMessage(ChatColor.GOLD + "Use /cage <start/stop>");
                }

                CageChallenge.player = ((Player)sender);
            } else {
                player.sendMessage(ChatColor.GOLD + "Use /cage <start/stop>");
            }
        } else {
            sender.sendMessage("You cannot do that!");
        }

        return false;
    }

}


