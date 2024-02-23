package org.example.util;

import org.example.model.DefItem;
import org.example.model.TrItem;
import org.example.model.Translate;

import java.util.ArrayList;
import java.util.List;

public class ResponseCreator {
    public static String create(Translate translate) {
        List<DefItem> defItems = translate.getDef();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < defItems.size(); i++) {
            DefItem defItem = defItems.get(i);
            List<String> list = new ArrayList<>();
            for (TrItem trItem : defItem.getTr()) {
                list.add(trItem.getText());
            }
            String translates = String.join(", ", list);
            res.append(String.format(
                    "%d. %s (%s) - %s", i + 1,
                    defItems.get(i).getText(),
                    defItems.get(i).getPos(),
                    translates)).append("\n");
        }
        return res.toString();
    }
}
