package com.facebook.pages.common.logging.analytics;

import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent.PageEventType;

/* compiled from: media_item_cleared */
public enum RedirectionEvent implements PageAnalyticsEvent {
    EVENT_GLOBAL_PAGE_REDIRECTION("android_global_page_redirection");
    
    private String mEventName;

    private RedirectionEvent(String str) {
        this.mEventName = str;
    }

    public final String getName() {
        return this.mEventName;
    }

    public final PageEventType getType() {
        return PageEventType.REDIRECTION;
    }
}
