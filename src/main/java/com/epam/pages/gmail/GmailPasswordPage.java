package com.epam.pages.gmail;

import com.epam.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GmailPasswordPage extends BasePage {
    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(className = "VfPpkd-RLmnJb")
    private WebElement nextButton;

    @FindBy(css = "div.aCayab > div")
    private WebElement chosenProfileLink;

    public void enterEmail(String password) {
        waitOnElementToBeClickable(passwordInput);
        passwordInput.sendKeys(password);
    }

    public void clickNextButton() {
        waitOnElementToBeClickable(nextButton);
        nextButton.click();
    }

    private void waitOnElementToBeClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getChosenProfileLinkAttribute() {
        return chosenProfileLink.getAttribute("aria-label");
    }
}
