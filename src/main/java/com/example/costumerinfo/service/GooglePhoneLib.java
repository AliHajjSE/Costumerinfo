package com.example.costumerinfo.service;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class GooglePhoneLib {


    public static boolean isPhoneNumberValid(String phoneStr) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        PhoneNumber thePhoneNumber = null; // The class which represent
        // a phone number
        System.out.println("THIS IS THE PHONE NUMBER:"+phoneStr);
        try {
            thePhoneNumber = phoneUtil.parse(phoneStr, "IN");
        } catch (NumberParseException e) {
            System.err.println("Cannot parse the given phone number string "
                    + phoneStr);
            e.printStackTrace();
        }

        return phoneUtil.isValidNumber(thePhoneNumber);


        // Now, let's validate phone number

    }
    }
