package com.facebook.pages.common.logging.analytics;

import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent.PageEventType;

/* compiled from: message_color */
public enum ActionEvent implements PageAnalyticsEvent {
    EVENT_COMMENT_RECENT_POST("comment_on_recent_post"),
    EVENT_SHARE_RECENT_POST("share_recent_post"),
    EVENT_SHARE_STORY("share_story"),
    EVENT_COMMENT_STORY("comment_story"),
    EVENT_NON_ADMIN_WRITE_POST("non_admin_write_post"),
    EVENT_NON_ADMIN_SHARE_PHOTO("non_admin_share_photo");
    
    private String mEventName;

    private ActionEvent(String str) {
        this.mEventName = str;
    }

    public final String getName() {
        return this.mEventName;
    }

    public final PageEventType getType() {
        return PageEventType.ACTION;
    }
}
