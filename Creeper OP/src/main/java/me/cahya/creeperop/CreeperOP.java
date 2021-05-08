package me.cahya.creeperop;

import me.cahya.creeperop.commandStart.start;
import me.cahya.creeperop.listeners.blowUp;
import org.bukkit.plugin.java.JavaPlugin;

public final class CreeperOP extends JavaPlugin {

    public boolean isStarted = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        new blowUp(this);
        getCommand("creeperOP").setExecutor(new start(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
