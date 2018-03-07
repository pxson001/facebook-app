package com.facebook;

/* compiled from: event_buy_tickets_button_impression */
public enum AccessTokenSource {
    NONE(false),
    FACEBOOK_APPLICATION_WEB(true),
    FACEBOOK_APPLICATION_NATIVE(true),
    FACEBOOK_APPLICATION_SERVICE(true),
    WEB_VIEW(false),
    TEST_USER(true),
    CLIENT_TOKEN(true),
    DEVICE_AUTH(true);
    
    private final boolean canExtendToken;

    private AccessTokenSource(boolean z) {
        this.canExtendToken = z;
    }

    public final boolean canExtendToken() {
        return this.canExtendToken;
    }
}
