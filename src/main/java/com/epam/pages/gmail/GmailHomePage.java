package com.epam.pages.gmail;

import com.epam.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailHomePage extends BasePage {
    @FindBy(xpath = "//*[@class=\"T-I T-I-KE L3\"]")
    private WebElement composeButton;

    @FindBy(xpath = "//*[@class='TK']/div[5]//a[@class='J-Ke n0']")
    private WebElement draftsFolder;

    @FindBy(xpath = "//*[@class=\"T-I T-I-KE L3\"]")
    private WebElement googleLogo;

    @FindBy(css = ".ae4.UI[gh='tl'] tr:nth-child(1)")
    private WebElement lastDraftMessage;

    @FindBy(css = "div.AD")
    private WebElement letterWindow;

    public GmailHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getGoogleLogo() {
        return googleLogo;
    }

    public void clickCompose() {
        composeButton.click();
    }

    public void clickDrafts() {
        draftsFolder.click();
    }

    public void clickLastDraftMessage() {
        lastDraftMessage.click();
    }

    public void goToDraftsAndClickLastDraftMessage() {
        clickDrafts();
        clickLastDraftMessage();
    }
}
