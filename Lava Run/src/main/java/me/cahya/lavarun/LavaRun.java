package me.cahya.lavarun;

import me.cahya.lavarun.commands.toggle;
import me.cahya.lavarun.runnable.lavaFall;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class LavaRun extends JavaPlugin {
    public boolean started = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("lava").setExecutor(new toggle(this));
        BukkitTask lavaThing = (new lavaFall(this).runTaskTimer(this, 0L, 10L));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
