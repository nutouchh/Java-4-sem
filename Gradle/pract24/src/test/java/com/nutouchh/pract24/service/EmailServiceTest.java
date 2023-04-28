package com.nutouchh.pract24.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailService emailService;

    @Before
    public void setUp() {
        when(mailSender.createMimeMessage()).thenReturn(new MimeMessage((Session)null));
    }

    @Test
    public void testSendEmail() {
        String className = "TestClass";
        String messageText = "Test message";

        emailService.sendEmail(className, messageText);

        verify(mailSender).send(any(SimpleMailMessage.class));

        ArgumentCaptor<SimpleMailMessage> messageCaptor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(mailSender).send(messageCaptor.capture());

        SimpleMailMessage message = messageCaptor.getValue();
        assertEquals("chas0vskih@yandex.ru", message.getFrom());
        assertEquals("chas0vskih@yandex.ru", message.getTo()[0]);
        assertEquals(className + " saved at " + DateTimeFormatter.
                ofLocalizedDateTime(FormatStyle.SHORT).format(LocalDateTime.now()), message.getSubject());
        assertEquals(messageText, message.getText());
    }
}
