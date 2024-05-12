package com.example.sms.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Component
public class SmsProvider {
    
    private final DefaultMessageService messageService;

    // 번호 가져오기
    @Value("${sms.from-number}") String FROM_NUMBER;

    public SmsProvider (
        @Value("${sms.api-key}") String API_KEY,
        @Value("${sms.api-secret-key}") String API_SECRET_KEY,
        @Value("${sms.domain}") String DOMAIN
    ) {
        this.messageService = NurigoApp.INSTANCE.initialize(API_KEY, API_SECRET_KEY, DOMAIN);
    }

    public boolean sendSms(String to) {
        // 메세지 생성
        Message message = new Message();
        message.setFrom(FROM_NUMBER);
        message.setTo(to);
        message.setText("안녕하세요1\n안녕하세요2\n하이3\n헬로4\n반가워5");

        // 메세지 전송
        SingleMessageSentResponse response = messageService.sendOne(new SingleMessageSendingRequest(message));
        
        // 메세지 전송 성공 시 상태 코드 발급
        String statusCode = response.getStatusCode();
        boolean result = statusCode.equals("2000");

        return result;
    }

}
