package de.vayion.rpgcore;

import org.bukkit.plugin.java.JavaPlugin;

import de.vayion.rpgcore.commands.DebugCmd;
import de.vayion.rpgcore.entityManagement.EntityContainer;
import de.vayion.rpgcore.listeners.CombatListeners;
import de.vayion.rpgcore.listeners.ConnectionListeners;
import de.vayion.rpgcore.playerManagement.PlayerContainer;

public final class RPGCore extends JavaPlugin {
    private PlayerContainer playerContainer;
    private EntityContainer entityContainer;


    @Override
    public void onEnable() {
        playerContainer = new PlayerContainer(this);
        entityContainer = new EntityContainer(this);
        this.getCommand("debug").setExecutor(new DebugCmd(this));
        new ConnectionListeners(this);
        new CombatListeners(this);
    }

    public PlayerContainer getPlayerContainer() {
        return playerContainer;
    }
    public EntityContainer getEntityContainer() {
        return entityContainer;
    }
}
