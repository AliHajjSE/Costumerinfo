package com.example.costumerinfo.service;
import com.twilio.Twilio;
import com.twilio.rest.lookups.v1.PhoneNumber;
import com.twilio.rest.lookups.v1.PhoneNumberFetcher;

import java.util.Arrays;
public class TwilioService {
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        for(int i=0;i< args.length;i++){
            System.out.println(i);
            System.out.println(args[i]);
        }
        System.out.println("(.)(.)");

        PhoneNumberFetcher phoneNumber = PhoneNumber.fetcher(
                        new com.twilio.type.PhoneNumber("+96171218095"));

        System.out.println(phoneNumber.setType(Arrays.asList("caller-name")).fetch() );
    }
}
//    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
//    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
//
//    public static void main(String[] args) {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        PhoneNumber phoneNumber = PhoneNumber.fetcher(
//                        new com.twilio.type.PhoneNumber("+15108675310"))
//                .setType(Arrays.asList("carrier")).fetch();
//
//        System.out.println(phoneNumber.getCarrier());