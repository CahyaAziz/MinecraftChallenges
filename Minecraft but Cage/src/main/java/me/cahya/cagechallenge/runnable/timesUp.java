package me.cahya.cagechallenge.runnable;

import me.cahya.cagechallenge.CageChallenge;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class timesUp extends BukkitRunnable {
    public HashMap<String, Location> plo;

    CageChallenge plugin;

    public timesUp(CageChallenge plugin) {
        this.plugin = plugin;
        this.plo = new HashMap<String, Location>();
    }


    @Override
    public void run() {

        if (this.plugin.isStarted && this.plugin.timer == 0) {

            for (Player player : Bukkit.getOnlinePlayers()) {
                Player p = CageChallenge.player;
                WorldBorder wb = p.getWorld().getWorldBorder();
                if (player != p) {
                    player.teleport(p.getLocation());
                }

                wb.setCenter(p.getLocation());
                wb.setSize(20.0);


                Random rand = new Random();
                int mobType = rand.nextInt(6) + 1;
                for (int m = 1; m <= 10; m++) {
                    switch (mobType) {
                        case 1:
                            player.getWorld().spawnEntity(player.getLocation().add(5,0,0), EntityType.ZOMBIE);
                            break;
                        case 2:
                            player.getWorld().spawnEntity(player.getLocation().add(5,0,0), EntityType.SKELETON);
                            break;
                        case 3:
                            player.getWorld().spawnEntity(player.getLocation().add(5,0,0), EntityType.ENDERMAN);
                            break;
                        case 4:
                            player.getWorld().spawnEntity(player.getLocation().add(5,0,0), EntityType.SPIDER);
                            break;
                        case 5:
                            player.getWorld().spawnEntity(player.getLocation().add(5,0,0), EntityType.CAVE_SPIDER);
                            break;
                        case 6:
                            player.getWorld().spawnEntity(player.getLocation().add(5,0,0), EntityType.PILLAGER);
                            break;
                        case 7:
                            player.getWorld().spawnEntity(player.getLocation().add(5,0,0), EntityType.VINDICATOR);
                            break;
                    }
                }


            }




            this.plugin.timer = 300;
        }

        if(this.plugin.isStarted && this.plugin.timer == 240) {
            Player p = CageChallenge.player;
            WorldBorder wb = p.getWorld().getWorldBorder();

            wb.reset();
        }
    }
}