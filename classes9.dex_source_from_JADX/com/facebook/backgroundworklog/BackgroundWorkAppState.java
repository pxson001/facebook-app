package com.facebook.backgroundworklog;

import java.util.EnumSet;

/* compiled from: selectedPaymentMethod */
public enum BackgroundWorkAppState {
    INITIALIZING,
    LOADING,
    BACKGROUND,
    LOADING_UI,
    INTERACTIVE;

    public static String statesToString(EnumSet<BackgroundWorkAppState> enumSet) {
        return enumSet.isEmpty() ? "[IDLE]" : enumSet.toString();
    }
}
