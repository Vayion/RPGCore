package de.vayion.rpgcore.commands;

import java.util.IllegalFormatException;

import de.vayion.rpgcore.items.CustomItem;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import de.vayion.rpgcore.RPGCore;
import de.vayion.rpgcore.entityManagement.EntityWrapper;
import org.jetbrains.annotations.NotNull;

public class DebugCmd implements CommandExecutor {
    private final RPGCore main;

    public DebugCmd(RPGCore main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command arg1, @NotNull String arg2, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(!player.hasPermission("rpg.admin")) {player.sendMessage(arg1.getPermissionMessage());}
            if(args.length==0) {
                player.sendMessage("Missing args.\n"+arg1.getUsage());
                return false;
            }
            switch(args[0].toLowerCase()) {
                case "setdefense":
                    if(args.length==2) {
                        try {
                            main.getPlayerContainer().getWrapper(player).setDefense(Integer.parseInt(args[1]));
                            player.sendMessage("Set defense to "+Integer.parseInt(args[1]));
                        }
                        catch(IllegalFormatException e) {player.sendMessage("NaN exception");}
                    } break;
                case "setarmor":
                    if(args.length==2) {
                        try {
                            main.getPlayerContainer().getWrapper(player).setArmor(Integer.parseInt(args[1]));
                            player.sendMessage("Set armor to "+Integer.parseInt(args[1]));
                        }
                        catch(IllegalFormatException e) {player.sendMessage("NaN exception");}
                    } break;
                case "setmaxhealth":
                    if(args.length==2) {
                        try {
                            main.getPlayerContainer().getWrapper(player).setMaxhealth(Integer.parseInt(args[1]));
                            player.sendMessage("Set maxHealth to "+Integer.parseInt(args[1]));
                        }
                        catch(IllegalFormatException e) {player.sendMessage("NaN exception");}
                    } break;
                case "setpiercing":
                    if(args.length==2) {
                        try {
                            main.getPlayerContainer().getWrapper(player).setPiercing(Integer.parseInt(args[1]));
                            player.sendMessage("Set piercing to "+Integer.parseInt(args[1]));
                        }
                        catch(IllegalFormatException e) {player.sendMessage("NaN exception");}
                    } break;
                case "setdamage":
                    if(args.length==2) {
                        try {
                            main.getPlayerContainer().getWrapper(player).setDamage(Integer.parseInt(args[1]));
                            player.sendMessage("Set damage to "+Integer.parseInt(args[1]));
                        }
                        catch(IllegalFormatException e) {player.sendMessage("NaN exception");}
                    } break;
                case "summonzombie":
                    LivingEntity zombie = (LivingEntity)player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                    EntityWrapper zombieWrap = new EntityWrapper(zombie, main);
                    zombieWrap.setMaxhealth(200);
                    zombieWrap.setHealth(200);
                    zombieWrap.setDefense(50);
                    zombieWrap.setArmor(20);
                    main.getEntityContainer().add(zombieWrap);
                    break;
                case "debugsword":
                    CustomItem item = new CustomItem("End Sword", "Eza, hop onto this project ong skibidi", Material.DIAMOND_SWORD, main.getItemRegistry());
                    item.setDamage(100);
                    item.setPiercing(50);
                    item.setDefense(30);
                    item.generateItem(5);
                    player.getInventory().addItem(item.getItem());
                    player.updateInventory();
                    break;
                case "eza":
                    CustomItem item2 = new CustomItem("Burning Wand", null, Material.BLAZE_ROD, main.getItemRegistry());
                    item2.generateItem(2);
                    player.getInventory().addItem(item2.getItem());
                    player.updateInventory();
                default:
            }
        }
        else {
            sender.sendMessage("Must execute this as a player.");
        }
        return false;
    }
}
