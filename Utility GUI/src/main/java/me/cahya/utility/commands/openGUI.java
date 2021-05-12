package me.cahya.utility.commands;

import me.cahya.utility.Utility;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class openGUI implements CommandExecutor {

    Utility plugin;

    public openGUI(Utility plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            plugin.openGUI(p);
        }
        return false;
    }
}
