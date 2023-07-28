package de.vayion.rpgcore.items;

import java.util.HashMap;

import de.vayion.rpgcore.RPGCore;

public class ItemRegistry {
    private HashMap<String, CustomItem> map;
    private RPGCore main;
    public ItemRegistry(RPGCore main) {
        map = new HashMap<>();
        this.main = main;
    }
}
