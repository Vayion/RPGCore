package de.vayion.rpgcore.items;

import java.util.HashMap;
import java.util.Objects;

import de.vayion.rpgcore.RPGCore;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ItemRegistry {
    private HashMap<Integer, CustomItem> map;
    private RPGCore main;
    public ItemRegistry(RPGCore main) {
        map = new HashMap<>();
        this.main = main;
    }

    public void add(ItemStack item, @NotNull CustomItem customItem){
        if(item == null){return;}
        map.put(item.hashCode(), customItem);
    }

    public CustomItem get(ItemStack item){
        if(item == null){
            return null;
        }
        CustomItem cItem = map.get(item.hashCode());
        if(cItem == null){
            // generate CustomItem from string
            return null;
        }
        else {
            return cItem;
        }
    }
}
