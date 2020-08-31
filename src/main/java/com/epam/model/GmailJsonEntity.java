package com.epam.model;

import java.util.List;

public class GmailJsonEntity {
    private String topic;

    private String receiver;

    private String cc;

    private String bcc;

    private String letterText;

    private List<UserEntity> users;

    public GmailJsonEntity() {
    }

    public GmailJsonEntity(String topic, String receiver, String cc, String bcc, String letterText, List<UserEntity> users) {
        this.topic = topic;
        this.receiver = receiver;
        this.cc = cc;
        this.bcc = bcc;
        this.letterText = letterText;
        this.users = users;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getLetterText() {
        return letterText;
    }

    public void setLetterText(String letterText) {
        this.letterText = letterText;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
