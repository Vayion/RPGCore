package de.vayion.rpgcore.items;

import de.vayion.rpgcore.RPGCore;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import de.vayion.rpgcore.playerManagement.PlayerWrapper;
import de.vayion.rpgcore.stats.StatContainer;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomItem extends StatContainer implements Cloneable{
    private String id;
    private Material type;
    private String name;

    private String description;
    public static CustomItem readItemFrom(String input) {
        return null;
    }

    public ItemRegistry registry;

    public CustomItem(String name, String description, Material type, ItemRegistry reg){
        super();
        this.name = name;
        this.description = description;
        this.type = type;
        registry = reg;
    }

    private ItemStack item;

    public ItemStack getItem() {
        return item;
    }

    public void generateItem(){
        item = new ItemStack(type);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RESET+""+ChatColor.GOLD+name);
        List<String> lore = new ArrayList<>();
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        HashMap<TYPE, Integer> stats = toHashMap();
        stats.forEach((t, i) -> lore.add(ChatColor.RESET+t.toString()+": "+i));
        meta.setLore(lore);
        item.setItemMeta(meta);



        //just put at bottom
        registry.add(item, this);
    }



    //TODO make cloneable to avoid changed CustomItems to be represented by weaker ItemStacks
    @Override
    public CustomItem clone() {
        CustomItem output = new CustomItem(name, description, type, registry);
        return null;
    }
}
