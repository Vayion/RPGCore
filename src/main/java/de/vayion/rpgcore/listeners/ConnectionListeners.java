package de.vayion.rpgcore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.vayion.rpgcore.RPGCore;
import de.vayion.rpgcore.playerManagement.PlayerWrapper;

public class ConnectionListeners implements Listener {
    private RPGCore main;
    public ConnectionListeners(RPGCore main) {
        this.main = main;
        main.getServer().getPluginManager().registerEvents(this, main);
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        PlayerWrapper p = new PlayerWrapper(e.getPlayer(), main.getPlayerContainer());
        main.getPlayerContainer().add(p);
        main.getEntityContainer().add(p);
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        main.getPlayerContainer().remove(e.getPlayer());
        main.getEntityContainer().remove(e.getPlayer());
    }
    @EventHandler
    public void onPlayerLeave(PlayerKickEvent e) {
        main.getPlayerContainer().remove(e.getPlayer());
        main.getEntityContainer().remove(e.getPlayer());

    }
}
