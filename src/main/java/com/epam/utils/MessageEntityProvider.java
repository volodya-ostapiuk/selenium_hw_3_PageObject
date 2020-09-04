package com.epam.utils;

import com.epam.model.MessageEntity;

import java.util.Objects;
import java.util.Random;

import static com.epam.utils.JsonParser.getGmailJsonEntity;

public class MessageEntityProvider {
    public static MessageEntity message;
    private static final int MINIMUM = 0;

    public static MessageEntity getMessageEntity() {
        message = Objects.requireNonNull(getGmailJsonEntity()).getMessage();
        message.setLetterText(message.getLetterText() +
                new Random().nextInt(Integer.MAX_VALUE - MINIMUM) + MINIMUM);
        return message;
    }
}
