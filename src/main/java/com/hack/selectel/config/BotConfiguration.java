package com.hack.selectel.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.hack.selectel.infrastucture.bot.RegistrationBot;
import com.hack.selectel.infrastucture.controllers.Delete;


@Configuration
@EnableCaching
@EnableScheduling
public class BotConfiguration 
{
    @Bean
    public TelegramBotsApi delteBot(Delete delete,RegistrationBot registrationBot) throws TelegramApiException
    {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(registrationBot);
        return api;
    }    
}
