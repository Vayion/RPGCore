package de.vayion.rpgcore.playerManagement;

import de.vayion.rpgcore.RPGCore;
import de.vayion.rpgcore.items.CustomItem;
import org.bukkit.entity.Player;

import de.vayion.rpgcore.entityManagement.EntityWrapper;
import de.vayion.rpgcore.factionManagement.Faction;
import org.bukkit.inventory.ItemStack;

public class PlayerWrapper extends EntityWrapper{

    private Faction faction;
    private PlayerContainer container;
    private Player player;

    public PlayerWrapper(Player player, RPGCore main, PlayerContainer container) {
        super(player, main);
        this.player = player;
        this.container = container;
    }

    @Override
    public int getArmor() {
        int output = super.getArmor();
        ItemStack[] temp = player.getInventory().getArmorContents();
        ItemStack[] items = new ItemStack[]{temp[0],temp[1],temp[2],temp[3],player.getInventory().getItemInMainHand(), player.getInventory().getItemInOffHand()};
        for(ItemStack item : items){
            CustomItem cItem = main.getItemRegistry().get(item);
            if(cItem != null){
                output+=cItem.getArmor();
            }
        }
        return output;
    }

    @Override
    public int getDamage() {
        int output = super.getDamage();
        ItemStack[] temp = player.getInventory().getArmorContents();
        ItemStack[] items = new ItemStack[]{temp[0],temp[1],temp[2],temp[3],player.getInventory().getItemInMainHand(), player.getInventory().getItemInOffHand()};
        for(ItemStack item : items){
            CustomItem cItem = main.getItemRegistry().get(item);
            if(cItem != null){
                output+=cItem.getDamage();
            }
        }
        return output;
    }

    @Override
    public int getDefense() {
        int output = super.getDefense();
        ItemStack[] temp = player.getInventory().getArmorContents();
        ItemStack[] items = new ItemStack[]{temp[0],temp[1],temp[2],temp[3],player.getInventory().getItemInMainHand(), player.getInventory().getItemInOffHand()};
        for(ItemStack item : items){
            CustomItem cItem = main.getItemRegistry().get(item);
            if(cItem != null){
                output+=cItem.getDefense();
            }
        }
        return output;
    }

    @Override
    public int getPiercing() {
        int output = super.getPiercing();
        ItemStack[] temp = player.getInventory().getArmorContents();
        ItemStack[] items = new ItemStack[]{temp[0],temp[1],temp[2],temp[3],player.getInventory().getItemInMainHand(), player.getInventory().getItemInOffHand()};
        for(ItemStack item : items){
            CustomItem cItem = main.getItemRegistry().get(item);
            if(cItem != null){
                output+=cItem.getPiercing();
            }
        }
        return output;
    }


    /*
    public void setFaction(Faction faction) {
        this.faction = faction;
    }
     */
}
