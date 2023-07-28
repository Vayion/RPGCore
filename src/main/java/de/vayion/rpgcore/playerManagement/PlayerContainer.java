package de.vayion.rpgcore.playerManagement;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import de.vayion.rpgcore.RPGCore;

public class PlayerContainer implements Listener {
    private HashMap<Player, PlayerWrapper> container;
    RPGCore main;
    public PlayerContainer(RPGCore main) {
        this.main = main;
        container = new HashMap<>();
        main.getServer().getPluginManager().registerEvents(this, main);
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
