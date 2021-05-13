package me.cahya.damagedivide;

import me.cahya.damagedivide.commands.listeners.damageHalf;
import me.cahya.damagedivide.commands.listeners.deathListener;
import me.cahya.damagedivide.commands.start;
import org.bukkit.plugin.java.JavaPlugin;

public final class DamageDivide extends JavaPlugin {
    public boolean started = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new damageHalf(this), this);
        getServer().getPluginManager().registerEvents(new deathListener(this), this);

        getCommand("half").setExecutor(new start(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
