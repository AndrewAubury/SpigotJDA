package me.andrew.spigotjda.events;

import me.andrew.spigotjda.events.custom.DiscordMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.bukkit.Bukkit;

/**
 * ------------------------------
 * Copyright (c) AndrewAubury 2018
 * https://www.andrewa.pw
 * Project: SpigotJDA
 * ------------------------------
 */
public class JDAEventWrapper extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e)
    {
        DiscordMessageReceivedEvent event = new DiscordMessageReceivedEvent(e);
        Bukkit.getServer().getPluginManager().callEvent(event);
    }


}
