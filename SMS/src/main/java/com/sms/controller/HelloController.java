package com.sms.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
public class HelloController {

    // Initialize your Twilio credentials
    private static final String ACCOUNT_SID = " ";
    private static final String AUTH_TOKEN = " "; // Replace with actual auth token
    private static final String FROM_PHONE_NUMBER = " "; // Replace with your Twilio phone number

    @GetMapping("/send/{toMobile}/{text}")
    public ResponseEntity<?> sendSms(@PathVariable("toMobile") String toMobile, 
                                     @PathVariable("text") String text) {
        // Initialize Twilio
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Send SMS using Twilio API
        Message message = Message.creator(
                new PhoneNumber(toMobile), // To mobile number
                new PhoneNumber(FROM_PHONE_NUMBER), // From Twilio number
                text // Message content
        ).create();

        // Return response
        return ResponseEntity.ok("Message sent to " + toMobile + ": " + text);
    }
}
