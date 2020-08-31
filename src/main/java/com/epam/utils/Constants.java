package com.epam.utils;

import com.epam.model.UserEntity;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import static com.epam.utils.JsonReader.getJsonEntity;
import static com.epam.utils.PropertyGetter.getProperty;

public interface Constants {
    String DRIVER_NAME = Objects.requireNonNull(getProperty("driver_name"));
    String DRIVER_PATH = Objects.requireNonNull(getProperty("driver_path"));
    String BASE_URL = getProperty("base_url");
    int TIME_WAIT = Integer.parseInt(Objects.requireNonNull(getProperty("time_wait")));
    int MINIMUM = 0;
    List<UserEntity> users = Objects.requireNonNull(getJsonEntity()).getUsers();
    String TEST_EMAIL = users.get(0).getEmail();
    String TEST_PASSWORD = users.get(0).getPassword();
    String RECEIVER_EMAIL = getJsonEntity().getReceiver();
    String CC_EMAIL = getJsonEntity().getCc();
    String BCC_EMAIL = getJsonEntity().getBcc();
    String LETTER_TOPIC = getJsonEntity().getTopic();
    String LETTER_TEXT = getJsonEntity().getLetterText() +
            new Random().nextInt(Integer.MAX_VALUE - MINIMUM) + MINIMUM;
}