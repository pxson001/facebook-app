package com.facebook.messaging.sms.abtest;

import javax.annotation.Nullable;

/* compiled from: is_dff_enabled */
public enum SmsPromotionStyle {
    INTERSTITIAL_BUBBLES,
    INTERSTITIAL_GORILLA,
    INTERSTITIAL_SIMPLE_ANIMATIONS,
    INTERSTITIAL_COOL_ANIMATIONS;

    public final String toString() {
        switch (this) {
            case INTERSTITIAL_BUBBLES:
                return "full_interstitial_bubble";
            case INTERSTITIAL_GORILLA:
                return "full_interstitial_gorilla";
            case INTERSTITIAL_SIMPLE_ANIMATIONS:
                return "full_interstitial_simple_animations";
            case INTERSTITIAL_COOL_ANIMATIONS:
                return "full_interstitial_cool_animations";
            default:
                throw new IllegalArgumentException();
        }
    }

    @Nullable
    public static SmsPromotionStyle fromOrdinal(int i) {
        if (i < 0) {
            return null;
        }
        return values()[i];
    }
}
