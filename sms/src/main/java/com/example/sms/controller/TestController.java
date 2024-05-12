package com.example.sms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.service.TestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    
    private final TestService testService;
    
    // to 자리에 메세지 전송할 번호 입력
    @PostMapping("/send-sms/{to}")
    public ResponseEntity<String> sendSms (
        @PathVariable("to") String to
    ) {
        ResponseEntity<String> response = testService.sendSms(to);
        return response;
    }

}
