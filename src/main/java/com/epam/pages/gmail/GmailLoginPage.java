package com.epam.pages.gmail;

import com.epam.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPage extends BasePage {
    @FindBy(id = "identifierId")
    private WebElement emailInput;

    @FindBy(className = "VfPpkd-RLmnJb")
    private WebElement nextButton;

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void clickNextButton() {
        nextButton.click();
    }
}
