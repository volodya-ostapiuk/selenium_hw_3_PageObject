package com.epam.utils;

import com.epam.model.MessageEntity;
import com.epam.model.UserEntity;
import com.epam.utils.json.JsonParser;
import com.epam.utils.properties.ConfigProperties;
import com.epam.utils.providers.MessageEntityProvider;

import java.util.List;
import java.util.Objects;

public interface Constants {
    String DRIVER_NAME = ConfigProperties.getDriverName();
    String DRIVER_PATH = ConfigProperties.getDriverPath();
    String BASE_URL = ConfigProperties.getBaseUrl();
    int TIME_WAIT = ConfigProperties.getTimeWait();
    int EXPLICIT_WAIT = ConfigProperties.getExplicitWait();

    List<UserEntity> USERS = Objects.requireNonNull(JsonParser.getGmailJsonEntity()).getUsers();

    MessageEntity TEST_MESSAGE = MessageEntityProvider.getMessageEntity();
    String TEST_RECEIVER_EMAIL = TEST_MESSAGE.getReceiver();
    String TEST_CC_EMAIL = TEST_MESSAGE.getCc();
    String TEST_BCC_EMAIL = TEST_MESSAGE.getBcc();
    String TEST_LETTER_TOPIC = TEST_MESSAGE.getTopic();
    String TEST_LETTER_TEXT = TEST_MESSAGE.getLetterText();

    String WRONG_LOGIN = "Wrong login.";
    String WRONG_RECEIVER = "Last draft letter doesn't contain created letter receiver.";
    String WRONG_CC = "Last draft letter doesn't contain created letter cc receiver.";
    String WRONG_BCC = "Last draft letter doesn't contain created letter bcc receiver.";
    String WRONG_TOPIC = "Last draft letter doesn't contain created letter topic.";
    String WRONG_TEXT = "Last draft letter doesn't contain created letter text.";
}