package org.example.util;

import org.example.model.Language;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class MarkupCreator {
    public static InlineKeyboardMarkup create() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        List<InlineKeyboardButton> keyboardButtonRow1 = createInlineKeyboardButtonRow(
                Language.RU_RU.getNameWithEmoji(), Language.RU_RU.name(),
                Language.RU_EN.getNameWithEmoji(), Language.RU_EN.name(),
                Language.RU_TR.getNameWithEmoji(), Language.RU_TR.name()
        );

        List<InlineKeyboardButton> keyboardButtonRow2 = createInlineKeyboardButtonRow(
                Language.EN_RU.getNameWithEmoji(), Language.EN_RU.name(),
                Language.EN_EN.getNameWithEmoji(), Language.EN_EN.name(),
                Language.EN_TR.getNameWithEmoji(), Language.EN_TR.name()
        );

        List<InlineKeyboardButton> keyboardButtonRow3 = createInlineKeyboardButtonRow(
                Language.TR_RU.getNameWithEmoji(), Language.TR_RU.name(),
                Language.TR_EN.getNameWithEmoji(), Language.TR_EN.name(),
                Language.TR_TR.getNameWithEmoji(), Language.TR_TR.name()
        );

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonRow1);
        rowList.add(keyboardButtonRow2);
        rowList.add(keyboardButtonRow3);

        markup.setKeyboard(rowList);
        return markup;
    }
    private static List<InlineKeyboardButton> createInlineKeyboardButtonRow(
            String text1, String callbackData1, String text2, String callbackData2, String text3, String callbackData3
    ) {
        InlineKeyboardButton button1 = new InlineKeyboardButton(text1);
        button1.setCallbackData(callbackData1);

        InlineKeyboardButton button2 = new InlineKeyboardButton(text2);
        button2.setCallbackData(callbackData2);

        InlineKeyboardButton button3 = new InlineKeyboardButton(text3);
        button3.setCallbackData(callbackData3);

        return List.of(button1, button2, button3);
    }
}
