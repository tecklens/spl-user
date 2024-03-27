package com.tecklens.spl.service;

import com.tecklens.spl.dto.EmailDto;

public interface SmsService {
    void sendMessageZalo(EmailDto email);
}
