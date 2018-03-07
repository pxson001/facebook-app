package com.facebook.confirmation.constants;

import javax.annotation.Nullable;

/* compiled from: invalid_story_types */
public enum ConfFragmentState {
    CODE_SUCCESS,
    EMAIL_ACQUIRED,
    PHONE_ACQUIRED,
    UPDATE_PHONE,
    UPDATE_EMAIL,
    EMAIL_SWITCH_TO_PHONE,
    PHONE_SWITCH_TO_EMAIL,
    UNKNOWN_ERROR;

    public final String getKey() {
        return "com.facebook.confirmation." + name();
    }

    @Nullable
    public static ConfFragmentState valueOfKey(String str) {
        ConfFragmentState confFragmentState = null;
        if (str != null && str.startsWith("com.facebook.confirmation.")) {
            try {
                confFragmentState = valueOf(str.substring(26));
            } catch (Exception e) {
            }
        }
        return confFragmentState;
    }
}
