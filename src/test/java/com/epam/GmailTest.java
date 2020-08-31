package com.epam;

import com.epam.pages.gmail.GmailHomePage;
import com.epam.pages.gmail.GmailLoginPage;
import com.epam.pages.gmail.GmailMessageFormPage;
import com.epam.pages.gmail.GmailPasswordPage;
import com.epam.utils.Constants;
import com.epam.utils.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailTest implements Constants {
    private WebDriver webDriver;
    private GmailLoginPage gmailLoginPage;
    private GmailPasswordPage gmailPasswordPage;
    private GmailHomePage gmailHomePage;
    private GmailMessageFormPage gmailMessageFormPage;

    @BeforeClass
    private void setUp() {
        webDriver = DriverProvider.getInstance();
        webDriver.get(BASE_URL);
        gmailLoginPage = new GmailLoginPage(webDriver);
        gmailPasswordPage = new GmailPasswordPage(webDriver);
        gmailHomePage = new GmailHomePage(webDriver);
        gmailMessageFormPage = new GmailMessageFormPage(webDriver);
    }

    /*
     * Enter email, check does chosen profile link contains email. Enter password. Wait until new page will be opened
     * and element will be clickable on it. Check does page title contains email. Create new letter. Save it as draft.
     * Check if last draft letter contains needed emails, text and topic. Send saved letter.
     */
    @Test
    private void verifyDraftFieldsAreSavedCorrectly() {
        gmailLoginPage.enterEmailAndClickNextButton(TEST_EMAIL);
        Assert.assertTrue(gmailPasswordPage.getChosenProfileLinkAttribute().contains(TEST_EMAIL.toLowerCase()),
                "Not valid email.");

        gmailPasswordPage.enterEmailAndClickNextButton(TEST_PASSWORD);
        gmailHomePage.waitOnMailLogoToBeClickable();
        Assert.assertTrue(webDriver.getTitle().toLowerCase().contains(TEST_EMAIL.toLowerCase()),
                "Wrong password.");

        gmailHomePage.clickComposeButton();
        gmailMessageFormPage.createLetter(RECEIVER_EMAIL, CC_EMAIL, BCC_EMAIL, LETTER_TOPIC, LETTER_TEXT);
        gmailMessageFormPage.saveLetterAsDraftAndClose();

        gmailHomePage.goToDraftsFolderAndClickLastDraftMessage();
        Assert.assertTrue(gmailMessageFormPage.getEmailAttributeOfFilledToField().contains(RECEIVER_EMAIL),
                "Last draft letter doesn't contain created letter receiver.");
        Assert.assertTrue(gmailMessageFormPage.getEmailAttributeOfFilledCcField().contains(CC_EMAIL),
                "Last draft letter doesn't contain created letter cc receiver.");
        Assert.assertTrue(gmailMessageFormPage.getEmailAttributeOfFilledBccField().contains(BCC_EMAIL),
                "Last draft letter doesn't contain created letter bcc receiver.");
        Assert.assertTrue(gmailMessageFormPage.getFilledTopicFieldText().contains(LETTER_TOPIC),
                "Last draft letter doesn't contain created letter topic.");
        Assert.assertTrue(gmailMessageFormPage.getFilledLetterTextFieldText().contains(LETTER_TEXT),
                "Last draft letter doesn't contain created letter text.");
        gmailMessageFormPage.sendLetter();
    }

    @AfterClass
    private void quitDriver() {
        webDriver.quit();
    }
}
