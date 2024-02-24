package com.hack.selectel.core.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

//базовый класс для ботов, чтоб при его наследовании 
@PropertySource("application.properties")
public class BotBase extends TelegramLongPollingBot 
{
    @Autowired
    private Environment env;

    public BotBase(@Value("${telegram.bot-token}") String botToken)
    {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) 
    {
        // update.getMessage().getFrom().getUserName();
        throw new UnsupportedOperationException("Unimplemented method 'onUpdateReceived'");
    }

    @Override
    public final String getBotUsername() 
    {
        return env.getProperty("telegram.bot-name");
    }

}
