package com.facebook.quickpromotion.filter;

/* compiled from: reaction_page_load */
public enum QuickPromotionUserEvent {
    MESSAGE_SENT,
    MESSAGE_RECEIVED,
    THREAD_ACTIVITY;

    public final String toEventName() {
        return "QuickPromotionUserEvent:" + name();
    }
}
