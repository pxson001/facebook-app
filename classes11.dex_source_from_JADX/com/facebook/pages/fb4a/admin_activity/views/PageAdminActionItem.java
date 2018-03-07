package com.facebook.pages.fb4a.admin_activity.views;

import com.facebook.common.fblinks.FBLinks;
import com.facebook.pages.common.constants.PagesConstants.URL;
import com.facebook.pages.common.logging.analytics.AdminActivityTabEvent;

/* compiled from: quick_promotion_feed */
public enum PageAdminActionItem {
    MESSAGES(2131565348, FBLinks.aA, AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_MESSAGE),
    NOTIFICATIONS(2131565349, URL.k, AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_NOTIF),
    PAGES_FEED(2131565350, URL.l, AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_PAGES_FEED),
    NEW_LIKES(2131565352, "http://m.facebook.com/browse/fans/?recentFirst=1&id=%s", AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_NEW_LIKES),
    SCHEDULED_POSTS(2131565353, URL.s, AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_SCHEDULED_POST),
    DRAFTS(2131565354, URL.t, AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_DRAFT_POST),
    RECENT_ACTIVITY(2131565356, URL.m, AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_RECENT_ACTIVITY),
    RECENT_MENTIONS(2131565357, URL.n, AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_RECENT_MENTIONS),
    RECENT_SHARES(2131565358, URL.o, AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_RECENT_MENTIONS),
    RECENT_REVIEWS(2131565359, URL.p, AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_RECENT_REVIEWS),
    RECENT_CHECK_INS(2131565360, URL.q, AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_RECENT_CHECK_INS),
    PAGE_TIPS(2131565351, URL.H, AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_PAGE_TIPS);
    
    public final AdminActivityTabEvent loggingEvent;
    public final int resId;
    public final String uri;

    private PageAdminActionItem(int i, String str, AdminActivityTabEvent adminActivityTabEvent) {
        this.resId = i;
        this.uri = str;
        this.loggingEvent = adminActivityTabEvent;
    }
}
