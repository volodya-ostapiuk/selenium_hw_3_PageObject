package com.epam.business;

import com.epam.model.MessageEntity;
import com.epam.pages.gmail.GmailHomePage;
import com.epam.pages.gmail.GmailMessageFormPage;

public class GmailMessageBO {
    private GmailHomePage homePage;
    private GmailMessageFormPage messageFormPage;

    public GmailMessageBO() {
        homePage = new GmailHomePage();
        messageFormPage = new GmailMessageFormPage();
    }

    public void createDraftMessage(MessageEntity message) {
        homePage.clickComposeButton();
        fillDraftMessage(message);
        messageFormPage.saveLetterAsDraftAndClose();
    }

    private void fillDraftMessage(MessageEntity message) {
        messageFormPage.enterReceiverEmail(message.getReceiver());
        messageFormPage.displayCcField();
        messageFormPage.enterCcEmail(message.getCc());
        messageFormPage.displayBccField();
        messageFormPage.enterBccEmail(message.getBcc());
        messageFormPage.enterTopic(message.getTopic());
        messageFormPage.enterLetterText(message.getLetterText());
    }

    public void goToDraftsFolderAndClickLastDraftMessage() {
        homePage.clickDraftsFolder();
        homePage.clickLastDraftMessage();
    }

    public MessageEntity getDraftMessageEntity() {
        String filledToField = messageFormPage.getEmailAttributeOfFilledToField();
        String filledCcField = messageFormPage.getEmailAttributeOfFilledCcField();
        String filledBccField = messageFormPage.getEmailAttributeOfFilledBccField();
        String filledTopicField = messageFormPage.getFilledTopicFieldText();
        String filledTextField = messageFormPage.getFilledLetterTextFieldText();
        return new MessageEntity(filledTopicField, filledToField, filledCcField, filledBccField, filledTextField);
    }

    public void sendLastDraftMessage() {
        messageFormPage.sendLetter();
        messageFormPage.waitOnToFieldToBeInvisible();
    }
}
