package com.carta.domain;

public class EmailMessage {
    private final String subject;
    private final String body;
    public EmailMessage(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }
}
