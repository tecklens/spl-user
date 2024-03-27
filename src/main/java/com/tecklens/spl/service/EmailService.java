package com.tecklens.spl.service;

import com.tecklens.spl.dto.EmailDto;

public interface EmailService {
    void sendSimpleMessage(EmailDto email);
}
