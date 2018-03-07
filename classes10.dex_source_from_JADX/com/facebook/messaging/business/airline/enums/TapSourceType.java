package com.facebook.messaging.business.airline.enums;

/* compiled from: thread_menu_dialog */
public enum TapSourceType {
    CONFIRMATION_BUBBLE("confirmation_bubble"),
    CHECK_IN_BUBBLE("check_in_bubble"),
    BOARDING_PASS_BUBBLE("boarding_pass_bubble"),
    BOARDING_PASS_SHARE("boarding_pass_share"),
    BOARDING_PASS_MESSAGE("boarding_pass_message");
    
    private final String mValue;

    private TapSourceType(String str) {
        this.mValue = str;
    }

    public final String getValue() {
        return this.mValue;
    }
}
