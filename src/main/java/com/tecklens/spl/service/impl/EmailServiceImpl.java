package com.tecklens.spl.service.impl;

import com.tecklens.spl.dto.EmailDto;
import com.tecklens.spl.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender emailSender;

    @Override
    public void sendSimpleMessage(
            EmailDto email
    ) {
        if (email == null) return;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getFrom());
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getText());
        if (email.getCc() != null)
            message.setCc(email.getCc().toArray(String[]::new));
        emailSender.send(message);
    }
}
