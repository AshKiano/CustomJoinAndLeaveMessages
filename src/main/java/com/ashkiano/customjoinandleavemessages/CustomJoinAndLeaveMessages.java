package com.ashkiano.customjoinandleavemessages;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomJoinAndLeaveMessages extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Save a copy of the default config.yml if one isn't already present
        this.saveDefaultConfig();

        Metrics metrics = new Metrics(this, 21175);

        // Register the current class as an event listener
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Get the custom join message from config.yml, replacing %player% with the player's name
        String joinMessage = getConfig().getString("join-message").replace("%player%", event.getPlayer().getName());
        event.setJoinMessage(joinMessage);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        // Get the custom quit message from config.yml, replacing %player% with the player's name
        String quitMessage = getConfig().getString("quit-message").replace("%player%", event.getPlayer().getName());
        event.setQuitMessage(quitMessage);
    }
}
