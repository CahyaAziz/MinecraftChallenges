package me.cahya.allinone;

import me.cahya.allinone.commands.guiCommand;
import me.cahya.allinone.listeners.*;
import me.cahya.allinone.runnables.cageTimer;
import me.cahya.allinone.runnables.lava;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;

public final class AllInOne extends JavaPlugin {
    public static Player player = null;

    public boolean guiState = true;
    public boolean startedOP = false;
    public boolean startedRandom = false;
    public boolean startedPots = false;
    public boolean startedHalf = false;
    public boolean startedLava = false;
    public boolean startedItem = false;
    public boolean startedCreeper = false;
    public boolean startedCage = false;
    public boolean allChunk = false;

    public int multiplier = 1;
    public int timerCage = 300;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new guiClick(this), this);
        getServer().getPluginManager().registerEvents(new chunkEvent(this), this);
        getServer().getPluginManager().registerEvents(new anvilFix(), this);
        getServer().getPluginManager().registerEvents(new hpHalf(this), this);
        getServer().getPluginManager().registerEvents(new deathListener(this), this);
        getServer().getPluginManager().registerEvents(new itemMobs(this), this);
        getServer().getPluginManager().registerEvents(new crashCheck(this), this);
        getServer().getPluginManager().registerEvents(new itemBlocks(this), this);
        getServer().getPluginManager().registerEvents(new creeper(this), this);

        BukkitTask lavaThing = (new lava(this).runTaskTimer(this, 0L, 10L));
        BukkitTask cageTime = (new cageTimer(this).runTaskTimer(this, 0L, 20L));

        getCommand("challenges").setExecutor(new guiCommand(this));

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        Bukkit.broadcastMessage(ChatColor.GOLD + "Thank you for downloading! Use " + ChatColor.AQUA + "/challenges " + ChatColor.GOLD + "to browse all the available challenges. " + ChatColor.LIGHT_PURPLE + "Made by CahyaAziz");
        Bukkit.broadcastMessage(ChatColor.GREEN + "The plugins original author are listed in each challenge respectively");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void openGUI(Player p) {
        Inventory gui = Bukkit.createInventory(p, 45, ChatColor.DARK_PURPLE + "Plugins menu");
        ItemStack chunk = new ItemStack(Material.GRASS_BLOCK);
        ItemStack half = new ItemStack(Material.IRON_SWORD);
        ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
        ItemStack items = new ItemStack(Material.JUNGLE_LOG);
        ItemStack creeper = new ItemStack(Material.CREEPER_HEAD);
        ItemStack cage = new ItemStack(Material.IRON_BARS);

        ItemMeta chunk_meta = chunk.getItemMeta();
        chunk_meta.setDisplayName(ChatColor.GREEN + "Chunk plugins");
        ArrayList<String> chunk_lore = new ArrayList<>();
        chunk_lore.add(ChatColor.DARK_PURPLE + "Minecraft, but chunks gives something...");
        chunk_lore.add(" ");
        chunk_lore.add(ChatColor.WHITE + "Chunk OP Original by: Quiff");
        chunk_lore.add(ChatColor.WHITE + "Chunk Pots Original by: Yahiamice");
        chunk_meta.setLore(chunk_lore);
        chunk.setItemMeta(chunk_meta);

        ItemMeta half_meta = half.getItemMeta();
        half_meta.setDisplayName(ChatColor.GREEN + "Every damage = divide health plugin");
        ArrayList<String> half_lore = new ArrayList<>();
        half_lore.add(ChatColor.DARK_PURPLE + "Minecraft, but every damage you take your health divides...");
        half_lore.add(" ");
        half_lore.add(ChatColor.WHITE + "Original by: TapL");
        half_meta.setLore(half_lore);
        half.setItemMeta(half_meta);

        ItemMeta lava_meta = lava.getItemMeta();
        lava_meta.setDisplayName(ChatColor.GREEN + "Lava fall plugin");
        ArrayList<String> lava_lore = new ArrayList<>();
        lava_lore.add(ChatColor.DARK_PURPLE + "Minecraft, but lava drops on you...");
        lava_lore.add(" ");
        lava_lore.add(ChatColor.WHITE + "Original by: TapL");
        lava_meta.setLore(lava_lore);
        lava.setItemMeta(lava_meta);

        ItemMeta items_meta = items.getItemMeta();
        items_meta.setDisplayName(ChatColor.GREEN + "Item Multiply plugin");
        ArrayList<String> items_lore = new ArrayList<>();
        items_lore.add(ChatColor.DARK_PURPLE + "Minecraft, but item drops are multiplied...");
        items_lore.add(" ");
        items_lore.add(ChatColor.WHITE + "Original by: Dream");
        items_meta.setLore(items_lore);
        items.setItemMeta(items_meta);

        ItemMeta creeper_meta = creeper.getItemMeta();
        creeper_meta.setDisplayName(ChatColor.GREEN + "Creeper OP plugin");
        ArrayList<String> creeper_lore = new ArrayList<>();
        creeper_lore.add(ChatColor.DARK_PURPLE + "Minecraft, but creeper explode into op blocks...");
        creeper_lore.add(" ");
        creeper_lore.add(ChatColor.WHITE + "Original by: GLAK JACK");
        creeper_meta.setLore(creeper_lore);
        creeper.setItemMeta(creeper_meta);

        ItemMeta cage_meta = cage.getItemMeta();
        cage_meta.setDisplayName(ChatColor.GREEN + "Cage Challenge plugin");
        ArrayList<String> cage_lore = new ArrayList<>();
        cage_lore.add(ChatColor.DARK_PURPLE + "Minecraft, but every 5 minutes you get trapped in a cage...");
        cage_meta.setLore(cage_lore);
        cage.setItemMeta(cage_meta);

        gui.addItem(chunk);
        gui.addItem(half);
        gui.addItem(lava);
        gui.addItem(items);
        gui.addItem(creeper);
        gui.addItem(cage);

        p.openInventory(gui);
    }
    public void openChunkGUI(Player p) {
        Inventory gui = Bukkit.createInventory(p, 9, ChatColor.DARK_PURPLE + "Chunk challenge type?");
        ItemStack random = new ItemStack(Material.GRASS_BLOCK);
        ItemStack op = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemStack pot = new ItemStack(Material.POTION);

        ItemMeta random_meta = random.getItemMeta();
        random_meta.setDisplayName(ChatColor.GREEN + "ChunkRandom");
        ArrayList<String> random_lore = new ArrayList<>();
        random_lore.add(ChatColor.DARK_PURPLE + "Minecraft, but chunks gives random items");
        random_meta.setLore(random_lore);
        random.setItemMeta(random_meta);

        ItemMeta op_meta = op.getItemMeta();
        op_meta.setDisplayName(ChatColor.GREEN + "ChunkOP");
        ArrayList<String> op_lore = new ArrayList<>();
        op_lore.add(ChatColor.DARK_PURPLE + "Minecraft, but chunks gives op items");
        op_meta.setLore(op_lore);
        op.setItemMeta(op_meta);

        ItemMeta pot_meta = pot.getItemMeta();
        pot_meta.setDisplayName(ChatColor.GREEN + "ChunkPots");
        ArrayList<String> pot_lore = new ArrayList<>();
        pot_lore.add(ChatColor.DARK_PURPLE + "Minecraft, but chunks gives random potion effects");
        pot_meta.setLore(pot_lore);
        pot.setItemMeta(pot_meta);

        gui.setItem(3, random);
        gui.setItem(4, op);
        gui.setItem(5, pot);

        p.openInventory(gui);
    }
}
