package de.vayion.rpgcore.factionManagement;

import java.util.HashMap;

import org.bukkit.entity.Player;

import de.vayion.rpgcore.RPGCore;
import de.vayion.rpgcore.playerManagement.PlayerWrapper;

public class FactionContainer {
    private HashMap<String, Faction> container;
    private RPGCore main;
    public FactionContainer(RPGCore main) {
        this.main = main;
        container = new HashMap<>();
    }

    public Faction getWrapper(String name) {
        return container.get(name);
    }

    public void add(Faction faction) {
        container.put(faction.getName(), faction);
    }

    public void newFaction(String name) {
        container.put(name, new Faction(main, name));
    }

    public void remove(Faction faction) {
        container.remove(faction.getName());
    }
}
