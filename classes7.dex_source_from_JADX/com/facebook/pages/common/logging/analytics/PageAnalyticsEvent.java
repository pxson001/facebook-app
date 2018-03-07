package com.facebook.pages.common.logging.analytics;

/* compiled from: message_cta_click */
public interface PageAnalyticsEvent {

    /* compiled from: message_cta_click */
    public enum PageEventType {
        TAP,
        ACTION,
        NETWORK,
        NETWORK_SUCCESS,
        NETWORK_FAILURE,
        ADMIN,
        ADMIN_ACTIVITY_TAB,
        ADMIN_ACTION_BAR,
        ADMIN_CONTACT_INBOX,
        VIEW,
        REDIRECTION,
        TAB_SWITCH,
        ADMIN_APPS_TAB,
        BOOKMARK,
        OTHER
    }

    String getName();

    PageEventType getType();
}
