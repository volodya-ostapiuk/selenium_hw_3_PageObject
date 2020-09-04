package com.epam.utils;

import com.epam.model.MessageEntity;
import com.epam.model.UserEntity;
import com.epam.utils.properties.ConfigProperties;

import java.util.List;
import java.util.Objects;

import static com.epam.utils.JsonParser.getGmailJsonEntity;

public interface Constants {
    String DRIVER_NAME = ConfigProperties.getDriverName();
    String DRIVER_PATH = ConfigProperties.getDriverPath();
    String BASE_URL = ConfigProperties.getBaseUrl();
    int TIME_WAIT = ConfigProperties.getTimeWait();
    int EXPLICIT_WAIT = ConfigProperties.getExplicitWait();
    int FIRST_USER_NUMBER = 0;
    List<UserEntity> USERS = Objects.requireNonNull(getGmailJsonEntity()).getUsers();
    MessageEntity TEST_MESSAGE = MessageEntityProvider.getMessageEntity();
    String TEST_EMAIL = USERS.get(FIRST_USER_NUMBER).getEmail();
    String TEST_PASSWORD = USERS.get(FIRST_USER_NUMBER).getPassword();
    String TEST_RECEIVER_EMAIL = TEST_MESSAGE.getReceiver();
    String TEST_CC_EMAIL = TEST_MESSAGE.getCc();
    String TEST_BCC_EMAIL = TEST_MESSAGE.getBcc();
    String TEST_LETTER_TOPIC = TEST_MESSAGE.getTopic();
    String TEST_LETTER_TEXT = TEST_MESSAGE.getLetterText();
}