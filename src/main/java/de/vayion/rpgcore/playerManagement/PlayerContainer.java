package de.vayion.rpgcore.playerManagement;

import java.util.HashMap;

import de.vayion.rpgcore.items.ItemRegistry;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import de.vayion.rpgcore.RPGCore;

public class PlayerContainer implements Listener {
    private HashMap<Player, PlayerWrapper> container;
    private ItemRegistry registry;
    RPGCore main;
    public PlayerContainer(RPGCore main) {
        this.main = main;
        container = new HashMap<>();
        registry = new ItemRegistry(main);
        main.getServer().getPluginManager().registerEvents(this, main);
    }


    public ItemRegistry getRegistry() {
        return registry;
    }

    public PlayerWrapper getWrapper(Player player) {
        return container.get(player);
    }
    public void add(PlayerWrapper p) {
        container.put((Player)p.getWrapped(),p);
    }
    public void remove(Player player) {
        container.remove(player);
    }
}
