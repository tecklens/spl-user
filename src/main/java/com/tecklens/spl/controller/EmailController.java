package com.tecklens.spl.controller;

import com.tecklens.spl.dto.EmailDto;
import com.tecklens.spl.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailDto req) {
        emailService.sendSimpleMessage(req);
        return ResponseEntity.ok("");
    }
}
