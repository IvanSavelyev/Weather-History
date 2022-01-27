package com.github.ivansavelyev.weatherservice.util;

import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@UtilityClass
public class WebUtil {

    public static String parseFromYandex() {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL("https://yandex.ru/");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            while ((str = in.readLine()) != null) {
                result.append(str);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String content = "'weather__content'";
        int start = result.indexOf(content);
        String weatherTag = result.substring(start + content.length());
        int firstIndex = weatherTag.indexOf("\"");
        int lastIndex = weatherTag.indexOf("\"", firstIndex + 1);
        return weatherTag.substring(firstIndex + 1, lastIndex);
    }
}
