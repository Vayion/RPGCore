package de.vayion.rpgcore.playerManagement;

import org.bukkit.entity.Player;

import de.vayion.rpgcore.entityManagement.EntityWrapper;
import de.vayion.rpgcore.factionManagement.Faction;

public class PlayerWrapper extends EntityWrapper{

    private Faction faction;

    public PlayerWrapper(Player player) {
        super(player);
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }
}
