package de.vayion.rpgcore;

import de.vayion.rpgcore.items.ItemRegistry;
import org.bukkit.entity.Item;
import org.bukkit.plugin.java.JavaPlugin;

import de.vayion.rpgcore.commands.DebugCmd;
import de.vayion.rpgcore.entityManagement.EntityContainer;
import de.vayion.rpgcore.listeners.CombatListeners;
import de.vayion.rpgcore.listeners.ConnectionListeners;
import de.vayion.rpgcore.playerManagement.PlayerContainer;

public final class RPGCore extends JavaPlugin {
    private PlayerContainer playerContainer;
    private EntityContainer entityContainer;
    private ItemRegistry itemRegistry;


    @Override
    public void onEnable() {
        playerContainer = new PlayerContainer(this);
        entityContainer = new EntityContainer(this);
        itemRegistry = new ItemRegistry(this);
        this.getCommand("debug").setExecutor(new DebugCmd(this));
        new ConnectionListeners(this);
        new CombatListeners(this);
    }


    public ItemRegistry getItemRegistry() {
        return itemRegistry;
    }

    public PlayerContainer getPlayerContainer() {
        return playerContainer;
    }
    public EntityContainer getEntityContainer() {
        return entityContainer;
    }
}
