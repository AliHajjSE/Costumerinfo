package com.example.costumerinfo.service;
import com.twilio.Twilio;
import com.twilio.rest.lookups.v1.PhoneNumber;

import java.util.Arrays;
public class TwilioService {
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public PhoneNumber validate(String number) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        PhoneNumber phoneNumber = PhoneNumber.fetcher(
                        new com.twilio.type.PhoneNumber(number))
                .setType(Arrays.asList("caller-name")).fetch();
//        System.out.println(phoneNumber);
        return phoneNumber;
    }
}
