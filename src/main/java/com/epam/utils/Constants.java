package com.epam.utils;

import com.epam.model.UserEntity;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import static com.epam.utils.JsonParser.getGmailJsonEntity;
import static com.epam.utils.PropertySource.getProperty;

public interface Constants {
    String DRIVER_NAME = Objects.requireNonNull(getProperty("driver_name"));
    String DRIVER_PATH = Objects.requireNonNull(getProperty("driver_path"));
    String BASE_URL = getProperty("base_url");
    int TIME_WAIT = Integer.parseInt(Objects.requireNonNull(getProperty("time_wait")));
    int MINIMUM = 0;
    List<UserEntity> users = Objects.requireNonNull(getGmailJsonEntity()).getUsers();
    String TEST_EMAIL = users.get(0).getEmail();
    String TEST_PASSWORD = users.get(0).getPassword();
    String RECEIVER_EMAIL = getGmailJsonEntity().getReceiver();
    String CC_EMAIL = getGmailJsonEntity().getCc();
    String BCC_EMAIL = getGmailJsonEntity().getBcc();
    String LETTER_TOPIC = getGmailJsonEntity().getTopic();
    String LETTER_TEXT = getGmailJsonEntity().getLetterText() +
            new Random().nextInt(Integer.MAX_VALUE - MINIMUM) + MINIMUM;
}