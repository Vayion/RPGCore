package de.vayion.rpgcore.factionManagement;

import java.util.HashSet;

import org.bukkit.entity.Player;

import de.vayion.rpgcore.RPGCore;
import de.vayion.rpgcore.stats.StatContainer;

public class Faction {
    private HashSet<Player> players;
    private String name;
    private StatContainer modifiers;
    private RPGCore main;

    public Faction(RPGCore main, String name) {
        this.main = main;
        this.name = name;
    }

    public void addPlayer(Player player) {
        players.add(player);


    }

    public String getName() {
        return name;
    }
}
