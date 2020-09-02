package com.epam;

import com.epam.business.GmailLogInBO;
import com.epam.business.GmailMessageBO;
import com.epam.model.MessageEntity;
import com.epam.utils.Constants;
import com.epam.utils.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailTest implements Constants {
    private WebDriver webDriver;
    private GmailLogInBO logInBO;
    private GmailMessageBO messageBO;

    @BeforeClass
    private void setUp() {
        webDriver = DriverProvider.getInstance();
        webDriver.get(BASE_URL);
        logInBO = new GmailLogInBO();
        messageBO = new GmailMessageBO();
    }

    /*
     * Enter email, enter password. Wait until new page will be opened and element will be clickable on it.
     * Check does page title contains email. Create new letter. Save it as draft.
     * Check if last draft letter contains needed emails, text and topic. Send saved letter.
     */
    @Test
    private void verifyDraftFieldsAreSavedCorrectly() {
        logInBO.logIn(TEST_EMAIL, TEST_PASSWORD);
        Assert.assertTrue(logInBO.getPageTitle().contains(TEST_EMAIL.toLowerCase()),
                "Wrong login.");

        messageBO.createDraftMessage(TEST_MESSAGE);
        messageBO.goToDraftsFolderAndClickLastDraftMessage();

        MessageEntity filledDraftMessage = messageBO.getDraftMessageEntity();
        Assert.assertTrue(filledDraftMessage.getReceiver().contains(TEST_RECEIVER_EMAIL),
                "Last draft letter doesn't contain created letter receiver.");
        Assert.assertTrue(filledDraftMessage.getCc().contains(TEST_CC_EMAIL),
                "Last draft letter doesn't contain created letter cc receiver.");
        Assert.assertTrue(filledDraftMessage.getBcc().contains(TEST_BCC_EMAIL),
                "Last draft letter doesn't contain created letter bcc receiver.");
        Assert.assertTrue(filledDraftMessage.getTopic().contains(TEST_LETTER_TOPIC),
                "Last draft letter doesn't contain created letter topic.");
        Assert.assertTrue(filledDraftMessage.getLetterText().contains(TEST_LETTER_TEXT),
                "Last draft letter doesn't contain created letter text.");

        messageBO.sendLastDraftMessage();
    }

    @AfterClass
    private void quitDriver() {
        webDriver.quit();
    }
}
