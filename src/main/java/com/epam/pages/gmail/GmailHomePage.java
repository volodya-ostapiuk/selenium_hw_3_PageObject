package com.epam.pages.gmail;

import com.epam.decorator.elements.Button;
import com.epam.decorator.elements.Link;
import com.epam.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GmailHomePage extends BasePage {
    @FindBy(xpath = "//*[@class=\"T-I T-I-KE L3\"]")
    private Button composeButton;

    @FindBy(xpath = "//*[@class='TK']/div[5]//a[@class='J-Ke n0']")
    private Link draftsFolder;

    @FindBy(xpath = "//*[@class=\"T-I T-I-KE L3\"]")
    private Link mailLogo;

    @FindBy(css = ".ae4.UI[gh='tl'] tr:nth-child(1)")
    private Link lastDraftMessage;

    public void waitOnMailLogoToBeClickable() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(mailLogo.getElement()));
    }

    public void clickComposeButton() {
        composeButton.click();
    }

    public void clickDraftsFolder() {
        draftsFolder.click();
    }

    public void clickLastDraftMessage() {
        lastDraftMessage.click();
    }
}
