package me.cahya.chunkop;

import me.cahya.chunkop.command.start;
import me.cahya.chunkop.listeners.AnvilFix;
import me.cahya.chunkop.listeners.chunkEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChunkOP extends JavaPlugin {

    public boolean started = false;
    public boolean startedRandom = false;
    public boolean startedOP = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new chunkEvent(this), this);
        getServer().getPluginManager().registerEvents(new AnvilFix(), this);
        getCommand("chunk").setExecutor(new start(this));
        getConfig().options().copyDefaults();
        saveDefaultConfig();


        Bukkit.broadcastMessage(ChatColor.GOLD + "Thank you for downloading ChunkOP plugin made by " + ChatColor.RED + "Cahya! " + ChatColor.AQUA + "Use /chunk <random/op> to pick the type of the plugin!");
        for (Player people : Bukkit.getOnlinePlayers()) {
            people.sendMessage(ChatColor.GOLD + "Thank you for downloading ChunkOP plugin made by " + ChatColor.RED + "Cahya! " + ChatColor.AQUA + "Use /chunk <random/op> to pick the type of the plugin!");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
