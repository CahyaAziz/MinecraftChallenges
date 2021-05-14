package me.cahya.allinone.listeners;

import me.cahya.allinone.AllInOne;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class chunkEvent implements Listener {
    public HashMap<String, Chunk> pcl;

    public Material[] mats;
    public PotionEffectType[] pots;

    AllInOne plugin;

    public chunkEvent(AllInOne plugin) {
        this.plugin = plugin;
        this.pcl = new HashMap<String, Chunk>();
        this.mats = Material.values();
        this.pots = PotionEffectType.values();
    }

    @EventHandler
    public void onChunkEnter(PlayerMoveEvent e) {
        if(plugin.startedRandom) {
            Player p = e.getPlayer();
            String name = p.getName();
            Random rnd = new Random();
            Material rmat = this.mats[rnd.nextInt(this.mats.length)];

            if(pcl.get(name) != p.getLocation().getChunk()) {
                pcl.put(name, p.getLocation().getChunk());
                while(rmat.isAir() || !rmat.isItem() || rmat.name().contains("DEAD")) {
                    rmat = mats[rnd.nextInt(mats.length)];
                }
                p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(rmat));
            }
        }
        if(plugin.startedOP) {
            Player p = e.getPlayer();
            Location loc = p.getLocation();
            String name = p.getName();

            List<String> stuff = plugin.getConfig().getStringList("opitems");
            List<String> amount = plugin.getConfig().getStringList("amount");
            List<String> effects = plugin.getConfig().getStringList("effects");
            List<String> enchants = plugin.getConfig().getStringList("enchantslist");

            int min = 0;
            int max = stuff.size() - 1;
            double random = Math.random() * (max - min + 1) + min;
            int stackcount = Integer.parseInt(amount.get((int) random));
            ItemStack ritem = new ItemStack(Material.valueOf(stuff.get((int) random).toUpperCase()), stackcount);

            if(pcl.get(name) != p.getLocation().getChunk()) {
                pcl.put(name, p.getLocation().getChunk());
                if(ritem.getType() == Material.ENCHANTED_BOOK) {
                    ItemMeta book_meta = ritem.getItemMeta();
                    EnchantmentStorageMeta emeta = (EnchantmentStorageMeta) book_meta;
                    int emin = 0;
                    int emax = enchants.size() - 1;
                    double rench = Math.random() * (emax - emin + 1) + emin;
                    emeta.addStoredEnchant(Enchantment.getByKey(NamespacedKey.minecraft(enchants.get((int) rench).toLowerCase())), 10, true);
                    ritem.setItemMeta(emeta);
                }
                if(ritem.getType() == Material.POTION) {
                    ItemMeta pots_meta = ritem.getItemMeta();
                    PotionMeta pmeta = (PotionMeta) pots_meta;
                    int pmin = 0;
                    int pmax = effects.size() - 1;
                    double plevel = Math.random() * (pmax - pmin + 1) + pmin;
                    pmeta.addCustomEffect(new PotionEffect((PotionEffectType.getByName(effects.get((int) plevel).toUpperCase())), 1200, 2), true);
                    pmeta.setDisplayName("OP Potion");
                    pmeta.setColor(Color.YELLOW);
                    ritem.setItemMeta(pmeta);
                }
                p.getWorld().dropItemNaturally(p.getLocation(), ritem);
            }
        }
        if(plugin.startedPots) {
            Player p = e.getPlayer();
            String name = p.getName();
            Random rnd = new Random();
            PotionEffectType rpots = this.pots[rnd.nextInt(this.pots.length)];

            if (pcl.get(name) != p.getLocation().getChunk()) {
                pcl.put(name, p.getLocation().getChunk());
                p.addPotionEffect(new PotionEffect(rpots, 200, 5));
            }
        }
        if(plugin.allChunk) {
            Player p = e.getPlayer();
            String name = p.getName();
            Random rnd = new Random();
            Material rmat = this.mats[rnd.nextInt(this.mats.length)];
            Location loc = p.getLocation();
            PotionEffectType rpots = this.pots[rnd.nextInt(this.pots.length)];

            List<String> stuff = plugin.getConfig().getStringList("opitems");
            List<String> amount = plugin.getConfig().getStringList("amount");
            List<String> effects = plugin.getConfig().getStringList("effects");
            List<String> enchants = plugin.getConfig().getStringList("enchantslist");

            int min = 0;
            int max = stuff.size() - 1;
            double random = Math.random() * (max - min + 1) + min;
            int stackcount = Integer.parseInt(amount.get((int) random));
            ItemStack ritem = new ItemStack(Material.valueOf(stuff.get((int) random).toUpperCase()), stackcount);

            if(pcl.get(name) != p.getLocation().getChunk()) {
                pcl.put(name, p.getLocation().getChunk());
                while(rmat.isAir() || !rmat.isItem() || rmat.name().contains("DEAD")) {
                    rmat = mats[rnd.nextInt(mats.length)];
                }
                p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(rmat));
                if(ritem.getType() == Material.ENCHANTED_BOOK) {
                    ItemMeta book_meta = ritem.getItemMeta();
                    EnchantmentStorageMeta emeta = (EnchantmentStorageMeta) book_meta;
                    int emin = 0;
                    int emax = enchants.size() - 1;
                    double rench = Math.random() * (emax - emin + 1) + emin;
                    emeta.addStoredEnchant(Enchantment.getByKey(NamespacedKey.minecraft(enchants.get((int) rench).toLowerCase())), 10, true);
                    ritem.setItemMeta(emeta);
                }
                if(ritem.getType() == Material.POTION) {
                    ItemMeta pots_meta = ritem.getItemMeta();
                    PotionMeta pmeta = (PotionMeta) pots_meta;
                    int pmin = 0;
                    int pmax = effects.size() - 1;
                    double plevel = Math.random() * (pmax - pmin + 1) + pmin;
                    pmeta.addCustomEffect(new PotionEffect((PotionEffectType.getByName(effects.get((int) plevel).toUpperCase())), 1200, 2), true);
                    pmeta.setDisplayName("OP Potion");
                    pmeta.setColor(Color.YELLOW);
                    ritem.setItemMeta(pmeta);
                }
                p.getWorld().dropItemNaturally(p.getLocation(), ritem);
                p.addPotionEffect(new PotionEffect(rpots, 200, 5));
            }
        }
    }
}
