package de.vayion.rpgcore.entityManagement;

import de.vayion.rpgcore.RPGCore;
import de.vayion.rpgcore.stats.StatContainer;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;

public class EntityType extends StatContainer {
    private final org.bukkit.entity.EntityType type;
    private String name;
    private final RPGCore main;

    public EntityType(RPGCore main, HashMap<TYPE, Integer> stats, org.bukkit.entity.EntityType type, String name) {
        fromHashMap(stats);
        this.type = type;
        this.name = name;
        this.main = main;
    }

    public void summonMob(Location loc){
        LivingEntity mob = (LivingEntity) loc.getWorld().spawnEntity(loc, type);
        EntityWrapper e = new EntityWrapper(mob, main);
        e.fromHashMap(toHashMap());
        main.getEntityContainer().add(e);
    }

    public static boolean fromJSON(JSONObject jsonObject){
        return false;
    }

    public static String toJSON(){
        // just a test function for now
        HashMap<TYPE, Integer> stats = new HashMap<>();
        stats.put(TYPE.Health, 100);
        stats.put(TYPE.Defense, 100);
        EntityType type = new EntityType(null, stats, org.bukkit.entity.EntityType.ZOMBIE, "Hi Eza");
        HashMap<TYPE, Integer> output = type.toHashMap();
        return new JSONObject(output).toJSONString();
    }
}
