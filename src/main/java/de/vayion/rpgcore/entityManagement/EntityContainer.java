package de.vayion.rpgcore.entityManagement;

import java.util.HashMap;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import de.vayion.rpgcore.RPGCore;
import de.vayion.rpgcore.playerManagement.PlayerWrapper;

public class EntityContainer {
    private HashMap<LivingEntity, EntityWrapper> container;
    private HashMap<String, EntityType> types;
    private RPGCore main;
    public EntityContainer(RPGCore main) {
        this.main = main;
        container = new HashMap<>();
    }
    public HashMap<LivingEntity, EntityWrapper> getContainer() {
        return container;
    }

    public EntityWrapper getWrapper(LivingEntity entity) {
        return container.get(entity);
    }
    public void add(EntityWrapper e) {
        container.put(e.getWrapped(),e);
    }
    public void remove(LivingEntity e) {
        container.remove(e);
    }

}
