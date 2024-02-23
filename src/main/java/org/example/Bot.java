package org.example;

import org.example.model.Language;
import org.example.model.Stage;
import org.example.model.Translate;
import org.example.model.User;
import org.example.service.TranslateService;
import org.example.util.MarkupCreator;
import org.example.util.ResponseCreator;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    private final List<User> users = new ArrayList<>();
    private final TranslateService translateService = new TranslateService();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            User user = getUser(callbackQuery.getMessage().getChatId());
            SendMessage sendMessage = new SendMessage();
            try {
                Language language = Language.valueOf(update.getCallbackQuery().getData());
                user.setLanguage(language);
            } catch (IllegalArgumentException iae) {
                sendMessage.setText("Noto'g'ri tarjima turi kiritildi");
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
            Translate translate = translateService.getTranslate(user.getText(), user.getLanguage());
            String res = "Uzr, bunday so'z topilmadi";
            if (!translate.getDef().isEmpty()) {
                res = ResponseCreator.create(translate);
            }
            sendMessage.setText(res);
            sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                System.out.println(e.getMessage());
            }
        }
        if (update.hasMessage()) {

            Message message = update.getMessage();
            User user = getUser(message.getChatId());

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(user.getChatId());

            if (message.getText().equals("/start")) {

                user.setStage(Stage.START);
                sendMessage.setText("So'z kiriting");
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    System.out.println(e.getMessage());
                }
                user.setStage(Stage.TEXT);

            } else if (user.getStage().equals(Stage.TEXT)) {

                InlineKeyboardMarkup markup = MarkupCreator.create();
                sendMessage.setText("Tarjima turini tanlang");
                sendMessage.setReplyMarkup(markup);
                user.setText(message.getText());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "OrgDictionaryBot";
    }
    @Override
    public String getBotToken() {
        return "6261532180:AAEC4ih3ECTh6YekFZaqtNqn-C5l8lchyTc";
    }
    private User getUser(long chatId) {
        User user = users.stream().filter(u -> u.getChatId() == chatId).findFirst().orElse(null);
        if (user == null) {
            User newUser = new User(chatId, Stage.START, null, null);
            users.add(newUser);
            return newUser;
        }
        return user;
    }
}
