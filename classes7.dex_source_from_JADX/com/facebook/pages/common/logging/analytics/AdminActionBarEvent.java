package com.facebook.pages.common.logging.analytics;

import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent.PageEventType;

/* compiled from: message_body */
public enum AdminActionBarEvent implements PageAnalyticsEvent {
    EVENT_ADMIN_WRITE_POST("admin_tapped_post"),
    EVENT_ADMIN_SHARE_PHOTO("admin_tapped_photo"),
    EVENT_ADMIN_EDIT_PAGE("admin_tapped_edit_page"),
    EVENT_ADMIN_SETTINGS("admin_tapped_settings"),
    EVENT_ADMIN_PROMOTE("admin_tapped_promote"),
    EVENT_ADMIN_ADD_TO_FAVORITES("admin_tapped_add_to_favorites"),
    EVENT_ADMIN_REMOVE_FROM_FAVORTIES("admin_tapped_remove_from_favorites"),
    EVENT_ADMIN_ADD_EVENT("admin_tapped_event"),
    EVENT_ADMIN_SHARE_VIDEO("admin_tapped_video");
    
    private String mEventName;

    private AdminActionBarEvent(String str) {
        this.mEventName = str;
    }

    public final String getName() {
        return this.mEventName;
    }

    public final PageEventType getType() {
        return PageEventType.ADMIN_ACTION_BAR;
    }
}
