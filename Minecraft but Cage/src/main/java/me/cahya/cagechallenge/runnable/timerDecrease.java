package me.cahya.cagechallenge.runnable;

import me.cahya.cagechallenge.CageChallenge;
import org.bukkit.scheduler.BukkitRunnable;

public class timerDecrease extends BukkitRunnable {

    CageChallenge plugin;

    public timerDecrease(CageChallenge plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {

        if(this.plugin.isStarted && this.plugin.timer > 0) {
            --this.plugin.timer;
        }

    }
}
