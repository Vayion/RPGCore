package de.vayion.rpgcore.factionManagement;

import java.util.HashSet;

import org.bukkit.entity.Player;

import de.vayion.rpgcore.RPGCore;
import de.vayion.rpgcore.stats.StatContainer;

public class Faction extends StatContainer {
    private HashSet<Player> players;
    private String name;
    private RPGCore main;

    public Faction(RPGCore main, String name) {
        this.main = main;
        this.name = name;
        players = new HashSet<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public String getName() {
        return name;
    }
}
