package de.vayion.rpgcore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.vayion.rpgcore.RPGCore;
import de.vayion.rpgcore.entityManagement.EntityWrapper;

public class CombatListeners implements Listener{
    private RPGCore main;
    public CombatListeners(RPGCore main) {
        this.main = main;
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void DamageEvent(EntityDamageByEntityEvent event) {
        event.setDamage(0D);
        EntityWrapper damager;
        if(event.getDamager() instanceof LivingEntity) {
            damager = main.getEntityContainer().getWrapper((LivingEntity) event.getDamager());
        }
        else if(event.getDamager() instanceof Projectile&&((Projectile)event.getDamager()).getShooter() instanceof LivingEntity) {
            damager = main.getEntityContainer().getWrapper((LivingEntity)((Projectile)event.getDamager()).getShooter());
        }
        else {return;}
        if(damager == null) {return;}
        EntityWrapper defender;
        if(event.getEntity() instanceof LivingEntity) {
            defender = main.getEntityContainer().getWrapper((LivingEntity) event.getEntity());
        }
        else {return;}
        if(defender == null) {return;}
        defender.damage(damager.getDamage(), damager.getPiercing());
        Bukkit.broadcastMessage("Stats of the Battle\n "
                + "Defender:\n"
                + "  Defense: "+defender.getDefense()+"\n"
                + "  Armor: "+defender.getArmor()+"\n"
                + "  Health: "+defender.getHealth()+"\n"
                + "Attacker:\n"
                + "  Damage: "+damager.getDamage()+"\n"
                + "  Piercing: "+damager.getPiercing()+"\n"
                + "Damage Modifier: "+
                (Double.max((8D-(Math.log((21D/69)*(defender.getDefense()+(69D/21)))/Math.log(2)))/8D,0.01D)*(defender.getArmor()<=damager.getPiercing()?1D:0.5D)));

    }
}
