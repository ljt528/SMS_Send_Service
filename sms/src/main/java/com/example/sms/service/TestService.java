package com.example.sms.service;

import org.springframework.http.ResponseEntity;

public interface TestService {
    
    // 전화번호 받아옴
    ResponseEntity<String> sendSms(String to);

}
