package me.cahya.chunkpots;

import me.cahya.chunkpots.commands.start;
import me.cahya.chunkpots.listeners.chunkGiver;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChunkPots extends JavaPlugin {
    public boolean started = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new chunkGiver(this), this);

        getCommand("cp").setExecutor(new start(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
