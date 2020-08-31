package com.epam.utils;

import com.epam.model.GmailJsonEntity;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

import static com.epam.utils.PropertySource.getProperty;

public class JsonParser {
    public static GmailJsonEntity getGmailJsonEntity() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(Objects.requireNonNull(getProperty("data_source")))) {
            return gson.fromJson(reader, GmailJsonEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
