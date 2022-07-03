package com.gusrylmubarok.spring.loginregistration.repository;

public interface EmailSender {
    void send(String to, String email);
}
