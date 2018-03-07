package com.facebook.registration.constants;

import javax.annotation.Nullable;

/* compiled from: leave feedback */
public enum RegFragmentState {
    START_COMPLETED,
    TERMS_ACCEPTED,
    PHONE_ACQUIRED,
    PHONE_SWITCH_TO_EMAIL,
    EMAIL_ACQUIRED,
    EMAIL_SWITCH_TO_PHONE,
    NAME_ACQUIRED,
    BIRTHDAY_ACQUIRED,
    GENDER_ACQUIRED,
    PASSWORD_ACQUIRED,
    CREATE_ERROR,
    VALIDATION_START,
    VALIDATION_SUCCESS,
    VALIDATION_ERROR,
    CREATE_SUCCESS,
    ERROR_CONTINUE,
    UNKNOWN_ERROR,
    ADDITIONAL_EMAIL_ACQUIRED;

    public final String getKey() {
        return "com.facebook.registration." + name();
    }

    @Nullable
    public static RegFragmentState valueOfKey(String str) {
        RegFragmentState regFragmentState = null;
        if (str != null && str.startsWith("com.facebook.registration.")) {
            try {
                regFragmentState = valueOf(str.substring(26));
            } catch (Exception e) {
            }
        }
        return regFragmentState;
    }
}
