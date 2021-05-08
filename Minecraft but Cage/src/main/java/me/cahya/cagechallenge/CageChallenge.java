package me.cahya.cagechallenge;

import me.cahya.cagechallenge.commands.start;
import me.cahya.cagechallenge.runnable.timerDecrease;
import me.cahya.cagechallenge.runnable.timesUp;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class CageChallenge extends JavaPlugin {

    public boolean isStarted = false;
    public int timer = 299;
    public static Player player = null;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("cage").setExecutor(new start(this));
        BukkitTask timerDown = (new timerDecrease(this).runTaskTimer(this,0L, 20L));
        BukkitTask timerUp = (new timesUp(this).runTaskTimer(this, 20L, 20L));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
