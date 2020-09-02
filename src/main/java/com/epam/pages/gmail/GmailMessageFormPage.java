package com.epam.pages.gmail;

import com.epam.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GmailMessageFormPage extends BasePage {
    @FindBy(name = "to")
    private WebElement toField;

    @FindBy(xpath = "//*[@class='aB gQ pE']")
    private WebElement ccAditionLink;

    @FindBy(name = "cc")
    private WebElement ccField;

    @FindBy(css = ".aB.gQ.pB")
    private WebElement bccAditionLink;

    @FindBy(name = "bcc")
    private WebElement bccField;

    @FindBy(name = "subjectbox")
    private WebElement topicFiled;

    @FindBy(xpath = "//*[@class=\"Am Al editable LW-avf tS-tW\"]")
    private WebElement letterTextFiled;

    @FindBy(css = ".T-I.J-J5-Ji.aoO.v7.T-I-atl.L3")
    private WebElement sendButton;

    @FindBy(css = "img.Ha")
    private WebElement saveAsDraftAndCloseButton;

    @FindBy(css = ".vN.bfK.a3q")
    private WebElement filledToField;

    @FindBy(css = ".vN.bfK.a3p")
    private WebElement filledCcField;

    @FindBy(xpath = "//*[@class=\"vN bfK\"]")
    private WebElement filledBccField;

    @FindBy(className = "aYF")
    private WebElement filledTopicField;

    public void enterReceiverEmail(String email) {
        waitOnEmailFieldToBeVisible(toField);
        toField.sendKeys(email);
    }

    public void displayCcField() {
        ccAditionLink.click();
    }

    public void enterCcEmail(String email) {
        waitOnEmailFieldToBeVisible(ccField);
        ccField.sendKeys(email);
    }

    public void displayBccField() {
        bccAditionLink.click();
    }

    public void enterBccEmail(String email) {
        waitOnEmailFieldToBeVisible(bccField);
        bccField.sendKeys(email);
    }

    public void enterTopic(String topic) {
        topicFiled.sendKeys(topic);
    }

    public void enterLetterText(String text) {
        letterTextFiled.sendKeys(text);
    }

    public String getEmailAttributeOfFilledToField() {
        return filledToField.getAttribute("email");
    }

    public String getEmailAttributeOfFilledCcField() {
        return filledCcField.getAttribute("email");
    }

    public String getEmailAttributeOfFilledBccField() {
        return filledBccField.getAttribute("email");
    }

    public String getFilledTopicFieldText() {
        return filledTopicField.getText();
    }

    public String getFilledLetterTextFieldText() {
        return letterTextFiled.getText();
    }

    public void sendLetter() {
        webDriverWait.until(ExpectedConditions.visibilityOf(saveAsDraftAndCloseButton));
        sendButton.click();
    }

    public void saveLetterAsDraftAndClose() {
        saveAsDraftAndCloseButton.click();
        waitOnToFieldToBeInvisible();
    }

    public void waitOnToFieldToBeInvisible() {
        webDriverWait.until(ExpectedConditions.invisibilityOf(toField));
    }

    public void waitOnEmailFieldToBeVisible(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}
