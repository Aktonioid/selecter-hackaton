package com.hack.selectel.infrastucture.bot;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;


import com.hack.selectel.core.bot.BotBase;
import com.hack.selectel.core.dtos.UserModelDto;
import com.hack.selectel.core.services.IUserService;

@Component
@PropertySource("application.properties")
public class RegistrationBot extends BotBase
{
    @Autowired
    Environment env;
    @Autowired
    IUserService userService;

    public RegistrationBot(@Value("${telegram.bot-token}") String botToken) 
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

        if(update.getMessage().getText().equals("/start"))
        {
            UserModelDto userModelDto = null;
            try 
            {
                userModelDto = userService
                .GetUserByUsername(
                    update
                    .getMessage()
                    .getFrom()
                    .getUserName()).get();
            } 
            catch (InterruptedException | ExecutionException e) 
            {
                e.printStackTrace();
            }
            catch(NullPointerException e)
            {
                SendMessage(update.getMessage().getChatId(), "Продолжи регистрацию, человек");
                return;
            }

            // есили пользователь зареган, о мы ему об этом сообщим
            if(userModelDto != null)
            {
                SendMessage(update.getMessage().getChatId(), "Вы уже зарегистрированы");
                return;
            }
            userModelDto = new UserModelDto();
            userModelDto.setUsername(update.getMessage().getFrom().getUserName());
            userModelDto.setFirstName(update.getMessage().getFrom().getFirstName());
            userModelDto.setSurname(update.getMessage().getFrom().getLastName());

            userService.CreateUser(userModelDto);

            SendMessage(update.getMessage().getChatId(),
             "Здравствуйте, это бот для доноров, пока ничего не придумал что написать"+
             "\n Пройдите, пожалуйста, регистрацию(Нажать на кнопочку меню)");
        }
    }
    

    private void SendMessage(Long chatId, String text)
    {
        SendMessage message = new SendMessage(String.valueOf(chatId), text);

        try 
        {
            execute(message);
        } 
        catch (TelegramApiException e) 
        {
            e.printStackTrace();
        }
    }

}
