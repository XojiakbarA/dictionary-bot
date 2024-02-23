package org.example.service;

import com.google.gson.Gson;
import org.example.model.Language;
import org.example.model.Translate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TranslateService {
    public Translate getTranslate(String text, Language language) {
        String apiKey = "dict.1.1.20230314T090925Z.f05f25539bfdab38.d351539fdf6d61bff91b775ca664815b76c5691b";
        String endpoint = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=%s&lang=%s&text=%s";
        String spec = String.format(endpoint, apiKey, language.getCode(), text);
        Translate translate = null;
        try {
            URL url = new URL(spec);
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            Gson gson = new Gson();
            translate = gson.fromJson(reader, Translate.class);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return translate;
    }
}
