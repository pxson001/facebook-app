package com.facebook.pages.common.logging.analytics;

import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent.PageEventType;

/* compiled from: media_ */
public enum ViewEvents implements PageAnalyticsEvent {
    EVENT_VIEW_RECENT_POST("view_recent_post"),
    EVENT_VIEWED_PHOTO("viewed_photo"),
    EVENT_VIEWED_PAGE_POST("viewed_page_post"),
    EVENT_VIEWED_FB_EVENT("viewed_event"),
    EVENT_VIEWED_SETTINGS("view_settings"),
    EVENT_SHOWN_UNIT("shown_unit"),
    PAGE_EVENT_VIEW_SAVE_ACTION("view_save_action"),
    PAGE_EVENT_VIEW_CONSUME_ACTION("view_consume_action"),
    PAGE_EVENT_VIEW_DEEPLINK_ACTION("view_deeplink_action"),
    PAGE_EVENT_VIEW_SERVICES_CARD_NUX("page_service_card_impression"),
    PAGE_EVENT_VIEW_SERVICES_CARD("page_service_card_client_impression"),
    PAGE_EVENT_VIEW_GET_NOTIFICATION_ERROR("page_get_notification_error");
    
    private String mEventName;

    private ViewEvents(String str) {
        this.mEventName = str;
    }

    public final String getName() {
        return this.mEventName;
    }

    public final PageEventType getType() {
        return PageEventType.VIEW;
    }
}
