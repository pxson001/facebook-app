package com.facebook.pages.common.logging.analytics;

import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent.PageEventType;

/* compiled from: meme_url */
public enum AdminEvent implements PageAnalyticsEvent {
    EVENT_ADMIN_PANEL_INIT("admin_panel_initialization"),
    EVENT_ADMIN_SHOW_ADMIN_PANEL("admin_panel_show_admin_panel"),
    EVENT_ADMIN_SHOW_PUBLIC_VIEW("admin_panel_show_public_view"),
    EVENT_ADMIN_WRITE_POST("admin_panel_write_post"),
    EVENT_ADMIN_SHARE_PHOTO("admin_panel_share_photo"),
    EVENT_ADMIN_VIEW_TIMELINE("admin_panel_view_timeline"),
    EVENT_ADMIN_INVITE_OTHERS("admin_panel_invite_others"),
    EVENT_ADMIN_VIEW_POSTS_BY_OTHERS("admin_panel_view_posts_by_others"),
    EVENT_ADMIN_UPSELL_NOTIF("admin_panel_upsell_notifications_row"),
    EVENT_ADMIN_UPSELL_MESSAGE("admin_panel_upsell_messages_row"),
    EVENT_ADMIN_CLICK_PROMOTE("admin_click_promote_page"),
    EVENT_ADMIN_START_ADD_SERVICES_CARD("page_service_card_start_now"),
    EVENT_ADMIN_CLOSE_ADD_SERVICES_CARD("page_service_card_cross_out"),
    EVENT_ADMIN_NUX_SHOP_START("page_nux_shop_start"),
    EVENT_ADMIN_NUX_SHOP_CLOSE("page_nux_shop_cross_out");
    
    private String mEventName;

    private AdminEvent(String str) {
        this.mEventName = str;
    }

    public final String getName() {
        return this.mEventName;
    }

    public final PageEventType getType() {
        return PageEventType.ADMIN;
    }
}
