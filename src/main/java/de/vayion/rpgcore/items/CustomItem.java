package de.vayion.rpgcore.items;

import org.bukkit.Material;

import de.vayion.rpgcore.playerManagement.PlayerWrapper;
import de.vayion.rpgcore.stats.StatContainer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;

public class CustomItem extends StatContainer {
    private String id;
    private Material type;
    private String name;

    private String description;
    public static CustomItem readItemFrom(String input) {
        return null;
    }

    private ItemStack item;

    public void generateItem(){
        item = new ItemStack(type);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        List<String> lore = meta.getLore();
        lore.add(description);
        HashMap<TYPE, Integer> stats = toHashMap();
        stats.forEach((t, i) -> lore.add(t.toString()+": "+i));
        meta.setLore(lore);
        item.setItemMeta(meta);
    }


}
