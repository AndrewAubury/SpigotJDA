package me.andrew.spigotjda.events.custom;

import lombok.Getter;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * ------------------------------
 * Copyright (c) AndrewAubury 2018
 * https://www.andrewa.pw
 * Project: SpigotJDA
 * ------------------------------
 */

public final class DiscordMessageReceivedEvent extends Event{
    private static final HandlerList handlers = new HandlerList();

    @Getter MessageChannel channel;
    @Getter Message message;
    @Getter Member member;
    @Getter User author;

    private MessageReceivedEvent e;

    public DiscordMessageReceivedEvent(MessageReceivedEvent e) {
        this.e = e;
        channel = e.getChannel();
        member = e.getMember();
        author = e.getAuthor();
    }


    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}