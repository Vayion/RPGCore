package de.vayion.rpgcore.entityManagement;

import org.bukkit.entity.LivingEntity;

import de.vayion.rpgcore.stats.StatContainer;

public class EntityWrapper extends StatContainer {

    private final LivingEntity wrapped;

    private EntityWrapper() {
        wrapped = null;
    }

    public EntityWrapper(LivingEntity entity) {
        this.wrapped = entity;
        maxHealth = 200;
        setHealth(maxHealth);
        defense = 0;
    }


    public void damage(int damage, int piercing) {
        setHealth(health
                - (int) (damage *
                Double.max((8D - (Math.log((21D / 69) * (defense + (69D / 21))) / Math.log(2))) / 8D, 0.01D) *
                (armor <= piercing ? 1D : 0.5D)));
    }

    public void setHealth(int health) {
        this.health = health;
        wrapped.setHealth(Double.max(0, (double) health / maxHealth * wrapped.getMaxHealth()));
    }


    public LivingEntity getWrapped() {
        return wrapped;
    }

}
