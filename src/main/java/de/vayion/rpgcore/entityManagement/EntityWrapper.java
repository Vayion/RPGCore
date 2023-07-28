package de.vayion.rpgcore.entityManagement;

import org.bukkit.entity.LivingEntity;

import de.vayion.rpgcore.stats.StatContainer;

public class EntityWrapper extends StatContainer{

    private final LivingEntity wrapped;

    private EntityWrapper() {wrapped = null;}

    public EntityWrapper(LivingEntity entity) {
        this.wrapped = entity;
        maxHealth = 200;
        setHealth(maxHealth);
        defense = 0;
    }


    public void damage(int damage, int piercing) {
        setHealth(health
                -(int) (damage *
                Double.max((8D-(Math.log((21D/69)*(defense+(69D/21)))/Math.log(2)))/8D,0.01D)*
                (armor<=piercing?1D:0.5D)));
    }

    public void setHealth(int health) {
        this.health = health;
        wrapped.setHealth(Double.max(0,(double)health/maxHealth*wrapped.getMaxHealth()));
    }

    /*
     * setters
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }
    public void setFocus(int focus) {
        this.focus = focus;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setMaxhealth(int maxHealth) {
        maxHealth = maxHealth;
    }
    public void setPiercing(int piercing) {
        this.piercing = piercing;
    }
    public void setRejuvenate(int rejuvenate) {
        this.rejuvenate = rejuvenate;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /*
     * getters
     */

    public int getDamage() {
        return damage;
    }
    public int getArmor() {
        return armor;
    }
    public int getFocus() {
        return focus;
    }
    public int getMana() {
        return mana;
    }
    public int getMaxhealth() {
        return maxHealth;
    }
    public int getPiercing() {
        return piercing;
    }
    public int getRejuvenate() {
        return rejuvenate;
    }
    public int getSpeed() {
        return speed;
    }
    public int getDefense() {
        return defense;
    }
    public int getHealth() {
        return health;
    }

    public LivingEntity getWrapped() {
        return wrapped;
    }
    /*
     * adjusters
     */

    public void addDamage(int damage) {
        this.damage += damage;
    }
    public void addArmor(int armor) {
        this.armor += armor;
    }
    public void addFocus(int focus) {
        this.focus += focus;
    }
    public void addMana(int mana) {
        this.mana += mana;
    }
    public void addMaxhealth(int maxHealth) {
        this.maxHealth += maxHealth;
    }
    public void addPiercing(int piercing) {
        this.piercing += piercing;
    }
    public void addRejuvenate(int rejuvenate) {
        this.rejuvenate += rejuvenate;
    }
    public void addSpeed(int speed) {
        this.speed += speed;
    }
    public void addDefense(int defense) {
        this.defense += defense;
    }
}
