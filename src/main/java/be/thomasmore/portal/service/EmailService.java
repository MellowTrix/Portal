package be.thomasmore.portal.service;


public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);

}
