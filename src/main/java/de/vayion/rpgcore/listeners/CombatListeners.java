package de.vayion.rpgcore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.vayion.rpgcore.RPGCore;
import de.vayion.rpgcore.entityManagement.EntityWrapper;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class CombatListeners implements Listener{
    private RPGCore main;
    public CombatListeners(RPGCore main) {
        this.main = main;
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void damageEvent(EntityDamageByEntityEvent event) {
        event.setDamage(0D);
        EntityWrapper damager;
        LivingEntity damagerEntity;
        if(event.getDamager() instanceof LivingEntity) {
            damagerEntity = (LivingEntity) event.getDamager();
            damager = main.getEntityContainer().getWrapper(damagerEntity);
        }
        else if(event.getDamager() instanceof Projectile&&((Projectile)event.getDamager()).getShooter() instanceof LivingEntity) {
            damagerEntity = (LivingEntity)((Projectile)event.getDamager()).getShooter();
            damager = main.getEntityContainer().getWrapper(damagerEntity);
        }
        else {return;}
        if(damager == null) {damagerEntity.setHealth(0);event.setCancelled(true);return;}
        EntityWrapper defender;
        if(event.getEntity() instanceof LivingEntity) {
            LivingEntity defenderEntity = (LivingEntity) event.getEntity();
            defender = main.getEntityContainer().getWrapper(defenderEntity);
            if(defender == null) {defenderEntity.setHealth(0);event.setCancelled(true);return;}
        }
        else {event.setCancelled(true);return;}

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

    @EventHandler
    public void entityDeath(EntityDeathEvent event){
        event.setDroppedExp(0);
        if(event.getEntityType() == EntityType.ZOMBIE){
            event.getDrops().add(ItemStack.of(Material.BLAZE_ROD));
        }
        //event.getDrops().removeAll();
        //event.getDrops().add();
    }
}
