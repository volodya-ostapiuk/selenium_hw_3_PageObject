package com.epam;

import com.epam.business.GmailLogInBO;
import com.epam.business.GmailMessageBO;
import com.epam.model.MessageEntity;
import com.epam.utils.Constants;
import com.epam.utils.providers.DataProvider;
import com.epam.utils.providers.DriverProvider;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.stream.Stream;

public class GmailTest implements Constants {

    @BeforeMethod
    private void setUp() {
        DriverProvider.getInstance().get(BASE_URL);
    }

    @org.testng.annotations.DataProvider(parallel = true)
    public Iterator<Object[]> usersLoginAndPassword() {
        return Stream.of(DataProvider.getUsers()).iterator();
    }

    /**
     * Enter email, enter password. Wait until new page will be opened and element will be clickable on it.
     * Check does page title contains email. Create new letter. Save it as draft.
     * Check if last draft letter contains needed emails, text and topic. Send saved letter.
     */
    @Test(dataProvider = "usersLoginAndPassword")
    private void verifyDraftFieldsAreSavedCorrectly(String userEmail, String userPassword) {
        GmailLogInBO logInBO = new GmailLogInBO();
        GmailMessageBO messageBO = new GmailMessageBO();

        System.out.println("!!! " + userEmail + " !!! " + userPassword);

        logInBO.logIn(userEmail, userPassword);
        Assert.assertTrue(logInBO.getPageTitle().contains(userEmail.toLowerCase()), WRONG_LOGIN);

        System.out.println("!!! " + TEST_MESSAGE);
        System.out.println("!!! " + TEST_RECEIVER_EMAIL);
        System.out.println("!!! " + TEST_CC_EMAIL);
        System.out.println("!!! " + TEST_BCC_EMAIL);
        System.out.println("!!! " + TEST_LETTER_TOPIC);
        System.out.println("!!! " + TEST_LETTER_TEXT);

        messageBO.createDraftMessage(TEST_MESSAGE);
        messageBO.goToDraftsFolderAndClickLastDraftMessage();

        MessageEntity filledDraftMessage = messageBO.getDraftMessageEntity();
        Assert.assertTrue(filledDraftMessage.getReceiver().contains(TEST_RECEIVER_EMAIL), WRONG_RECEIVER);
        Assert.assertTrue(filledDraftMessage.getCc().contains(TEST_CC_EMAIL), WRONG_CC);
        Assert.assertTrue(filledDraftMessage.getBcc().contains(TEST_BCC_EMAIL), WRONG_BCC);
        Assert.assertTrue(filledDraftMessage.getTopic().contains(TEST_LETTER_TOPIC), WRONG_TOPIC);
        Assert.assertTrue(filledDraftMessage.getLetterText().contains(TEST_LETTER_TEXT), WRONG_TEXT);

        messageBO.sendLastDraftMessage();
    }

    @AfterMethod
    private void tearDown() {
        //DriverProvider.quit();
    }
}
