package de.vayion.rpgcore.items;

import org.bukkit.Material;

import de.vayion.rpgcore.playerManagement.PlayerWrapper;
import de.vayion.rpgcore.stats.StatContainer;

public class CustomItem extends StatContainer {
    String id;
    Material type;
    String name;
    public static CustomItem readItemFrom(String input) {
        return null;
    }


    public void removeStats(PlayerWrapper target) {
        target.addArmor(armor);
        target.addDamage(damage);
        target.addDefense(defense);
        target.addFocus(focus);
        target.addMana(mana);
        target.addMaxhealth(maxHealth);
        target.addPiercing(piercing);
        target.addRejuvenate(rejuvenate);
        target.addSpeed(speed);
    }


}
