package me.andrew.spigotjda;

import lombok.Getter;

import me.andrew.spigotjda.events.JDAEventWrapper;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

/**
 * ------------------------------
 * Copyright (c) AndrewAubury 2018
 * https://www.andrewa.pw
 * Project: spigotjda
 * ------------------------------
 */
public class SpigotJDA extends JavaPlugin {

    @Getter
    JDA jda;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        setupJDA();
    }

    private void setupJDA() {
        String token = getConfig().getString("discord.token");
        String game = getConfig().getString("discord.game");
        if(token == ""){
            try {
                jda = new JDABuilder().setToken(token).setGame(Game.playing(game)).build();
                jda.addEventListener(new JDAEventWrapper());
            } catch (LoginException e) {
                getServer().getLogger().severe("Error logging in to Discord");
                getServer().getPluginManager().disablePlugin(this);
            }
        }else{
            getServer().getLogger().severe("No Token Provided");
            getServer().getPluginManager().disablePlugin(this);
        }
    }

}
