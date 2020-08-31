package com.epam.pages.gmail;

import com.epam.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public WebElement getNextButton() {
        return nextButton;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getChosenProfileLink() {
        return chosenProfileLink;
    }

    public void enterEmail(String password) {
        (new WebDriverWait(webDriver, 30))
                .until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.sendKeys(password);
    }

    public void clickNext() {
        nextButton.click();
    }

    public String getChosenProfileLinkAttribute() {
        return chosenProfileLink.getAttribute("aria-label");
    }

    public void enterEmailAndClickNext(String password) {
        enterEmail(password);
        clickNext();
    }
}
