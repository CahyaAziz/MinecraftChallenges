package me.cahya.utility;

import me.cahya.utility.commands.openGUI;
import me.cahya.utility.listeners.clickEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Utility extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("utils").setExecutor(new openGUI(this));
        getServer().getPluginManager().registerEvents(new clickEvent(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void openGUI(Player p) {
        Inventory gui = Bukkit.createInventory(p, 9, ChatColor.DARK_PURPLE + "Utility Menu");
        ItemStack hp = new ItemStack(Material.GOLDEN_APPLE);
        ItemStack food = new ItemStack(Material.COOKED_BEEF);
        ItemStack kick = new ItemStack(Material.DIAMOND_BOOTS);
        ItemStack ban = new ItemStack(Material.BARRIER);
        ItemStack filler = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemStack survival = new ItemStack(Material.CRAFTING_TABLE);

        ItemMeta hp_meta = hp.getItemMeta();
        hp_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Heal");
        ArrayList<String> hp_lore = new ArrayList<>();
        hp_lore.add(ChatColor.DARK_PURPLE + "Heal targeted player to full HP");
        hp_meta.setLore(hp_lore);
        hp.setItemMeta(hp_meta);

        ItemMeta food_meta = food.getItemMeta();
        food_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Feed");
        ArrayList<String> food_lore = new ArrayList<>();
        food_lore.add(ChatColor.DARK_PURPLE + "Feed targeted player");
        food_meta.setLore(food_lore);
        food.setItemMeta(food_meta);

        ItemMeta kick_meta = kick.getItemMeta();
        kick_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Kick");
        ArrayList<String> kick_lore = new ArrayList<>();
        kick_lore.add(ChatColor.DARK_PURPLE + "Kick targeted player from the server");
        kick_meta.setLore(kick_lore);
        kick.setItemMeta(kick_meta);

        ItemMeta ban_meta = ban.getItemMeta();
        ban_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Ban");
        ArrayList<String> ban_lore = new ArrayList<>();
        ban_lore.add(ChatColor.DARK_PURPLE + "Ban targeted player from the server");
        ban_meta.setLore(ban_lore);
        ban.setItemMeta(ban_meta);

        ItemMeta survival_meta = survival.getItemMeta();
        survival_meta.setDisplayName(ChatColor.YELLOW + "Set gamemode to survival");
        survival.setItemMeta(survival_meta);

        ItemMeta fill = filler.getItemMeta();
        fill.setDisplayName(" ");
        filler.setItemMeta(fill);

        gui.setItem(0, hp);
        gui.setItem(1, food);
        gui.setItem(2, survival);
        gui.setItem(3, filler);
        gui.setItem(4, filler);
        gui.setItem(5, filler);
        gui.setItem(6, filler);
        gui.setItem(7, kick);
        gui.setItem(8, ban);

        p.openInventory(gui);
    }
    public void openKickGUI(Player p) {

        ArrayList<Player> player_list = new ArrayList<>(p.getServer().getOnlinePlayers());
        Inventory kickgui = Bukkit.createInventory(p, 45, ChatColor.DARK_PURPLE + "Kick Menu");

        for(int i = 0;i < player_list.size(); i++) {
            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            ItemMeta meta = head.getItemMeta();
            meta.setDisplayName(player_list.get(i).getDisplayName());
            head.setItemMeta(meta);

            kickgui.addItem(head);
        }
        p.openInventory(kickgui);
    }
    public void openConfirmKick(Player p, Player playerToKick) {
        Inventory confirmKick = Bukkit.createInventory(p, 9, ChatColor.DARK_PURPLE + "Confirm kick?");
        ItemStack yes = new ItemStack(Material.GREEN_CONCRETE);
        ItemStack no = new ItemStack(Material.BARRIER);
        ItemStack player = new ItemStack(Material.PLAYER_HEAD);

        ItemMeta yes_meta = yes.getItemMeta();
        yes_meta.setDisplayName(ChatColor.GREEN + "Yes");
        yes.setItemMeta(yes_meta);

        ItemMeta no_meta = no.getItemMeta();
        no_meta.setDisplayName(ChatColor.RED + "Cancel");
        no.setItemMeta(no_meta);

        ItemMeta player_meta = player.getItemMeta();
        player_meta.setDisplayName(playerToKick.getDisplayName());
        player.setItemMeta(player_meta);

        confirmKick.setItem(0, yes);
        confirmKick.setItem(4, player);
        confirmKick.setItem(8, no);

        p.openInventory(confirmKick);
    }
    public void openBanGUI(Player p) {

        ArrayList<Player> player_list = new ArrayList<>(p.getServer().getOnlinePlayers());
        Inventory bangui = Bukkit.createInventory(p, 45, ChatColor.DARK_PURPLE + "Ban Menu");

        for(int i = 0;i < player_list.size(); i++) {
            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            ItemMeta meta = head.getItemMeta();
            meta.setDisplayName(player_list.get(i).getDisplayName());
            head.setItemMeta(meta);

            bangui.addItem(head);
        }
        p.openInventory(bangui);
    }
    public void openConfirmBan(Player p, Player playerToBan) {
        Inventory confirmBan = Bukkit.createInventory(p, 9, ChatColor.DARK_PURPLE + "Confirm ban?");
        ItemStack yes = new ItemStack(Material.GREEN_CONCRETE);
        ItemStack no = new ItemStack(Material.BARRIER);
        ItemStack player = new ItemStack(Material.PLAYER_HEAD);

        ItemMeta yes_meta = yes.getItemMeta();
        yes_meta.setDisplayName(ChatColor.GREEN + "Yes");
        yes.setItemMeta(yes_meta);

        ItemMeta no_meta = no.getItemMeta();
        no_meta.setDisplayName(ChatColor.RED + "Cancel");
        no.setItemMeta(no_meta);

        ItemMeta player_meta = player.getItemMeta();
        player_meta.setDisplayName(playerToBan.getDisplayName());
        player.setItemMeta(player_meta);

        confirmBan.setItem(0, yes);
        confirmBan.setItem(4, player);
        confirmBan.setItem(8, no);

        p.openInventory(confirmBan);
    }
    public void openGamemode(Player p) {

        ArrayList<Player> player_list = new ArrayList<>(p.getServer().getOnlinePlayers());
        Inventory gm = Bukkit.createInventory(p, 45, ChatColor.DARK_PURPLE + "Set Gamemode");

        for(int i = 0;i < player_list.size(); i++) {
            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            ItemMeta meta = head.getItemMeta();
            meta.setDisplayName(player_list.get(i).getDisplayName());
            head.setItemMeta(meta);

            gm.addItem(head);
        }
        p.openInventory(gm);
    }
}
