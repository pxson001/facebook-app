package com.facebook.pages.common.logging.analytics;

import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent.PageEventType;

/* compiled from: media_fetcher_rule */
public enum TabSwitchEvent implements PageAnalyticsEvent {
    EVENT_VISIT_PAGE_TAB("visit_page_tab"),
    EVENT_VISIT_ACTIVITY_TAB("visit_activity_tab"),
    EVENT_VISIT_INSIGHTS_TAB("visit_insights_tab"),
    EVENT_VISIT_SETTINGS_TAB("visit_settings_tab"),
    EVENT_VISIT_MESSAGES_TAB(AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_MESSAGE.getName()),
    EVENT_VISIT_NOTIFICATIONS_TAB(AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_NOTIF.getName()),
    EVENT_VISIT_MORE_TAB("visit_more_tab"),
    EVENT_VISIT_OVERVIEW_TAB("visit_overview_tab"),
    EVENT_PRESENCE_TAB_SWITCH("page_presence_tab_switch");
    
    private String mEventName;

    private TabSwitchEvent(String str) {
        this.mEventName = str;
    }

    public final String getName() {
        return this.mEventName;
    }

    public final PageEventType getType() {
        return PageEventType.TAB_SWITCH;
    }
}
