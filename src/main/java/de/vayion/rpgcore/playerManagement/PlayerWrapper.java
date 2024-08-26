package de.vayion.rpgcore.playerManagement;

import org.bukkit.entity.Player;

import de.vayion.rpgcore.entityManagement.EntityWrapper;
import de.vayion.rpgcore.factionManagement.Faction;

public class PlayerWrapper extends EntityWrapper{

    private Faction faction;
    private PlayerContainer container;

    public PlayerWrapper(Player player, PlayerContainer container) {
        super(player);
        this.container = container;
    }
    /*
    public void setFaction(Faction faction) {
        this.faction = faction;
    }
     */
}
