package com.epam.pages.gmail;

import com.epam.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailMessageFormPage extends BasePage {
    @FindBy(name = "to")
    private WebElement sentToField;

    @FindBy(xpath = "//*[@class='aB gQ pE']")
    private WebElement sentCcAddition;

    @FindBy(name = "cc")
    private WebElement sentCcField;

    @FindBy(css = ".aB.gQ.pB")
    private WebElement sentBccAddition;

    @FindBy(name = "bcc")
    private WebElement sentBccField;

    @FindBy(name = "subjectbox")
    private WebElement topicFiled;

    @FindBy(xpath = "//*[@class=\"Am Al editable LW-avf tS-tW\"]")
    private WebElement letterTextFiled;

    @FindBy(css = ".T-I.J-J5-Ji.aoO.v7.T-I-atl.L3")
    private WebElement sendButton;

    @FindBy(css = "img.Ha")
    private WebElement saveAndCloseButton;

    @FindBy(className = "aDp")
    private WebElement otherReceivers;

    @FindBy(css = ".vN.bfK.a3q")
    private WebElement filledToField;

    @FindBy(css = ".vN.bfK.a3p")
    private WebElement filledCcField;

    @FindBy(xpath = "//*[@class=\"vN bfK\"]")
    private WebElement filledBccField;

    @FindBy(className = "aYF")
    private WebElement filledTopic;

    public WebElement getSentToField() {
        return sentToField;
    }

    public GmailMessageFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterReceiverEmail(String email) {
        sentToField.sendKeys(email);
    }

    public void enterCcEmail(String email) {
        sentCcAddition.click();
        sentCcField.sendKeys(email);
    }

    public void enterBccEmail(String email) {
        sentBccAddition.click();
        sentBccField.sendKeys(email);
    }

    public void enterTopic(String topic) {
        topicFiled.sendKeys(topic);
    }

    public void enterLetterText(String text) {
        letterTextFiled.sendKeys(text);
    }

    public void sendLetter() {
        sendButton.click();
    }

    public void saveAndClose() {
        saveAndCloseButton.click();
    }

    public void createLetter(String receiverEmail, String ccEmail, String bccEmail, String topic, String text) {
        enterReceiverEmail(receiverEmail);
        enterCcEmail(ccEmail);
        enterBccEmail(bccEmail);
        enterTopic(topic);
        enterLetterText(text);
    }

    public String getFilledReceiverEmailAttribute() {
        return filledToField.getAttribute("email");
    }

    public String getFilledCcEmailAttribute() {
        return filledCcField.getAttribute("email");
    }

    public String getFilledBccEmailAttribute() {
        return filledBccField.getAttribute("email");
    }

    public String getFilledTopicFieldText() {
        return filledTopic.getText();
    }

    public String getFilledLetterTextFieldText() {
        return letterTextFiled.getText();
    }
}
