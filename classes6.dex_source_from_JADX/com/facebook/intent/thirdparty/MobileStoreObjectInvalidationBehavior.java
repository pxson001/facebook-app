package com.facebook.intent.thirdparty;

import java.util.Locale;
import javax.annotation.Nullable;

/* compiled from: mComposerPromptText */
public enum MobileStoreObjectInvalidationBehavior {
    NONE,
    INSTALLED,
    NOT_INSTALLED;

    public static MobileStoreObjectInvalidationBehavior fromString(@Nullable String str) {
        if (str == null) {
            return NONE;
        }
        try {
            return valueOf(str.toUpperCase(Locale.US));
        } catch (IllegalArgumentException e) {
            return NONE;
        }
    }
}
