package com.facebook.phonenumbers;

import com.facebook.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource;

/* compiled from: db_size */
/* synthetic */ class PhoneNumberUtil$4 {
    static final /* synthetic */ int[] f5210x59d5eb16 = new int[PhoneNumberUtil$PhoneNumberFormat.values().length];
    static final /* synthetic */ int[] f5211x1e7cbe19 = new int[PhoneNumberUtil$PhoneNumberType.values().length];
    static final /* synthetic */ int[] f5212x5137fd97 = new int[CountryCodeSource.values().length];

    static {
        try {
            f5211x1e7cbe19[PhoneNumberUtil$PhoneNumberType.PREMIUM_RATE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f5211x1e7cbe19[PhoneNumberUtil$PhoneNumberType.TOLL_FREE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f5211x1e7cbe19[PhoneNumberUtil$PhoneNumberType.MOBILE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f5211x1e7cbe19[PhoneNumberUtil$PhoneNumberType.FIXED_LINE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f5211x1e7cbe19[PhoneNumberUtil$PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f5211x1e7cbe19[PhoneNumberUtil$PhoneNumberType.SHARED_COST.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f5211x1e7cbe19[PhoneNumberUtil$PhoneNumberType.VOIP.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f5211x1e7cbe19[PhoneNumberUtil$PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f5211x1e7cbe19[PhoneNumberUtil$PhoneNumberType.PAGER.ordinal()] = 9;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f5211x1e7cbe19[PhoneNumberUtil$PhoneNumberType.UAN.ordinal()] = 10;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f5211x1e7cbe19[PhoneNumberUtil$PhoneNumberType.VOICEMAIL.ordinal()] = 11;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f5210x59d5eb16[PhoneNumberUtil$PhoneNumberFormat.E164.ordinal()] = 1;
        } catch (NoSuchFieldError e12) {
        }
        try {
            f5210x59d5eb16[PhoneNumberUtil$PhoneNumberFormat.INTERNATIONAL.ordinal()] = 2;
        } catch (NoSuchFieldError e13) {
        }
        try {
            f5210x59d5eb16[PhoneNumberUtil$PhoneNumberFormat.RFC3966.ordinal()] = 3;
        } catch (NoSuchFieldError e14) {
        }
        try {
            f5210x59d5eb16[PhoneNumberUtil$PhoneNumberFormat.NATIONAL.ordinal()] = 4;
        } catch (NoSuchFieldError e15) {
        }
        try {
            f5212x5137fd97[CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;
        } catch (NoSuchFieldError e16) {
        }
        try {
            f5212x5137fd97[CountryCodeSource.FROM_NUMBER_WITH_IDD.ordinal()] = 2;
        } catch (NoSuchFieldError e17) {
        }
        try {
            f5212x5137fd97[CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;
        } catch (NoSuchFieldError e18) {
        }
        try {
            f5212x5137fd97[CountryCodeSource.FROM_DEFAULT_COUNTRY.ordinal()] = 4;
        } catch (NoSuchFieldError e19) {
        }
    }
}
