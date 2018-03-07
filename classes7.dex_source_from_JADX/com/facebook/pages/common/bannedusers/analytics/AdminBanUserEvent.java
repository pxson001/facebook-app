package com.facebook.pages.common.bannedusers.analytics;

/* compiled from: message_snippet */
public enum AdminBanUserEvent {
    FB4A_BAN_USER_ACTIONS("android_pages_ban_actions"),
    PMA_BAN_USER_ACTIONS("android_pma_ban_actions");
    
    private String mEventName;

    private AdminBanUserEvent(String str) {
        this.mEventName = str;
    }

    public final String getName() {
        return this.mEventName;
    }
}
