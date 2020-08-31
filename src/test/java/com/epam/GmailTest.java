package com.epam;

import com.epam.pages.gmail.GmailHomePage;
import com.epam.pages.gmail.GmailLoginPage;
import com.epam.pages.gmail.GmailMessageFormPage;
import com.epam.pages.gmail.GmailPasswordPage;
import com.epam.utils.Constants;
import com.epam.utils.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @Test
    private void verifyLogin() {
        verifyValidEmail();
        verifyPassword();
    }

    /*
     * Enter email, check does chosen profile link contains email
     */
    private void verifyValidEmail() {
        gmailLoginPage.enterEmailAndClickNext(TEST_EMAIL);
        Assert.assertTrue(gmailPasswordPage.getChosenProfileLinkAttribute()
                .contains(TEST_EMAIL.toLowerCase()), "Not valid email.");
    }

    /*
     * Enter password. Wait until new page will be opened and element will be clickable on it
     * Check does page title contains email
     */
    private void verifyPassword() {
        gmailPasswordPage.enterEmailAndClickNext(TEST_PASSWORD);
        (new WebDriverWait(webDriver, TIME_WAIT))
                .until(ExpectedConditions.elementToBeClickable(gmailHomePage.getGoogleLogo()));
        Assert.assertTrue(webDriver.getTitle().toLowerCase()
                .contains(TEST_EMAIL.toLowerCase()), "Wrong password.");
    }

    /*
     * Create new letter
     * Wait until link in pop-up message about letter status will be clickable
     * Check if last sent letter contains needed email, text and topic
     */
    @Test(dependsOnMethods = "verifyLogin")
    private void verifyDraftLetterCreation() {
        createLetter();
        gmailHomePage.goToDraftsAndClickLastDraftMessage();
        Assert.assertTrue(gmailMessageFormPage.getFilledReceiverEmailAttribute().contains(RECEIVER_EMAIL),
                "Last draft letter doesn't contain created letter receiver.");
        Assert.assertTrue(gmailMessageFormPage.getFilledCcEmailAttribute().contains(CC_EMAIL),
                "Last draft letter doesn't contain created letter cc receiver.");
        Assert.assertTrue(gmailMessageFormPage.getFilledBccEmailAttribute().contains(BCC_EMAIL),
                "Last draft letter doesn't contain created letter bcc receiver.");
        Assert.assertTrue(gmailMessageFormPage.getFilledTopicFieldText().contains(LETTER_TOPIC),
                "Last draft letter doesn't contain created letter topic.");
        Assert.assertTrue(gmailMessageFormPage.getFilledLetterTextFieldText().contains(LETTER_TEXT),
                "Last draft letter doesn't contain created letter text.");
        gmailMessageFormPage.sendLetter();
    }

    private void createLetter() {
        gmailHomePage.clickCompose();
        gmailMessageFormPage.createLetter(RECEIVER_EMAIL, CC_EMAIL, BCC_EMAIL, LETTER_TOPIC, LETTER_TEXT);
        gmailMessageFormPage.saveAndClose();
    }

    @AfterClass
    private void quitDriver() {
        webDriver.quit();
    }
}
