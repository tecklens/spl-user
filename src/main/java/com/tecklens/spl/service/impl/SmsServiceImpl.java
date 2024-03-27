package com.tecklens.spl.service.impl;

import com.tecklens.spl.dto.EmailDto;
import com.tecklens.spl.service.SmsService;
import com.vng.zalo.sdk.oa.ZaloOaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SmsServiceImpl implements SmsService {
    @Override
    public void sendMessageZalo(EmailDto email) {
        ZaloOaClient client = new ZaloOaClient();
        String access_token = "your_access_token";
    }
}
