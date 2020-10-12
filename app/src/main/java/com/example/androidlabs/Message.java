package com.example.androidlabs;

public class Message {
    private String message;
    private Boolean isReceivedMessage;

    public Message(String message, Boolean isReceivedMessage) {
        this.message = message;
        this.isReceivedMessage = isReceivedMessage;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setReceivedMessage(Boolean receivedMessage) {
        isReceivedMessage = receivedMessage;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getReceivedMessage() {
        return isReceivedMessage;
    }
}
