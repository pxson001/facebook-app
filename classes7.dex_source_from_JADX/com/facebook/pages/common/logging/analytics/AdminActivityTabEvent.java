package com.facebook.pages.common.logging.analytics;

import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent.PageEventType;

/* compiled from: message_before */
public enum AdminActivityTabEvent implements PageAnalyticsEvent {
    EVENT_ADMIN_ACTIVITY_CLICK_NOTIF("admin_click_notif"),
    EVENT_ADMIN_ACTIVITY_CLICK_NEW_LIKES("admin_click_new_likes"),
    EVENT_ADMIN_ACTIVITY_CLICK_SCHEDULED_POST("admin_click_scheduled_post"),
    EVENT_ADMIN_ACTIVITY_CLICK_MESSAGE("admin_click_message"),
    EVENT_ADMIN_ACTIVITY_CLICK_EDIT_UNI_STATUS("admin_click_edit_boosted_pagelike_status"),
    EVENT_ADMIN_ACTIVITY_CLICK_INSIGHTS_WEEKLY_LIKE("admin_click_insights_graph_weekly_like"),
    EVENT_ADMIN_ACTIVITY_CLICK_INSIGHTS_WEEKLY_POST_REACH("admin_click_insights_graph_weekly_post_reach"),
    EVENT_ADMIN_ACTIVITY_CLICK_PAGES_FEED("admin_click_pages_feed"),
    EVENT_ADMIN_ACTIVITY_CLICK_ADMIN_FEED("admin_click_admin_feed"),
    EVENT_ADMIN_ACTIVITY_CLICK_RECENT_ACTIVITY("admin_click_recent_activity"),
    EVENT_ADMIN_ACTIVITY_CLICK_RECENT_MENTIONS("admin_click_recent_mentions"),
    EVENT_ADMIN_ACTIVITY_CLICK_RECENT_SHARES("admin_click_recent_shares"),
    EVENT_ADMIN_ACTIVITY_CLICK_RECENT_REVIEWS("admin_click_recent_reviews"),
    EVENT_ADMIN_ACTIVITY_CLICK_RECENT_CHECK_INS("admin_click_recent_check_ins"),
    EVENT_ADMIN_ACTIVITY_CLICK_DRAFT_POST("admin_click_draft_post"),
    EVENT_ADMIN_ACTIVITY_CLICK_PAGE_TIPS("admin_click_page_tips");
    
    private String mEventName;

    private AdminActivityTabEvent(String str) {
        this.mEventName = str;
    }

    public final String getName() {
        return this.mEventName;
    }

    public final PageEventType getType() {
        return PageEventType.ADMIN_ACTIVITY_TAB;
    }
}
