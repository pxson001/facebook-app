package com.facebook.pages.common.logging.analytics;

import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent.PageEventType;

/* compiled from: memclass */
public enum NetworkEvent implements PageAnalyticsEvent {
    EVENT_PAGE_DETAILS_PARALLEL_FETCH_STARTED("page_header_parallel_fetch_started");
    
    private String mEventName;

    private NetworkEvent(String str) {
        this.mEventName = str;
    }

    public final String getName() {
        return this.mEventName;
    }

    public final PageEventType getType() {
        return PageEventType.TAP;
    }
}
