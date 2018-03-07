package com.facebook.messaging.attribution;

/* compiled from: p2p_add_shipping_address */
public enum AttributionActionType {
    PLATFORM_APP_INSTALL(2131231767, "install"),
    PLATFORM_APP_REPLY(2131231768, "reply"),
    PLATFORM_APP_OPEN(2131231769, "open"),
    INTERNAL_FEATURE_REPLY(2131231768, "composer_reply"),
    MONTAGE_ADD(2131231838, "montage_add");
    
    public final int callToActionStringResId;
    public final String loggingString;

    private AttributionActionType(int i, String str) {
        this.callToActionStringResId = i;
        this.loggingString = str;
    }
}
