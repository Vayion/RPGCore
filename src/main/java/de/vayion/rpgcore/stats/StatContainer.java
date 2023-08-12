package de.vayion.rpgcore.stats;

public abstract class StatContainer {
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

    public void setMaxhealth(int maxHealth) { this.maxHealth = maxHealth; }
    public void setPiercing(int piercing) {
        this.piercing = piercing;
    }
    public void setRejuvenate(int rejuvenate) {
        this.rejuvenate = rejuvenate;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setDefense(int defense) { this.defense = defense; }
}
