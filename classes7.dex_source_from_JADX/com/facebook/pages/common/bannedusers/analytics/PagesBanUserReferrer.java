package com.facebook.pages.common.bannedusers.analytics;

/* compiled from: message_rewrite_rule */
public enum PagesBanUserReferrer {
    COMMENTS("comments"),
    REACTORS("reactors"),
    MESSAGE_THREAD("message_thread"),
    MESSAGE_SENDER_CONTEXT("message_sender_context");
    
    private String mEventName;

    private PagesBanUserReferrer(String str) {
        this.mEventName = str;
    }

    public final String getName() {
        return this.mEventName;
    }
}
