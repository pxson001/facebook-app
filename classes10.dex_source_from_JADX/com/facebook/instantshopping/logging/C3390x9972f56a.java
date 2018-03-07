package com.facebook.instantshopping.logging;

/* compiled from: ShareType.inviteEntryPoint */
public enum C3390x9972f56a {
    DOCUMENT_BACK_BUTTON_PRESSED("document_back_button_pressed"),
    ANDROID_BACK_BUTTON_PRESSED("android_back_button_pressed"),
    DOCUMENT_SWIPED_BACK("document_swipped_back"),
    DOCUMENT_CLOSED_ON_PRELAUNCH("document_closed_on_prelaunch"),
    UNKNOWN("unknown");
    
    private final String mBackButtonReason;

    private C3390x9972f56a(String str) {
        this.mBackButtonReason = str;
    }

    public final String toString() {
        return this.mBackButtonReason;
    }
}
