package com.epam.pages.gmail;

import com.epam.pages.BasePage;
import org.openqa.selenium.WebDriver;
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

    public GmailPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterEmail(String password) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.sendKeys(password);
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public String getChosenProfileLinkAttribute() {
        return chosenProfileLink.getAttribute("aria-label");
    }

    public void enterEmailAndClickNextButton(String password) {
        enterEmail(password);
        clickNextButton();
    }
}
