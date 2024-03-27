package com.tecklens.spl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class SmsController {

    @PostMapping("/send")
    public ResponseEntity<String> sendSms(@RequestBody String req) {
        return ResponseEntity.ok("");
    }
}
