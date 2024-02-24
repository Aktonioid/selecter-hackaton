package com.hack.selectel.infrastucture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.hack.selectel.core.bot.BotBase;

@Component
@PropertySource("application.properties")
public class Delete extends BotBase
{
    @Autowired
    Environment env;
    public Delete(@Value("${telegram.bot-token}") String botToken) 
    {
        
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) 
    {
        if(!update.hasMessage() || !update.getMessage().hasText())
        {
            return;
        }
        System.out.println(update.getMessage().getChatId());
    }
    
    public static void sendMessage(String chatId, String text)
    {
        
    }

    public void sendMessage(SendMessage message) throws TelegramApiException
    {
        execute(message);
    }
}
