package de.vayion.rpgcore.stats;

import de.vayion.rpgcore.entityManagement.EntityType;

import java.util.HashMap;

public abstract class StatContainer {

    public enum TYPE {Health, Defense, Speed, Armor, Piercing, Mana, Rejuvenate, Damage, Focus};

    protected int
            maxHealth,
            health,
            defense,
            speed,
            armor,
            piercing,
            mana,
            rejuvenate,
            damage,
            maxMana,
            focus;


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
        this.maxHealth = maxHealth;
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

    public static void subtractStats(StatContainer arg1, StatContainer arg2) {
        arg1.maxHealth -= arg2.maxHealth;
        arg1.defense -= arg2.defense;
        arg1.speed -= arg2.speed;
        arg1.armor -= arg2.armor;
        arg1.piercing -= arg2.piercing;
        arg1.maxMana -= arg2.maxMana;
        arg1.rejuvenate -= arg2.rejuvenate;
        arg1.damage -= arg2.damage;
        arg1.maxMana -= arg2.maxMana;
        arg1.focus -= arg2.focus;
    }

    public static void addStats(StatContainer arg1, StatContainer arg2) {
        arg1.maxHealth += arg2.maxHealth;
        arg1.defense += arg2.defense;
        arg1.speed += arg2.speed;
        arg1.armor += arg2.armor;
        arg1.piercing += arg2.piercing;
        arg1.maxMana += arg2.maxMana;
        arg1.rejuvenate += arg2.rejuvenate;
        arg1.damage += arg2.damage;
        arg1.maxMana += arg2.maxMana;
        arg1.focus += arg2.focus;
    }

    public HashMap<TYPE, Integer> toHashMap(){
        HashMap<TYPE, Integer> output = new HashMap<>();
        //Health, Defense, Speed, Armor, Piercing, Mana, Rejuvenate, Damage, Focus
        if(maxHealth != 0){
            output.put(TYPE.Health, maxHealth);
        }
        if(defense != 0){
            output.put(TYPE.Defense, defense);
        }
        if(speed != 0){
            output.put(TYPE.Speed, speed);
        }
        if(armor != 0){
            output.put(TYPE.Armor, armor);
        }
        if(piercing != 0){
            output.put(TYPE.Piercing, piercing);
        }
        if(maxMana != 0){
            output.put(TYPE.Mana, maxMana);
        }
        if(rejuvenate != 0){
            output.put(TYPE.Rejuvenate, rejuvenate);
        }
        if(damage != 0){
            output.put(TYPE.Damage, damage);
        }
        if(focus != 0){
            output.put(TYPE.Focus, focus);
        }

        return output;
    }

    public void fromHashMap(HashMap<TYPE, Integer> stats){
        //Health, Defense, Speed, Armor, Piercing, Mana, Rejuvenate, Damage, Focus
        if(stats.containsKey(TYPE.Health)){
            maxHealth = stats.get(TYPE.Health);
        }
        if(stats.containsKey(TYPE.Defense)){
            defense = stats.get(TYPE.Defense);
        }
        if(stats.containsKey(TYPE.Speed)){
            speed = stats.get(TYPE.Speed);
        }
        if(stats.containsKey(TYPE.Armor)){
            armor = stats.get(TYPE.Armor);
        }
        if(stats.containsKey(TYPE.Armor)){
            armor = stats.get(TYPE.Armor);
        }
        if(stats.containsKey(TYPE.Mana)){
            mana = stats.get(TYPE.Mana);
        }
        if(stats.containsKey(TYPE.Rejuvenate)){
            rejuvenate = stats.get(TYPE.Rejuvenate);
        }
        if(stats.containsKey(TYPE.Damage)){
            damage = stats.get(TYPE.Damage);
        }
        if(stats.containsKey(TYPE.Focus)){
            focus = stats.get(TYPE.Focus);
        }
    }
}
